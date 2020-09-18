
package labyrintti.tiralabralabyrintti;

import labyrintti.tiralabralabyrintti.graphics.Freimi;

public class MainClass {
    
    public static void main(String[] args){
        
       Labyrintinluoja ll = new Labyrintinluoja();
       
      
        Labyrintti l = new Labyrintti();
        l.luoUusiLabyrintti(32, 32);
        
        //l.tulostaLabyrintti(l.getLaby());
        
        
       int[][] jaa =  ll.peruuttavaHaku(l.getLaby());
        Freimi f = new Freimi(1520,1520, jaa);   
       // l.tulostaLabyrintti(jaa);
        
    }
}
