import java.util.*;



public class City {
    String name;
    String region;
    int spotsTaken;
    int cost;
    boolean isAvailable;
    boolean isValidLoc;
    ArrayList<Player> occupants;
    
    HashMap<City, Integer> connections;
    
    public City(String n, String r) {
    	name =n;
        region = r;
        spotsTaken = 0;
        cost = 10;
        isAvailable = true;
       // isValidLoc;
        occupants = new ArrayList<>();
       connections = new HashMap<>();
    }
    public void addOccupant(Player player){
        
    }
    public void changeCost(int newCost){
        cost = newCost;
    }
    public boolean isOpen(){
       return true;
    }
}