package labyrintti.tiralabralabyrintti;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import java.util.ArrayList;

/**
 *
 * labyrintin luontiin tarkoitettuja algoritmejä.
 */
public class Labyrintinluoja {

    private Deque<Koordinaatit> pino;
    
    private Random rand = new Random();
    
    private int[][] peruuttava;
    private int[][] prim;
    
    
    
    private Labyrintti l = new Labyrintti();

    /**
     * luo labyrintin peruuttavalla haulla.
     *
     * @param laby labyrinttipohja.
     * @return peruuttavalla haulla luotu labyrintti.
     */
    public int[][] peruuttavaHaku(final int[][] laby) {
        
        pino = new ArrayDeque<Koordinaatit>();
        
        peruuttava = new int[laby.length][laby.length];
        for (int i = 0; i < peruuttava.length; i++) {
            for (int j = 0; j < peruuttava.length; j++) {
                peruuttava[i][j] = laby[i][j];
            }
        }

         boolean[][] kayty = new boolean[laby.length][laby.length];

        pino.push(new Koordinaatit(0, 0));
        kayty[0][0] = true;
        while (!pino.isEmpty()) {

            Koordinaatit p = pino.getFirst();

            //System.out.println("pinon p koordinaatit: " +  p.x + " "+ p.y);
            String suunnat = "";
//l.tulostaLabyrintti(uusiLaby);

            if (p.x + 3 < peruuttava.length && !kayty[p.x + 3][p.y]) {
                suunnat += 'o';
            }

            if (p.y - 3 >= 0 && !kayty[p.x][p.y - 3]) {
                suunnat += 'y';
            }

            if (p.x - 3 >= 0 && !kayty[p.x - 3][p.y]) {
                suunnat += 'v';
            }

            if (p.y + 3 < peruuttava.length && !kayty[p.x][p.y + 3]) {
                suunnat += 'a';
            }

            if (suunnat.equals("")) {
                //  System.out.println("ei suuntia" + "\n");
                pino.pollFirst();

                // l.tulostaLabyrintti(uusiLaby);
                //   System.out.println("");
                continue;
            }

            //  System.out.println(suunnat + "\n");
            int r = rand.nextInt(suunnat.length());
            //  System.out.println(suunnat.charAt(r));
            suunta(suunnat.charAt(r), p, peruuttava, kayty);

            //                      l.tulostaLabyrintti(uusiLaby);
            //  System.out.println("");
        }

        return peruuttava;
    }
    
    
    /**
     * 
     * Luo labyrintin Primin algoritmillä.
     * 
     * 
     * @param laby labyrinttipohja
     * @return Primin algoritmillä luotu labyrintti 
     */
    public int[][] prim(final int[][] laby){
        
         
        prim = new int[laby.length][laby.length];
        for (int i = 0; i < prim.length; i++) {
            for (int j = 0; j < prim.length; j++) {
                prim[i][j] = laby[i][j];
            }
        }
        
        
        int[][] tilat = new int[laby.length][laby.length];
        ArrayList<Koordinaatit> etu = new ArrayList<>();
        
        tilat[0][0] = 1;
        
        Koordinaatit k= new Koordinaatit(0,0);
        
        
        lisaaEtuun(k, tilat, etu);
//l.tulostaLabyrintti(uusiLaby);

            
            while(!etu.isEmpty()){
            int r  = rand.nextInt(etu.size());
            
            Koordinaatit uusiSolu = etu.get(r);
            
            tilat[uusiSolu.x][uusiSolu.y] = 1;
            
            etu.remove(r);
            
                lisaaEtuun(uusiSolu, tilat, etu);
            
            
            String suunnat = "";
            
             if (uusiSolu.x + 3 < prim.length && tilat[uusiSolu.x + 3][uusiSolu.y]==1) {
                suunnat += 'o';
                
                
            }

            if (uusiSolu.y - 3 >= 0 && tilat[uusiSolu.x][uusiSolu.y - 3] == 1) {
                suunnat += 'y';
                
                
                
            }

            if (uusiSolu.x - 3 >= 0 && tilat[uusiSolu.x - 3][uusiSolu.y] == 1) {
                suunnat += 'v';
             
               
            }

            if (uusiSolu.y + 3 < prim.length && tilat[uusiSolu.x][uusiSolu.y + 3] == 1) {
                suunnat += 'a';
                
                
                
            }
            
       r = rand.nextInt(suunnat.length());
            
       lisaaSolu(suunnat.charAt(r), uusiSolu, prim);
            
            }
            
            
             return prim;


            
            
        
        
    }
    
    
    public void lisaaEtuun(Koordinaatit k, int[][] tilat, ArrayList<Koordinaatit> etu){
        
        
            if (k.x + 3 < prim.length && tilat[k.x + 3][k.y]==0) {
                //suunnat += 'o';
                
                etu.add(new Koordinaatit(k.x + 3, k.y ));
                tilat[k.x + 3][k.y]= 2;
            }

            if (k.y - 3 >= 0 && tilat[k.x][k.y - 3] == 0) {
                //suunnat += 'y';
                etu.add(new Koordinaatit(k.x, k.y-3 ));
                tilat[k.x][k.y - 3]= 2;
                
                
            }

            if (k.x - 3 >= 0 && tilat[k.x - 3][k.y] == 0) {
               // suunnat += 'v';
               
               etu.add(new Koordinaatit(k.x - 3, k.y ));
                tilat[k.x - 3][k.y]= 2;
               
            }

            if (k.y + 3 < prim.length && tilat[k.x][k.y + 3] == 0) {
                //suunnat += 'a';
                
                etu.add(new Koordinaatit(k.x, k.y + 3 ));
                tilat[k.x][k.y + 3 ]= 2;
                
            }
            
        
    }
    
    
    public void lisaaSolu(char s, Koordinaatit k, int[][] prim){
        
         if (s == 'o') {
            poistaSeinat(k.x + 2, k.y, prim);
            poistaSeinat(k.x + 2, k.y + 1, prim);

        } else if (s == 'y') {
           

            poistaSeinat(k.x, k.y - 1, prim);
            poistaSeinat(k.x + 1, k.y - 1, prim);

        } else if (s == 'v') {
           

            poistaSeinat(k.x - 1, k.y, prim);
            poistaSeinat(k.x - 1, k.y + 1, prim);

        } else if (s == 'a') {

       
            poistaSeinat(k.x, k.y + 2, prim);
            poistaSeinat(k.x + 1, k.y + 2, prim);

        } else {
            System.out.println(s + " ei oikea suunta");
        }
        
        
    }
    
    

