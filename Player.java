import java.util.*;

public class Player implements Comparable{
//Variables 
   private ArrayList<PowerPlant> myplants = new ArrayList<>();
   private ArrayList<City> myCities = new ArrayList<>();
   public HashMap<Resource, Integer> myRes = new HashMap<>();   private int elektros; 
   private int numCitiesPowered; 
   private boolean didPass;
   private boolean isFinished; 
   
//Methods
   public void addCity(City city){
      myCities.add(city);
   }

   public void addPlant (PowerPlant plant){
      myplants.add(plant);
   }

   public void removePlants (PowerPlant plant){
      myplants.remove(plant);
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