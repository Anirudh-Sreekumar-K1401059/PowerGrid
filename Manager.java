import java.awt.image.BufferedImage;
import java.util.*;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileNotFoundException;


public class Manager{

    static ArrayList<PowerPlant> powerPlantDeck;
    static HashMap<Type, TreeMap<Integer,ArrayList<Resource>>> market;
    static HashMap<Type, Integer> resourceNotInMarket;
   static HashMap<Integer, Integer> income;

    static HashMap<Integer, HashMap<Type, Integer>> resupply;
        //first integer is step
        //hashmap is <the resource, the amount needed to be put back into the market>

    
    static ArrayList<Player> playerOrder;
    static TreeSet<PowerPlant> powerPlantMarket;
    static PowerPlant currentAuctionPlant;
    static ArrayList<City> cities;
    static ArrayList<String> selectedRegions;
    static int step;
    static int phase = 1;
    static int turn;
    static boolean isStepThree;
    static int cost; 
    static int numPasses;
    /*static boolean isTurnOrderOver;
    static boolean isAuctionOver;
    static boolean isMaterialBuyingOver;
    static boolean isBuildingOver;
   */ static boolean isBuracreacyOver;
    static Player currPlayer;

   public void createResupply() {   //4 player 

    resupply = new HashMap<>();

    // Step 1
    resupply.put(1, new HashMap<>());
    resupply.get(1).put(Type.COAL, 5);
    resupply.get(1).put(Type.OIL, 3);
    resupply.get(1).put(Type.TRASH, 2);
    resupply.get(1).put(Type.URANIUM, 1);

    // Step 2
    resupply.put(2, new HashMap<>());
    resupply.get(2).put(Type.COAL, 6);
    resupply.get(2).put(Type.OIL, 4);
    resupply.get(2).put(Type.TRASH, 3);
    resupply.get(2).put(Type.URANIUM, 2);

    // Step 3
    resupply.put(3, new HashMap<>());
    resupply.get(3).put(Type.COAL, 4);
    resupply.get(3).put(Type.OIL, 5);
    resupply.get(3).put(Type.TRASH, 4);
    resupply.get(3).put(Type.URANIUM, 2);
}
    
    public static void setGame(){
    	//
    }

    public static void setPlayers() {
    	Player red = new Player ("red");
    	Player blue = new Player ("blue");
    	Player yellow = new Player ("yellow");
    	Player green = new Player ("green");
    	
    	//randomize player order
        playerOrder.add(red);
        playerOrder.add(blue);
        playerOrder.add(yellow);
        playerOrder.add(green);
        Collections.shuffle(playerOrder);
    	
    }

