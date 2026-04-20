import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;

public class PowerPlant extends DisplayElement {

public PowerPlant(int num, int numPossibleCities, HashMap<Type, Integer> resNeeded, int capacity,BufferedImage image, boolean clickable, boolean displayable, Rectangle bound, Integer layer) {
        super(image, clickable, displayable, bound, layer); 
        this.num = num;
        this.numPossibleCities = numPossibleCities;
        this.resNeeded = resNeeded;
        this.capacity = capacity;
        this.image = 
        //TODO Auto-generated constructor stub
    }


private int num;

private int numPossibleCities;

HashMap <Type, Integer> resNeeded;

private boolean isPowered;

private int capacity;

public void setCapacity(int in){capacity = in;}

public void storeRes(Player p, String r){}

public void useRes(Player p, String r){}

public int getNum(){return num;}

public void setPoweredStatus(boolean in) {isPowered = in;}

public void draw(Graphics2D g)
{
    g.setColor(Color.red);
    if(this==Manager.currentAuctionPlant)
    {
        g.fillRect(Frame.x(this.x-10),Frame.y(this.y-10),Frame.x(this.width+10),Frame.y(this.height+10));
    }
    g.drawImage(this.i,Frame.x(this.x),Frame.y(this.y),Frame.x(this.width),Frame.y(this.height), null);
}

public void click(MouseEvent e)
{
    if(Manager.phase==1&&Manager.currentAuctionPlant==null)
    {
            Manager.currentAuctionPlant=this;
            Manager.highestBidder = Manager.currPlayer;
        
        for(PowerPlant p: Manager.powerPlantMarket)  p.setClickable(false);
        Manager.cost=this.getNum();
    }
    //if(we are bidding)
        //check if a power plant has already been selected and flag the plant as being up for auction
        //make all power plants unclickable
        //set minnimum bid cost as the power plant number
        //
}

}