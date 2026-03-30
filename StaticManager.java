import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;

public class StaticManager {

    ArrayList<PowerPlane> powerPlantDeck;
    TreeMap<Integer, Resource[]> resourceMarket;
    HashMap<Resource, TreeMap<Integer,Resource[]>> market;
    HashMap<Resource, Integer> resourceNotInMarket;
    HashMap<Integer, Integer> income;
    HashMap<Integer, HashMap<Resource, Integer>> resupply;
    ArrayList<Player> playerOrder;
    ArrayList<PowerPlant> powerPlantMarket;
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

}