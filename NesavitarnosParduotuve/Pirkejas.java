package NesavitarnosParduotuve;

import java.util.List;

public class Pirkejas {
    public static int numberOfPirkejas;
    public static int numberOfFinishes;

    public final int ID;
    public Pardaveja myPardaveja;

    public int timeToWait;
    public int timeWaited = 0;

    boolean occupied = false;
    boolean finished = false;

    //Procces nr2
    boolean hasPaid = false;
    boolean listOfGoods = false;
    boolean lastCheck = false;

    //Constructors
    public Pirkejas(){
        ID = ++numberOfPirkejas;
    }

    //Pirmam procesui 
    public Pirkejas(boolean Procces1){
        ID = ++numberOfPirkejas;
        listOfGoods = true;
    }


    //Methods
    //Looking for a seller for the first time
    //Process nr.1
    public int checkForPardaveja(List<Pardaveja> pardavejos){
        
        if(this.finished == true){
            return 0;
        }

        if(this.timeToWait==0&&this.timeWaited>0){
            this.finished = true;
            System.out.println("\tKlientas K" + this.ID + " iseina is parduotuves");
            myPardaveja.occupied = false;
            return 0;
        }

        if(this.timeToWait == 0&&this.finished == false){

            for(Pardaveja pardaveja : pardavejos){
                if(pardaveja.occupied == false){
                    System.out.println("\tKlientas K" + this.ID + " atsistoja i pardavejos: " + pardaveja.ID + " eile");
                    goToPardaveja(pardaveja);
                    this.timeToWait--;
                    return 1;
                }
            }
        } 
        else if(this.timeToWait > 0){
            this.timeWaited++;
            this.timeToWait--;
            return 1;
        }

        //error
        return 2;
    }

    //process 2
    public int checkForPardaveja(List<Pardaveja> pardavejos, List<Kasininke> kasininkes){

        //Check if the customer is finished with his seller/cashier
        for(Pardaveja pardaveja : pardavejos){
            if (pardaveja.myPirkejas != null && pardaveja.myPirkejas.timeToWait == 0){ pardaveja.myPirkejas = null; pardaveja.occupied = false;}
        }
        for(Kasininke kasininke : kasininkes){
            if (kasininke.myPirkejas != null &&kasininke.myPirkejas.timeToWait == 0){ kasininke.myPirkejas = null; kasininke.occupied = false;}
        }

        //Customer is finished
        if(this.finished == true){
            System.out.println("\tKlientas K" + this.ID + " finished");
            return 0;
        }

        //Wait                  condition if the customer has time to wait - he waits
        if(this.timeToWait > 0){
            System.out.println("\tKlientas K" + this.ID + " waitings");
            this.timeToWait--;
            return 1;
        }

        //Leave                 condition turi buti nuejes pas savo pardaveja du kartus
        if(this.lastCheck == true){
            this.finished = true;
            System.out.println("\tKlientas K" + this.ID + " iseina is parduotuves");
            myPardaveja.occupied = false;
            this.timeToWait--;
            return 0;
        }

        //goToPardaveja1st      condition - jei dar neturi pirkiniu saraso
        if(this.listOfGoods == false){
            System.out.println("\tK" + this.ID + " Atsistojo i eile");

            for(Pardaveja pardaveja : pardavejos){
                if(pardaveja.occupied == false){
                    System.out.println("\tKlientas K" + this.ID + " atsistoja i pardavejos: " + pardaveja.ID + " eile");
                    goToPardaveja(pardaveja);
                    this.listOfGoods = true;
                    this.timeToWait--;
                    return 1;
                }
            }

            System.out.println("COULDNT FIND PARDAVEJA");
            return 2; 
        } 
        
        //goToKasininke         condition jei gavo pirkiniu sarasa is pardavejos, bet dar nesusimokejo kasinikei 
        if(this.listOfGoods == true&&this.hasPaid == false){
            checkForKasininke(kasininkes, pardavejos);
            this.hasPaid = true;
            this.timeToWait--;
            return 1;
        }

        //goToPardaveja2nd      condition - susimokejo kasininkei
        if(this.hasPaid == true){
            checkForSpecificPardaveja(pardavejos, this.myPardaveja);
            this.lastCheck = true;
            this.timeToWait--;
            return 1;
        }



        //error
        return 2;
    }

    //Looking for a specific seller after returning from the cashier(carring the id of the seller)
    public void checkForSpecificPardaveja(List<Pardaveja> pardavejos, Pardaveja myPardaveja){

        this.occupied = false;
        while(true){       
            for(Pardaveja pardaveja : pardavejos){
                if(pardaveja == myPardaveja&&pardaveja.occupied == false){
                        this.lastCheck = true;
                        goToPardaveja(pardaveja);
                        System.out.println("\tK" + this.ID + " is at Pardaveja ID: " + this.myPardaveja.ID);
                        //ttw = 1 ++
                        // System.out.println("K" + this.ID + " ttw: " + this.timeToWait);
                        break;
                }
            }
            //ttw = 1;
            // System.out.println("ttw: " + this.timeToWait);
            break;
        }
    }


    //Check for a free kassininke
    public void checkForKasininke(List<Kasininke> kasininkes, List<Pardaveja> pardavejos){



        this.occupied = false;
        for(Kasininke kasininke : kasininkes){
            if(kasininke.occupied == false){
                kasininke.myPirkejas = this;
                System.out.println("\tK" + this.ID + " found kasininke ID: " + kasininke.ID);
                goToKasininke(kasininke);
                break;
            }
        }
        
    }
    

    //Go To Kasininke
    public void goToKasininke(Kasininke kasininke){

        this.timeToWait = kasininke.timeOfMoneyTransaction;
        this.listOfGoods = true;
        this.occupied = true;
        kasininke.occupied = true;

    }


    //Go To Pardaveja 
    public void goToPardaveja(Pardaveja pardaveja){

        this.timeToWait = pardaveja.timeOfTransaction;

        //process 2 
        this.listOfGoods = true;

        pardaveja.myPirkejas = this;
        pardaveja.occupied = true;
        this.occupied = true;
        this.myPardaveja = pardaveja;

    }


    //Leave store
    public void leaveStore(Pardaveja pardaveja){

        System.out.println("Customer, ID: " + this.ID + " Leaving the store");

        pardaveja.occupied = false;

        this.occupied = false;
        this.finished = true;
        numberOfFinishes++;
        System.out.println("aaaa");
    }


    // -------------------------------------------------------------------------------
    // Getters/setters

    public int getNumberOfPirkejas(){  
        return numberOfPirkejas;
    }
    
    public static int getNumberOfFinishes(){  
        return numberOfFinishes;
    }

    public boolean getOccupied(){
        return occupied;
    }

    public void setFinished(boolean finished){
        this.finished = finished;
    }

    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }







}

