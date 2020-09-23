package labyrintti.tiralabralabyrintti;

import labyrintti.tiralabralabyrintti.graphics.Freimi;

public class MainClass {

    public static void main(String[] args) {

        Labyrintinluoja ll = new Labyrintinluoja();

        Labyrintti l = new Labyrintti();
        
        ReitinHakija rh = new ReitinHakija();
        
        
        l.luoUusiLabyrintti(3, 3);

       
//        int[][] jaa = ll.peruuttavaHaku(l.getLaby());
       
        int[][] laby = ll.peruuttavaHaku(l.getLaby());
        int[][] labyPrim = ll.prim(l.getLaby());
           Freimi fr = new Freimi(750, 750, laby,1000,0); 
            Freimi f = new Freimi(750, 750, labyPrim,0,0); 
        String s = rh.HaeReittiLeveysHaulla(0, 0, laby , 6 ,6);
        System.out.println(s);  
        s = rh.HaeReittiLeveysHaulla(0, 0, labyPrim, 6, 6);
        System.out.println(s);

    }
}
