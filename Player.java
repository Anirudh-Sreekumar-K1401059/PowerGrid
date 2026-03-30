public class Player implements Comparable{
//Variables 
   private ArrayList<PowerPLant> myplants = new ArrayList<>();
   private ArrayList<City> myCities = new ArrayList<>();
   public HashMap<Resources, Integer> myRes = new HashMap<>();
   private int elektros; 
   private int numCitiesPowered; 
   private boolean didPass;
   private boolean isFinished; 
   
   public void addCity(City city){
      City.add(city);
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


   
}