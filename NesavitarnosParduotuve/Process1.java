package NesavitarnosParduotuve;

import java.util.*;

public class Process1 {

    //Method to check if we rolled bellow or under the set chance for the custommer to arive
    public int chance(double chance){
    
      double chanceNumber = 0;

          chanceNumber = Math.random();
          if(chance>=chanceNumber){return 1;}
      return 0;    
    }    
    

    public static void printStatus(List<Pardaveja> pardavejos){
      int i = 1;

      for(Pardaveja pardaveja : pardavejos){
        System.out.print("\tPardaveja " + i + ":");

        if(pardaveja.occupied == true){ 
          System.out.println(" Aptarnaujamas klientas K" + pardaveja.myPirkejas.ID + ". Liko aptarnauti: " + (pardaveja.myPirkejas.timeToWait+1) + "min");
        }
        else{ 
          System.out.println(" eile tuscia");
        }

        i++;
      }
            
    }
    
    public static void main(String[] args) {

    Queue<Pirkejas> pirkejaiQueue = new LinkedList<>();
     
    List<Pardaveja> pardavejos = new ArrayList<>();

    int numOfPardavejos = 5;

    //sukuriam 5 pardavejas
    for(int i=0;i<numOfPardavejos; i++){
      pardavejos.add(new Pardaveja(3));
    }


  int i = 0;
  System.out.println("Pirmojo veiksmo vykdymas:");

  System.out.println("T = 0min");
  System.out.println("\tBUSENA0:");

  for(int j = 1; j <= numOfPardavejos; j++ ){
    System.out.println("\tPardaveja " + j + ": eile tuscia.");
  }



  while(i<30) {

    System.out.println("\nT = " + (i+1) + "min");

    pirkejaiQueue.add(new Pirkejas(true));

    System.out.println("\tVEIKSMAS" + (i+1));
    for(Pirkejas pirkejas : pirkejaiQueue){
    
      pirkejas.checkForPardaveja(pardavejos);

    }
    i++;

    System.out.println("\tBUSENA" + i);
    Process1.printStatus(pardavejos);
  }

}
}