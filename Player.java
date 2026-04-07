import java.util.*;

public class Player implements Comparable{
//Variables 
   private ArrayList<PowerPlant> myPlants = new ArrayList<>();
   private ArrayList<City> myCities = new ArrayList<>();
   public HashMap<Resource, Integer> myRes = new HashMap<>();  
   private int elektros; 
   private int numCitiesPowered; 
   private boolean didPass;
   private boolean isFinished; 
   private String color;
   
   public Player(String c) {
	   color = c;
	   elektros = 50;
	   numCitiesPowered = 0;
	   didPass = false;
	   isFinished = false; 
	   
   }
   
//Methods
   public void addCity(City city){
      myCities.add(city);
   }

   public void addPlant (PowerPlant plant){
      if (myPlants.size() > 0) {
         // Popup to choose which plant to replace
         int indexToReplace = 0; // Show popup for user to select plant to replace
         myPlants.set(indexToReplace, plant);
      } else {
         myPlants.add(plant);
      }
   }

   public void removePlant (PowerPlant plant){
      myPlants.remove(plant);
   }

   public void updateElektros(int elektross){
      elektros = elektros + elektross;
   }
   public int canPower(){
      return numCitiesPowered;
   }

   @Override
   public int compareTo(Object o) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
   }

}