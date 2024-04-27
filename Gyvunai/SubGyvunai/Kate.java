package Gyvunai.SubGyvunai;

import java.util.List;
import Gyvunai.*;

public class Kate extends Gyvunas implements Predator, Cloneable{
    public int hunger = 0; 

    public Kate(){
        super();    
    }

    public Kate(int x, int y){
        super(x,y);
    }

    public Kate(int x, int y, String name){
        super(x,y);
        this.name = name;
    }

    public void move(int x, int y){
        this.x = 2*x;
        this.y = 2*y;
    }

    public String toString(){
        
        return "Kate" + " " + this.name + " ID: " + this.ID + " loc: [" + this.x + ", " + this.y + "]";
    }

    // @Override
    // public Object clone() throws CloneNotSupportedException {
    //     return super.clone();
    // }

    //Factory methods
    //Tam kad butu galiam exceptionus padaryti, kad neiseitu is grid reziu

    // public static Kate createKateFromXY(int x, int y){
    //     return new Kate(x, y);
    // }

    // public static Kate createKateFromXYName(int x, int y, String name){
    //     return new Kate(x, y, name);
    // }

    @Override
    public boolean attack (List<Gyvunas> gyvunai){
        for(Gyvunas gyvunas : gyvunai){

            int[] locTemp = gyvunas.getLoc();
          if(locTemp[0] == this.x && locTemp[1] == this.y && gyvunas.getId() != this.ID){
            gyvunas.isAlive = false;
            this.hunger += 5;
            return true;
          }
        }
        this.hunger -= 5;
        return false;
    }

}