    /**
     * palauttaa labyrintin.
     *
     * @return labyrintti.
     */
    public int[][] getLaby(char c) {
        
        if(c == 'r'){
            return peruuttava;
        }
        
        else if(c == 'p'){
            return prim;
        }
        return null;
    }

    /**
     * hoitaa peruuttavassa haussa tarvittavien tietorakenteiden muokkausta
     * annetun suunnan mukaan.
     *
     * @param s suunnan kertova merkki
     * @param p koordinaattipari
     */
    protected void suunta(final char s, final Koordinaatit p, int[][] laby, boolean[][] kayty) {
        if (s == 'o') {

            kayty[p.x + 3][p.y] = true;
            pino.push(new Koordinaatit(p.x + 3, p.y));

            poistaSeinat(p.x + 2, p.y, laby);
            poistaSeinat(p.x + 2, p.y + 1, laby);

        } else if (s == 'y') {
            kayty[p.x][p.y - 3] = true;
            pino.push(new Koordinaatit(p.x, p.y - 3));

            poistaSeinat(p.x, p.y - 1, laby);
            poistaSeinat(p.x + 1, p.y - 1, laby);

        } else if (s == 'v') {
            kayty[p.x - 3][p.y] = true;
            pino.push(new Koordinaatit(p.x - 3, p.y));

            poistaSeinat(p.x - 1, p.y, laby);
            poistaSeinat(p.x - 1, p.y + 1, laby);

        } else if (s == 'a') {

            kayty[p.x][p.y + 3] = true;
            pino.push(new Koordinaatit(p.x, p.y + 3));

            poistaSeinat(p.x, p.y + 2, laby);
            poistaSeinat(p.x + 1, p.y + 2, laby);

        } else {
            System.out.println(s + " ei oikea suunta");
        }
    }

    /**
     * poistaa labyrintistä seinän.
     *
     * @param x poistettavan seinän x-koordinaatti
     * @param y poistettavan seinän y-koordinaatti
     */
    protected void poistaSeinat(int x, int y, int[][] laby) {

        laby[y][x] = 0;
    }
    
    protected Deque getPino(){
        return pino;
    }

}

