import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class PowerPlant extends DisplayElement {

public PowerPlant(int num, int numPossibleCities, HashMap<Resource, Integer> resNeeded, int capacity,BufferedImage image, boolean clickable, boolean displayable, Rectangle bound) {
        super(image, clickable, displayable, bound);
        this.num = num;
        this.numPossibleCities = numPossibleCities;
        this.resNeeded = resNeeded;
        this.capacity = capacity;
        //TODO Auto-generated constructor stub
    }

private int num;

private int numPossibleCities;

HashMap <Resource, Integer> resNeeded;

private boolean isPowered;

private int capacity;

public void setCapacity(int in){capacity = in;}

public void storeRes(Player p, String r){}

public void useRes(Player p, String r){}

public int getNum(){return num;}

public void setPoweredStatus(boolean in) {isPowered = in;}

}