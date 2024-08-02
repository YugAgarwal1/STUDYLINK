public class Tournament<Team> {
   Tournament(String name){
           System.out.println("The name of the Tournament is"+name);
   } 
   public <T> void addTeam(T t){
      System.out.println("Team "+t+" added to the tournament ");
   }
}