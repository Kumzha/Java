package Gyvunai.SubGyvunai;

import Gyvunai.*;

public class Paukstis extends Gyvunas implements Prey{

    public int z = 0;

    //Super konstruktoriai
    public Paukstis(){
        super();    
    }
    
    public Paukstis(int x, int y){
        super(x,y);    
    }

    public Paukstis(int x, int y, int z){
        super(x,y);
        this.z = z;
    }

    public Paukstis(int x, int y, int z, String name){
        super(x,y);
        this.z = z;
        this.name = name;
    }
    
    //Super methodas
    public void move(int x, int y, int z) throws MoveException {

            if(x < 0 || x > MAX_COORDINATE || y < 0 || y > MAX_COORDINATE || z < 0 || z > 100){
                throw new MoveException("Invalid coordinates for a  bird. Every coordinate must be in range [0, " + MAX_COORDINATE + "]." , x, y, z);
            }

            super.move(x,y);
            this.z = z;        
    }

    //Papildomas metodas
    public void fly(int z) throws MoveException{
            if(z < 0 || z > 100){
                throw new MoveException("Invalid coordinates for a  bird. Every coordinate must be in range [0, " + MAX_COORDINATE + "].", z);
            }
            this.z = z;
    }


    @Override
    public int[] getLoc() {
        int[] loc = {this.x,this.y,this.z};
        return loc;
    }

    //Uzkota
    @Override
    public String toString(){
        return "Paukstis " + this.name + " ID: " + this.ID + " loc: [" + this.x + ", " + this.y + ", " + this.z + "]";
    }

    @Override
    public void flee (int x, int y, int z) throws MoveException{
        try {
            if(x < 0 || x > MAX_COORDINATE || y < 0 || y > MAX_COORDINATE || z < 0 || z > 100){
                throw new MoveException("Invalid coordinates for a  bird. Every coordinate must be in range [0, " + MAX_COORDINATE + "].", x, y, z);
            }
            this.move(x, y, z);
        } catch (MoveException e) {
            throw new MoveException("Invalid coordinates for a  bird. Every coordinate must be in range [0, " + MAX_COORDINATE + "].", x, y, z);
        }
    }
    
    //Factory methods
    // public static Paukstis createPaukstisFromXYZ(int x, int y, int z){
    //     return new Paukstis(x, y, z);
    // }

    // public static Paukstis createPaukstisFromXY(int x, int y){
    //     return new Paukstis(x, y);
    // }

    // public static Paukstis createPaukstisFromXYZName(int x, int y, int z, String name){
    //     return new Paukstis(x, y, z, name);
    // }
}
    
