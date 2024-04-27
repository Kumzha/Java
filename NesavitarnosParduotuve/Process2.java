package NesavitarnosParduotuve;

import java.util.*;


public class Process2 {

  public static void printStatus(List<Pardaveja> pardavejos, List<Kasininke> kasininkes){
    int i = 1;
    int j = 1;
  
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

    for(Kasininke kasininke : kasininkes){
      System.out.print("\tKasininke " + j + ":");
  
      if(kasininke.occupied == true){ 
        System.out.println(" Aptarnaujamas klientas K" + kasininke.myPirkejas.ID + ". Liko aptarnauti: " + (kasininke.myPirkejas.timeToWait+1) + "min");
      }
      else{ 
        System.out.println(" eile tuscia");
      }
  
      j++;
    }



          
  }
    public static void main(String[] args) {

      int i = 0;

      PriorityQueue<Pirkejas> pirkejaiQueue = new PriorityQueue<>(0, Comparitor<> listOfGoods);
     
      pirkejaiQueue.add(new Pirkejas());

      List<Pardaveja> pardavejos = new ArrayList<>();
      pardavejos.add(new Pardaveja(1));
      pardavejos.add(new Pardaveja(1));
      pardavejos.add(new Pardaveja(1));


      List<Kasininke> kasininkes = new ArrayList<>();
      kasininkes.add(new Kasininke(1));
      kasininkes.add(new Kasininke(1));

        while(i<5) {

            System.out.println("\nT = " + (i+1) + "min");
                
            System.out.println("\tVEIKSMAS" + (i+1));
            for(Pirkejas pirkejas : pirkejaiQueue){
            
              pirkejas.checkForPardaveja(pardavejos, kasininkes);
        
            }
            i++;
        
            System.out.println("\n\tBUSENA" + i);
            Process2.printStatus(pardavejos, kasininkes);
          }

    }
}
