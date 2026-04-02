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

    public static void setGame() {}

    public static void setPlayers() {}

    public static void setCities() {}

    public static void setResources() {}

    public static void setimage() {
        try{
        BufferedImage p31 = ImageIO.read(Panel.class.getResource("/image/plant31.png"));
        BufferedImage p32 = ImageIO.read(Panel.class.getResource("/image/plant32.png"));
        BufferedImage p33 = ImageIO.read(Panel.class.getResource("/image/plant33.png"));
        BufferedImage p34 = ImageIO.read(Panel.class.getResource("/image/plant34.png"));
        BufferedImage p35 = ImageIO.read(Panel.class.getResource("/image/plant35.png"));
        BufferedImage p36 = ImageIO.read(Panel.class.getResource("/image/plant36.png"));
        BufferedImage p37 = ImageIO.read(Panel.class.getResource("/image/plant37.png"));
        BufferedImage p38 = ImageIO.read(Panel.class.getResource("/image/plant38.png"));
        BufferedImage p39 = ImageIO.read(Panel.class.getResource("/image/plant39.png"));
        BufferedImage p40 = ImageIO.read(Panel.class.getResource("/image/plant40.png"));
                      p34 = ImageIO.read(Panel.class.getResource("/image/plant34.png"));
       // BufferedImage p4 = ImageIO.read(Panel.class.getResource("/image/plant11.png"));
        //BufferedImage p50 = ImageIO.read(Panel.class.getResource("/image/plant11.png"));
        }
        catch(Exception e)
        {
            System.out.println("The power plant import code does not work "+e);
        }
      /*  powerPlantDeck = new ArrayList<PowerPlant>
        (Arrays.asList(
            //each power plant
            new PowerPlant() //plant 03
        ));*/
    }

    public static void gameState() {}

    public static void purchaseRes() {}

    public static void bid() {}

    public static void pass() {}

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
