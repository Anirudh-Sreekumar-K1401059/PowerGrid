import java.awt.image.BufferedImage;
import java.util.*;
import javax.imageio.ImageIO;

public class Manager{

    static ArrayList<PowerPlant> powerPlantDeck;
    static TreeMap<Integer, Resource[]> resourceMarket;
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

    }

    public static  void pass() {

    }

    public static void determineOrder() {
        
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
        // Logic to update the power plant market and resource market based on the current game state
    	// This may involve moving power plants from the deck to the market, removing purchased plants, and adjusting resource availability
    }

    public static int calculateCost(Type t) { return 0;}
    
    public static void nextTurn() {
        if (playerOrder == null || playerOrder.isEmpty()) {
            return;
        }
        turn = (turn + 1) % playerOrder.size();
        currPlayer = playerOrder.get(turn);
    }

   public void phaseOver() {
    for (Player p : playerOrder) {
        if (p.myCities.size() > 7 && phase < 5) {
            phase++;
            break;
        }
    }
}

    public static void stepOver() {}

    public static void gameOver() {
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
