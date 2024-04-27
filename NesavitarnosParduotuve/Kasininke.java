package NesavitarnosParduotuve;

public class Kasininke extends Kasa{
    //Kuriant nurodomi variables
    public int timeOfMoneyTransaction;
    public Pirkejas myPirkejas;

    //Kitu klasiu keiciami metodai
    public boolean occupied = false;


    public Kasininke(){
        super();
    }
    public Kasininke(int moneyTransaction){
        super();
        timeOfMoneyTransaction = moneyTransaction;
    }
}
