package labyrintti.tiralabralabyrintti;

import labyrintti.tiralabralabyrintti.graphics.Freimi;
import labyrintti.tiralabralabyrintti.graphics.Ui;
import omatTietorakenteet.Jono;

public class MainClass {

    public static void main(String[] args) {

        
        Jono j = new Jono(5);
        System.out.println(j.getSize());
        j.lisaa(1);
        
        j.lisaa(2);
        j.lisaa(3);

        j.lisaa(4);

        j.lisaa(5);
                System.out.println("koko" + j.getSize());
      Object i = j.palautaJaPoistaEka();
        System.out.println(i);
          i = j.palautaJaPoistaEka();
        System.out.println(i);
        System.out.println("koko" + j.getSize());
         i = j.palautaJaPoistaEka();
                  i = j.palautaJaPoistaEka();
                          System.out.println(i);
System.out.println("koko" + j.getSize());

        Ui ui = new Ui();

    }
}
