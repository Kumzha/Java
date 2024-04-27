package Gyvunai;

public class MoveException extends AnimalExceptions{
    public int xCord;
    public int yCord;
    public int zCord;

    public int[] getloc(){
        return new int[] {xCord,yCord,zCord};
    }

    public MoveException() {}

    public MoveException(String message) { super(message); }

    public MoveException(String message, int xCord) {
        super(message);
        this.xCord = xCord;
    }

    public MoveException(String message, int xCord, int yCord) {
        super(message);
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public MoveException(String message, int xCord, int yCord, int zCord) {
        super(message);
        this.xCord = xCord;
        this.yCord = yCord;
        this.zCord = zCord;
    }
}

