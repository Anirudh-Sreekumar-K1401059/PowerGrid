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

    public void setGame() {}

    public void setPlayers() {}

    public void setCities() {}

    public void setResources() {}

    public void setimage() {
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

    public void gameState() {}

    public void purchaseRes() {}

    public void bid() {}

    public void pass() {}

    public void determineOrder() {}

    public void earnMoney() {}

    public void refillRes() {}

    public void updateMarket() {}

    public int calculateCost(Type t) { return 0;}
    
    public void nextTurn() {}

    public void phaseOver() {}

    public void stepOver() {}

    public void gameOver() {}



}
