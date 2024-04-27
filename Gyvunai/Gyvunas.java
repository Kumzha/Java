package Gyvunai;

public abstract class Gyvunas {
    public final int MAX_COORDINATE = 100;
    public final int ID;

    public boolean isAlive = true;

    private static int numOfAnimals = 0;
    public String name = "Gyvunas";
    public int x = 0;
    public int y = 0;

    public Gyvunas(){
        this.ID = ++numOfAnimals;
    }

    public Gyvunas(int x, int y){
        this.x = x;
        this.y = y;
        this.ID = ++numOfAnimals;
    }

    public Gyvunas(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
        this.ID = ++numOfAnimals;
    }

    public int[] getLoc(){
        int[] loc = {this.x,this.y};
        return loc;
    }

    //Overload/uzkloti
    //Exceptions
    public void move(int x) throws MoveException{
    
        if(x < 0 || x > MAX_COORDINATE ){
            throw new MoveException("Invalid coordinates for an animal. Every coordinate must be in range [0, " + MAX_COORDINATE + "]." , x);
        }
        this.x = x;            
}

    public void move(int x, int y) throws MoveException{
            if(x < 0 || x > MAX_COORDINATE || y < 0 || y > MAX_COORDINATE){
                throw new MoveException("Invalid coordinates for an animal. Every coordinate must be in range [0, " + MAX_COORDINATE + "]." , x, y);
            }
            this.x = x;
            this.y = y;        
    }


    //final methods, draudžiama užkloti
    public final void setName(String name){   
        this.name = name;
    }

    public final String getName(){
        return this.name;
    }

    public final int getId(){
        return this.ID;
    }

    //Static methodas
    public static int getNumOfAnimals(){
        return numOfAnimals;
    }

    //toString
    public String toString(){
        
        return "Gyvunas" + " " + this.name + " ID: " + this.ID + " loc: [" + this.x + ", " + this.y + "]";
    }



    //Abstract methodai
    // public abstract void sound();

    
    
}
