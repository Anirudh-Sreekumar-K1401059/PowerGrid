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

    public void setPowerPlants() {
        try{
        BufferedImage p11 = ImageIO.read(Panel.class.getResource("/plantCards/plant11.png"));
        BufferedImage p12 = ImageIO.read(Panel.class.getResource("/plantCards/plant12.png"));
        BufferedImage p13 = ImageIO.read(Panel.class.getResource("/plantCards/plant13.png"));
        BufferedImage p14 = ImageIO.read(Panel.class.getResource("/plantCards/plant14.png"));
        BufferedImage p43 = ImageIO.read(Panel.class.getResource("/plantCards/plant11.png"));
        BufferedImage p44 = ImageIO.read(Panel.class.getResource("/plantCards/plant11.png"));
        BufferedImage p45 = ImageIO.read(Panel.class.getResource("/plantCards/plant11.png"));
        BufferedImage p46 = ImageIO.read(Panel.class.getResource("/plantCards/plant11.png"));
        BufferedImage p47 = ImageIO.read(Panel.class.getResource("/plantCards/plant11.png"));
        BufferedImage p48 = ImageIO.read(Panel.class.getResource("/plantCards/plant11.png"));
        BufferedImage p49 = ImageIO.read(Panel.class.getResource("/plantCards/plant11.png"));
        BufferedImage p50 = ImageIO.read(Panel.class.getResource("/plantCards/plant11.png"));
        }
        catch(Exception e)
        {
            System.out.println(e);
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
