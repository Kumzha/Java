package NesavitarnosParduotuve;

import java.util.*;

public class Pardaveja extends Kasa {

    public int timeOfTransaction;
    //Sukuriant nurodimi laukai
    public int timeOfListTransaction;
    public int timeOfGoodsTransaction;
    public Pirkejas myPirkejas;

    //Kitu metodu manipuliuojamas laukas
    public boolean occupied = false;

    PriorityQueue<Pirkejas> pq = new PriorityQueue<>();
    

public Pardaveja(){
    super();
}

//process 1
public Pardaveja(int transactionTime){
    super();    
    timeOfTransaction = transactionTime;
}

//process 2
public Pardaveja(int goodsTransaction, int listTransaction){
    super();    
    timeOfGoodsTransaction = goodsTransaction;
    timeOfListTransaction = listTransaction;
}

}