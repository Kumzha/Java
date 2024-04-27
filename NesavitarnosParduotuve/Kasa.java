package NesavitarnosParduotuve;

public class Kasa {
    Kasininke kasininke;
    public final int ID;
    public static int numberOfKasa;
    public boolean occupied = false;

    Kasa(){
        ID = ++numberOfKasa;
    }

}
