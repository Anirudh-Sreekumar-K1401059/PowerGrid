import java.awt.image.BufferedImage;
import java.util.*;
import javax.imageio.ImageIO;

public class Manager{

    static ArrayList<PowerPlant> powerPlantDeck;
    static HashMap<Resource, TreeMap<Integer,Resource[]>> market;
    static HashMap<Resource, Integer> resourceNotInMarket;
   static HashMap<Integer, Integer> income;
    static HashMap<Integer, HashMap<Resource, Integer>> resupply;
    static ArrayList<Player> playerOrder;
    static TreeSet<PowerPlant> powerPlantMarket;
    ArrayList<City> cities;
    ArrayList<String> selectedRegions;
    Map graph;
    int step;
    int phase = 1;
    static int turn;
    boolean isStepThree;
    int cost;
    int numPasses;
    boolean isAuctionOver;
    boolean isMaterialBuyingOver;
    boolean isBuildingOver;
    static Player currPlayer;

    
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
        
    }

    public static void setResources() {
    	market.put(Resource.COAL, new TreeMap<Integer, Resource[]>());
    	market.put(Resource.OIL, new TreeMap<Integer, Resource[]>());
        market.put(Resource.TRASH, new TreeMap<Integer, Resource[]>());
        market.put(Resource.URANIUM, new TreeMap<Integer, Resource[]>());
    
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
    }
    
    

    public static void gameState() {

    }

    public static  void purchaseRes() {

    }

    public static void bid() {
        //check if entered number is higher than current bid 
        //if the entered number is higher, set current bid to this
        //if entered number is lower, count it as a pass and numPasses++
        //call currPlayer.updateElektros(-currentBid) to subtract the bid amount from the player's elektros
    


    }

    public static  void pass() {


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

    public static void refillRes() {
        if (playerOrder == null || playerOrder.isEmpty()) {
            return;
        }

        for (Player player : playerOrder) {
            HashMap<Resource, Integer> resupplyForPlayer = resupply.get(player.getColor());
            for (Map.Entry<Resource, Integer> entry : resupplyForPlayer.entrySet()) {
                Resource resource = entry.getKey();
                int quantity = entry.getValue();
                player.myRes.put(resource, player.myRes.getOrDefault(resource, 0) + quantity);
            }
        }
    }

    public static void updateMarket() {
        	//remove the lowest 4 power plants from the market and add 4 new ones from the deck
        	//sort the market based on the number of cities each plant can power
        	//if there is a tie, sort based on the resource requirements, with plants that require fewer resources coming first
        	//if there is still a tie, sort randomly
        	for (int i = 0; i < 4; i++) {
        		powerPlantMarket.pollFirst();
        		if (!powerPlantDeck.isEmpty()) {
        			powerPlantMarket.add(powerPlantDeck.remove(0));
        		}
        	}
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
            if (isAuctionOver) {
                phase = 2;
                System.out.println("Auction phase over. Moving to Resource Buying phase.");
            }
        } else if (phase == 2) {
            // Check if all players have finished buying resources
            if (isMaterialBuyingOver) {
                phase = 3;
                System.out.println("Resource Buying phase over. Moving to Building phase.");
            }
        } else if (phase == 3) {
            // Check if all players have finished building
            if (isBuildingOver) {
                phase = 4;
                System.out.println("Building phase over. Moving to Bureaucracy phase.");
            }
        } else if (phase == 4) {
            // Check if all players have finished the bureaucracy phase
            gameOver();
        }
}


    public static void stepOver() {
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
            System.out.println("Game Over! The winner is: " + winner.getColor());
        }
    }


}
