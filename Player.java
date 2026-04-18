import java.util.*;

public class Player implements Comparable<Player>{
//Variables 
   private ArrayList<PowerPlant> myPlants = new ArrayList<>();
   public ArrayList<City> myCities = new ArrayList<>();
   public HashMap<Resource, Integer> myRes = new HashMap<>();  
   private int elektros; 
   private int numCitiesPowered; 
   public boolean pass;
   private boolean isFinished; 
   public boolean canChooseAuctionPlant;
   private String color;
   private TreeSet<DisplayElement> playerScreen;
   
    
   public Player(String c) {
	   color = c;
	   elektros = 50;
	   numCitiesPowered = 0;
	   pass = false;
	   isFinished = false; 
	   canChooseAuctionPlant = true;
      myCities = new ArrayList<>();
      myRes = new HashMap<>();
   }
   
//Methods
   public void addCity(City city){
      myCities.add(city);
   }

   public void addPlant (PowerPlant in, PowerPlant out){
      if (out!=null) {
         //transfer resources, update storage capacity, and power capacity
         //extra resources go into Manager.resourceNotInMarket
         //some of the code can be put into removePlant
      } else {
         myPlants.add(in);
      }
   }

   public void removePlant (PowerPlant plant){
      myPlants.remove(plant);
   }

   public void updateElektros(int elektross){
      elektros = elektros + elektross;
   }

   public int getElektros() {
      return elektros;
   }

   public int canPower(){
      return numCitiesPowered;//This is a placeholder right?
   }

   public int getNumCitiesPowered() {
      return numCitiesPowered;
   }

   public void setNumCitiesPowered(int poweredCities) {
      numCitiesPowered = Math.max(0, poweredCities);
   }

   public PowerPlant maxPlant() {
      PowerPlant max = myPlants.get(0);
      for (PowerPlant plant : myPlants) {
         if (plant.getNum() > max.getNum()) {
            max = plant;
         }
      }
      return max;
   } 

   public ArrayList<PowerPlant> getMyPlants() {
      return myPlants;
   }


   @Override
   public int compareTo(Player o) {
      if(this.myCities.size() > o.myCities.size()) {
         return 1;
      } else if(this.myCities.size() < o.myCities.size()) {
         return -1;
      } 
      if(this.maxPlant().getNum() > o.maxPlant().getNum()) {
         return 1;
      } else if(this.maxPlant().getNum() < o.maxPlant().getNum()) {
         return -1;
      }
      return 0;
   }

   public String getColor() {
      return color;
   }

}