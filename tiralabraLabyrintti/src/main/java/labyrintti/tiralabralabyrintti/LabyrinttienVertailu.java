
package labyrintti.tiralabralabyrintti;

import labyrintti.tiralabralabyrintti.graphics.Freimi;


public class LabyrinttienVertailu {

Labyrintinluoja ll;
ReitinHakija rh;
int labyMaara = 1000;
int pisinReittiPeruuttava;
int lyhyinReittiPeruuttava;
    int pisinReittiPrim;
int lyhyinReittiPrim;

int suurinPinonKoko;


//int[][] pisinReittiLaby;
//int[][] lyhyinReittiLaby;

Freimi fr;
Freimi fr2;


public LabyrinttienVertailu(){
    ll = new Labyrintinluoja();
    rh = new ReitinHakija();
    lyhyinReittiPeruuttava = 0;
    pisinReittiPeruuttava = 0;
    pisinReittiPrim = 0;
    lyhyinReittiPrim = 0;
   
    suurinPinonKoko = 0;
    fr = new Freimi(380, 380, 0, 0);
        fr2 = new Freimi(380, 380, 1000, 0);
    
}




public void vertaa(int koko){
    
    String reitti = "";
    int[][] laby;
    System.out.println("generoidaan " + labyMaara + " " +  koko + "X" + koko + " kokoista labyrinttiä peruuttavalla haulla");
    for (int i = 0; i < labyMaara; i++) {
        laby = ll.peruuttavaHaku(koko, koko);
        reitti = rh.haeReittiLeveysHaulla(0, 0, laby, laby.length - 2,laby.length - 2);
        
      
        if(ll.pinonSuurinKoko() > suurinPinonKoko){
            suurinPinonKoko = ll.pinonSuurinKoko();
            
        }
        
        if(reitti.length() > pisinReittiPeruuttava){
            pisinReittiPeruuttava = reitti.length();
          //  pisinReittiLaby = rh.luoReittiLaby(laby, reitti, 0, 0);
        }
        
        if(lyhyinReittiPeruuttava == 0 || lyhyinReittiPeruuttava > reitti.length()){
            lyhyinReittiPeruuttava = reitti.length();
            // lyhyinReittiLaby = rh.luoReittiLaby(laby, reitti, 0, 0);
        }
        
        System.out.println(i);
         
        
        
        
    }
    
     System.out.println("generoidaan " + labyMaara + " " + koko + "X" + koko + " kokoista labyrinttiä Primin algoritmillä");
    for (int i = 0; i < labyMaara; i++) {
        laby = ll.prim(koko, koko);
        reitti = rh.haeReittiLeveysHaulla(0, 0, laby, laby.length - 2,laby.length - 2);
        
        
        if(reitti.length() > pisinReittiPrim){
            pisinReittiPrim = reitti.length();
        }
        
        if(lyhyinReittiPrim == 0 || lyhyinReittiPrim > reitti.length()){
            lyhyinReittiPrim = reitti.length();
        }
        
        
        
        
    }
    
    System.out.println("Suurin pinon koko: " + suurinPinonKoko);
    
    System.out.println("Pisin reitti Peruuttavalla haulla: " + pisinReittiPeruuttava);
        System.out.println("lyhyin reitti Peruuttavalla haulla: " + lyhyinReittiPeruuttava);
            
    System.out.println("Pisin Primin algoritmillä: " + pisinReittiPrim);
        System.out.println("lyhyin reitti Primin algoritmillä: " + lyhyinReittiPrim);
        
        
       // fr.updateGraphics(pisinReittiLaby);
        //fr2.updateGraphics(lyhyinReittiLaby);

}


    
}
