package Gyvunai.SubGyvunai;
import Gyvunai.MoveException;

public interface Prey {
    public void flee(int x, int y, int z) throws MoveException;
}
