import java.awt.image.BufferedImage;
import java.util.*;
import javax.imageio.ImageIO;

public class Manager{

    ArrayList<PowerPlant> powerPlantDeck;
    TreeMap<Integer, Resource[]> resourceMarket;
    HashMap<Resource, TreeMap<Integer,Resource[]>> market;
    HashMap<Resource, Integer> resourceNotInMarket;
    HashMap<Integer, Integer> income;
    HashMap<Integer, HashMap<Resource, Integer>> resupply;
    ArrayList<Player> playerOrder;
    TreeSet<PowerPlant> powerPlantMarket;
    ArrayList<City> cities;
    ArrayList<String> selectedRegions;
    Map graph;
    int step;
    int phase;
    int turn;
    boolean isStepThree;
    int cost;
    int numPasses;
    boolean isAuctionOver;
    boolean isMaterialBuyingOver;
    boolean isBuildingOver;
    Player currPlayer;

    public static void setGame(){
    	//
    }

    public static void setPlayers() {
    	Player red = new Player ("red");
    	Player blue = new Player ("blue");
    	Player yellow = new Player ("yellow");
    	Player green = new Player ("green");
    	
    	//randomize player order

    	
    }

    public static void setCities() {
    	
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
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }
    
    

    public static void gameState() {}

    public static  void purchaseRes() {}

    public static void bid() {}

    public static  void pass() {}

    public static void determineOrder() {}

    public static void earnMoney() {}

    public static void refillRes() {}

    public static void updateMarket() {}

    public static int calculateCost(Type t) { return 0;}
    
    public static void nextTurn() {}

    public static void phaseOver() {}

    public static void stepOver() {}

    public static void gameOver() {}



}