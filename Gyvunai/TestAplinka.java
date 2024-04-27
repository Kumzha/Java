package Gyvunai;

import Gyvunai.SubGyvunai.*;
import java.util.ArrayList;
import java.util.List;

public class TestAplinka {
    public static void main(String[] args) {

    List<Gyvunas> gyvunai = new ArrayList<>();
        

    Kate k1 = new Kate(1,5, "Kazy");
    gyvunai.add(k1);
    Paukstis p1 = new Paukstis(0, 0, 5, "John");

    System.out.println(k1.toString());
    System.out.println(p1.toString());

    Gyvunas gyvunas1 = k1;
    Gyvunas gyvunas2 = p1;
    System.out.println(gyvunas1.toString());
    System.out.println(gyvunas2.toString());

}
}