    public static void setCities(LinkedList<String> selectedRegions) {
           //use scanner for everything
        //if the region color is in the linkedlist:
            //read the city name and make a new object if it doesn't already exist in the class arraylist called cities
            //then read the following integer and keep it in a temporary variable 
            //read the connecting city region color. if its in selectedRegions:
                //check if the city is in the class variable 
    
        try {
            Scanner scanner = new Scanner(new java.io.File("CitiesText/Cities.txt"));
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                
                String[] parts = line.split(" \\| ");
                
                String[] cityParts = parts[0].trim().split(" ", 2);
                String region = cityParts[0];
                String cityName = cityParts[1];
                
                // Check if region is in selectedRegions
                if (!selectedRegions.contains(region)) continue;
                
                // Create or find the city
                City city = null;
                for (City c : cities) {
                    if (c.name.equals(cityName) && c.region.equals(region)) {
                        city = c;
                        break;
                    }
                }
                if (city == null) {
                    city = new City(cityName, region);
                    cities.add(city);
                }
                
                for (int i = 1; i < parts.length; i++) {
                    String[] connectionParts = parts[i].trim().split(", ");
                    int cost = Integer.parseInt(connectionParts[connectionParts.length - 1]);
                    
                    String[] connectedCityParts = connectionParts[0].split(" ", 2);
                    String connectedRegion = connectedCityParts[0];
                    String connectedCityName = connectedCityParts[1];
                    
                    // Check if connected city's region is in selectedRegions
                    if (!selectedRegions.contains(connectedRegion)) continue;
                    
                    // Find or create connected city
                    City connectedCity = null;
                    for (City c : cities) {
                        if (c.name.equals(connectedCityName) && c.region.equals(connectedRegion)) {
                            connectedCity = c;
                            break;
                        }
                    }
                    if (connectedCity == null) {
                        connectedCity = new City(connectedCityName, connectedRegion);
                        cities.add(connectedCity);
                    }
                    
                    // Add connection
                    city.connections.put(connectedCity, cost);
                }
            }
            
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Cities.txt file not found");
        }
    }

    public static void setResources() {
        //creating all of the markets to access later
    	market.put(Type.COAL, new TreeMap<Integer, ArrayList<Resource>>());
    	market.put(Type.OIL, new TreeMap<Integer, ArrayList<Resource>>());
        market.put(Type.TRASH, new TreeMap<Integer, ArrayList<Resource>>());
        market.put(Type.URANIUM, new TreeMap<Integer, ArrayList<Resource>>());
        //Adding the first 8 tiles
        for(int i=0;i<8;i++)
        {
            market.get(Type.COAL).put(i,new ArrayList<Resource>());
            market.get(Type.OIL).put(i,new ArrayList<Resource>());
            market.get(Type.TRASH).put(i,new ArrayList<Resource>());
            market.get(Type.URANIUM).put(i,new ArrayList<Resource>());
        }
        //Uranium slots 10 12 14 16
        for(int i=0;i<4;i++)
            market.get(Type.URANIUM).put(10+(i*2),new ArrayList<Resource>());
    }

    /*adds the resources to the market at the lowest avaliable cost
    Type t: the type of resource
    int amount: the number of resources to add to the market
    */
    public static void addMarketResource(Type t, int amount)
    {
        Integer reserves = resourceNotInMarket.get(t);//the number of resources of type t that can be added to the market
        TreeMap<Integer,ArrayList<Resource>> subMarket = market.get(t); // The market for only type t
        Iterator<Integer> marketIter = subMarket.descendingKeySet().iterator();// used to iterate backwards through the market
        int price = marketIter.next();// the price section currently being looked at
        while(price>0)//iterate through all of the price sections
        {
            int capacity = marketCapacity(t,price);// how many resources can be of a certain price
            ArrayList<Resource> subTile = subMarket.get(price);// all the resources of that price
            for(int j=0;j<capacity;j++)// iterate through subTile
            {
                if(subTile.size()!=capacity)// redundancy to make sure ArrayList does not overflow
                //if this still does not work, I will switch back to Resource[]
                {
                subTile.add(new Resource(t));
                reserves--;//this will update the reserves in resourceNotInMarket
                }
            }
        }
    }

    public static int marketCapacity(Type t, int price)
	{
		if(price<0||price>16)
			return -1;
		if(t!=Type.URANIUM&&price<9)
			return 3;
		else if(t==Type.URANIUM)
		{
			if(price>8&&price%2==1)
				return -1;
			return 1;
		}
        System.out.println("marketCapacity returns -2. Manager 89");
		return -2;
	}

    
    
    public static void setPowerPlants() {
        try{
        BufferedImage p11 = ImageIO.read(Panel.class.getResource("/plantCards/plant11.png"));
        BufferedImage p12 = ImageIO.read(Panel.class.getResource("/plantCards/plant12.png"));
        BufferedImage p13 = ImageIO.read(Panel.class.getResource("/plantCards/plant13.png"));
        BufferedImage p14 = ImageIO.read(Panel.class.getResource("/plantCards/plant14.png"));
        BufferedImage p15 = ImageIO.read(Panel.class.getResource("/plantCards/plant15.png"));
        BufferedImage p16 = ImageIO.read(Panel.class.getResource("/plantCards/plant16.png"));
        BufferedImage p17 = ImageIO.read(Panel.class.getResource("/plantCards/plant17.png"));
        BufferedImage p18 = ImageIO.read(Panel.class.getResource("/plantCards/plant18.png"));
        BufferedImage p19 = ImageIO.read(Panel.class.getResource("/plantCards/plant19.png"));
        BufferedImage p20 = ImageIO.read(Panel.class.getResource("/plantCards/plant20.png"));
        BufferedImage p21 = ImageIO.read(Panel.class.getResource("/plantCards/plant21.png"));
        BufferedImage p22 = ImageIO.read(Panel.class.getResource("/plantCards/plant22.png"));
        BufferedImage p23 = ImageIO.read(Panel.class.getResource("/plantCards/plant23.png"));
        BufferedImage p24 = ImageIO.read(Panel.class.getResource("/plantCards/plant24.png"));
        BufferedImage p25 = ImageIO.read(Panel.class.getResource("/plantCards/plant25.png"));
        BufferedImage p26 = ImageIO.read(Panel.class.getResource("/plantCards/plant26.png"));
        BufferedImage p27 = ImageIO.read(Panel.class.getResource("/plantCards/plant27.png"));
        BufferedImage p28 = ImageIO.read(Panel.class.getResource("/plantCards/plant28.png"));
        BufferedImage p29 = ImageIO.read(Panel.class.getResource("/plantCards/plant29.png"));
        BufferedImage p30 = ImageIO.read(Panel.class.getResource("/plantCards/plant30.png"));
        BufferedImage p31 = ImageIO.read(Panel.class.getResource("/plantCards/plant31.png"));
        BufferedImage p32 = ImageIO.read(Panel.class.getResource("/plantCards/plant32.png"));
        BufferedImage p33 = ImageIO.read(Panel.class.getResource("/plantCards/plant33.png"));
        BufferedImage p34 = ImageIO.read(Panel.class.getResource("/plantCards/plant34.png"));
        BufferedImage p35 = ImageIO.read(Panel.class.getResource("/plantCards/plant35.png"));
        BufferedImage p36 = ImageIO.read(Panel.class.getResource("/plantCards/plant36.png"));
        BufferedImage p37 = ImageIO.read(Panel.class.getResource("/plantCards/plant37.png"));
        BufferedImage p38 = ImageIO.read(Panel.class.getResource("/plantCards/plant38.png"));
        BufferedImage p39 = ImageIO.read(Panel.class.getResource("/plantCards/plant39.png"));
        BufferedImage p40 = ImageIO.read(Panel.class.getResource("/plantCards/plant40.png"));
        BufferedImage p44 = ImageIO.read(Panel.class.getResource("/plantCards/plant44.png"));
        BufferedImage p46 = ImageIO.read(Panel.class.getResource("/plantCards/plant46.png"));
        BufferedImage p50 = ImageIO.read(Panel.class.getResource("/plantCards/plant50.png"));
        }
        catch(Exception e) {
            System.out.println("Error");
        }
        
 try {
            File file = new File("Powerplants.txt"); 
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    String[] parts = line.split("//|");
                    int number = Integer.parseInt(parts[1]);
                
                    int citiesPowered = Integer.parseInt(parts[0]);
                    int price = Integer.parseInt(parts[1]);
                      Type resourceType = Type.valueOf(parts[1].toUpperCase());
                int resourceAmount = Integer.parseInt(parts[2]);
                    //powerPlantDeck.add(new PowerPlant(number, resourceType, resourceAmount, citiesPowered, cost));
                    
                  
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close(); // Close scanner
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        

      /*  Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(", ");
            int number = Integer.parseInt(parts[0]);
            Type resourceType = Type.valueOf(parts[1].toUpperCase());
            int resourceAmount = Integer.parseInt(parts[2]);
            int citiesPowered = Integer.parseInt(parts[3]);
            int cost = Integer.parseInt(parts[4]);
            powerPlantDeck.add(new PowerPlant(number, resourceType, resourceAmount, citiesPowered, cost));
        }*/

        //AYAAN: make sure to add the power plants to the deck in the correct order, and make sure the first 8 power plants are added to the market and are displayable and clickable (make sure whens setting up the auction ,its in acending order and then shuffle the rest of the deck and add it to the class variable powerPlantDeck)

    }
    
    public static void auction() {
        
    }

    public static String purchaseCity(City wanted) {
        //if player has bought at least one city:
            if(currPlayer.myCities.size()>0) {
                for(City c: currPlayer.myCities) {
                    if(c.connections.containsKey(wanted)) {
                        int connectionCost = c.connections.get(wanted);
                        int totalCost = connectionCost + wanted.cost;
                        if(currPlayer.getElektros() >= totalCost) {
                            currPlayer.updateElektros(-totalCost);
                            currPlayer.myCities.add(wanted);
                            return "City purchased: " + wanted.name;
                        } else {
                            return "Cannot afford city";
                        }
                    }
                }
                return "No connected city owned by player";
            } else {
                //if player has not bought a city, they can buy any city for its price
                if(currPlayer.getElektros() >= wanted.cost) {
                    currPlayer.updateElektros(-wanted.cost);
                    currPlayer.myCities.add(wanted);
                    return "City purchased: " + wanted.name;
                } else {
                    return "Cannot afford city";
                }
            }
            //find a city that is connected to wanted and is owned by the currPlayer 
            //use the class variable, cost, to add the connection price AND the wanted's price
            //check if player is at least that many elektros
            //if they can't return string "cannot afford", else return String of city they bought
       // }

    public static void changeGameState() {
        /*static int step;
    static int phase = 1;
    static int turn;
    static boolean isStepThree;
    static int cost;
    static int numPasses;
    
    static Player currPlayer;
    */
    }

   public static void purchaseRes(Type t, int re) { // re is the amount of that certain resource they bought 
        TreeMap<Integer, ArrayList<Resource>> subMarket = market.get(t);
        int totalCost = 0;
        ArrayList<Resource> purchased = new ArrayList<>();
        
        // Get the cheapest resources from the market
        for (Integer price : subMarket.keySet()) {
            ArrayList<Resource> resourcesAtPrice = subMarket.get(price);
            while (purchased.size() < re && !resourcesAtPrice.isEmpty()) {
                Resource res = resourcesAtPrice.remove(0);
                purchased.add(res);
                totalCost += price;
            }
            if (purchased.size() == re) break;
        }
        
        // Check if we got enough resources
        if (purchased.size() < re) {
            System.out.println("Not enough resources in market");
            return;
        }
        
        // Check if player has enough elektros
        if (currPlayer.getElektros() >= totalCost) {
            // Add resources to player's inventory
            for (Resource res : purchased) {
                if (currPlayer.myRes.containsKey(res)) {
                    currPlayer.myRes.put(res, currPlayer.myRes.get(res) + 1);
                } else {
                    currPlayer.myRes.put(res, 1);
                }
            }
            currPlayer.updateElektros(-totalCost);
        } else {
            System.out.println("Not enough elektros to purchase resource");
        }
    } 
    
/*1.bid method
			1.1: numPasses has to wrap around to 0
			1.2: currPlayer gets the powerPlant
			1.3: updateMarket
			1.4: If the player does not have enough money, output false and do not allow the bid to go through

		3. Updatemarket
			3.1: add frontEnd to updateMarket
			3.2: make sure market is being updated correctly based on the step
			3.3: Make the power plant displayable and clickable, and make sure the player can click on the power plant to buy it */

    public static void bid(int offer) {
        //check if offer is higher than current bid 
        //if offer is higher, set current bid to this
        //if offer is lower, count it as a pass and numPasses++
        //call currPlayer.updateElektros(-currentBid) to subtract the bid amount from the player's elektros

    }

    

    public static void determineOrder() {
        	//sort player order based on the power plant they have with the lowest number
        	//if there is a tie, sort based on the second lowest plant, and so on
        	//if there is still a tie, sort randomly
        	Collections.sort(playerOrder);
        	Collections.shuffle(playerOrder);
        	currPlayer = playerOrder.get(0);
        	turn = 1;
        	System.out.println("Player order: ");
        	for (Player player : playerOrder) {
        		System.out.println(player.getColor());
        	}
    }

    public static void earnMoney() {
        if (playerOrder == null || playerOrder.isEmpty()) {
            return;
        }

        for (Player player : playerOrder) {
            int citiesPowered = player.canPower();
            int earned = calculateIncome(citiesPowered);
            player.updateElektros(earned);
        }
    }

    private static int calculateIncome(int citiesPowered) {
        return Math.max(0, citiesPowered * 10);
    }

    public static void refillRes() { //what does this method do. add comments to the code
/* WHAT THIS METHOD DOES"
    -references the hashmap called resupply and puts the correct amount of resources back into the market (it depends on the step and the resource)
    -this happens at the end of buracreacy
*/
    //static HashMap<Type, TreeMap<Integer,ArrayList<Resource>>> market

    addMarketResource(Type.URANIUM, resupply.get(step).get(Type.URANIUM));
    addMarketResource(Type.COAL, resupply.get(step).get(Type.COAL));
    addMarketResource(Type.OIL, resupply.get(step).get(Type.OIL));
    addMarketResource(Type.TRASH, resupply.get(step).get(Type.TRASH));
    }

    public static void updateMarket() {
        	
    }

    public static int calculateCost(Type t) { return 0;}
    
    public static void nextTurn() {
        if(turn==1) {
            currPlayer = playerOrder.get(1); //if the current player is the first, this sets currPlyaer to the second one
            turn=2;
        } else if(turn==2) {
            currPlayer = playerOrder.get(2); //if the current player is the second, this sets currPlyaer to the third one
        } else if(turn==3) {
            currPlayer = playerOrder.get(3); //if the current player is the third, this sets currPlyaer to the fourth one
        } else if(turn==4) {
            currPlayer = playerOrder.get(0); //if the current player is the fourth, this sets currPlyaer to the first one
            turn=1;
        }
    }

   public void phaseOver() {
        if (phase == 1) {
            // Check if all players have passed in the auction phase
            if (turn==4) {
                phase = 2;
                System.out.println("Auction phase over. Moving to Resource Buying phase.");
            }
        } else if (phase == 2) {
            // Check if all players have finished buying resources
            if (turn==4) {
                phase = 3;
                System.out.println("Resource Buying phase over. Moving to Building phase.");
            }
        } else if (phase == 3) {
            // Check if all players have finished building
            if (turn==4) {
                phase = 4;
                System.out.println("Building phase over. Moving to Bureaucracy phase.");
            }
        } else if (phase == 4) {
            // Check if all players have finished the bureaucracy phase
            gameOver();
        }
}


    public  void stepOver() {
        if (step == 1) {
            step = 2;
            System.out.println("Step 1 over. Moving to Step 2.");
        } else if (step == 2) {
            step = 3;
            System.out.println("Step 2 over. Moving to Step 3.");
        } else if (step == 3) {
            step = 1;
            System.out.println("Step 3 over. Moving back to Step 1.");
        }
    }

    public void gameOver() {
        if (phase >= 5) {
            Player winner = null;
            int maxCities = -1;
            for (Player player : playerOrder) {
                int citiesPowered = player.canPower();
                if (citiesPowered > maxCities) {
                    maxCities = citiesPowered;
                    winner = player;
                }
            }
            System.out.println("Game Over! The winner is: " + winner.getColor()); //repplace with with opening the end game panel 
        }
    }


}
