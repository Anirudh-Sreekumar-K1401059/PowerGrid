import java.util.ArrayList;
public class City {
    String name;
    String region;
    int spotsTaken;
    int cost;
    boolean isAvailable;
    boolean isValidLoc;
    ArrayList<Player> occupants;
    public void addOccupant(Player player){
        
    }
    public void changeCost(int newCost){
        cost = newCost;
    }
    public boolean isOpen(){
       return true;
    }
}
