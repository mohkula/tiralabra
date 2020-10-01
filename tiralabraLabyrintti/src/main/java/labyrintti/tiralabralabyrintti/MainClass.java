package labyrintti.tiralabralabyrintti;

import labyrintti.tiralabralabyrintti.graphics.Freimi;
import labyrintti.tiralabralabyrintti.graphics.Ui;
import omatTietorakenteet.*;


public class MainClass {

    public static void main(String[] args) {

        Ui ui = new Ui();
LabyrinttienVertailu lv = new LabyrinttienVertailu();

lv.vertaa(100);


Pino p = new Pino(5);

//p.lisaa(1);
//p.lisaa(2);
//p.lisaa(3);
//p.lisaa(4);
//p.lisaa(5);
//
//while(!p.onkoTyhja()){
//    System.out.println(p.PalautaEka());
//}
//
//
//
//p.lisaa(3);
//p.lisaa(1);
//p.lisaa(2);
//
//while(!p.onkoTyhja()){
//    System.out.println(p.PalautaEka());
//}

    }
}
