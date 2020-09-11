
package labyrintti.tiralabralabyrintti;
import java.util.ArrayDeque;
import java.util.Random;
/**
 * 
 * labyrintin luontiin tarkoitettuja algoritmejä.
 */
public class Labyrintinluoja {
    
       ArrayDeque<pari> pino = new ArrayDeque<pari>();
       boolean[][] kayty;
       Random rand = new Random();
         int[][] uusiLaby;
       
    /**
     * luo labyrintin peruuttavalla haulla.
     * @param laby labyrinttipohja.
     * @return peruuttavalla haulla luotu labyrintti.
     */
    public int[][] peruuttavaHaku(int[][] laby){
         uusiLaby = new int[laby.length][laby.length];
        for (int i = 0; i < uusiLaby.length; i++) {
            for (int j = 0; j < uusiLaby.length; j++) {
                uusiLaby[i][j] = laby[i][j];
            }
        }
        
        kayty = new boolean[laby.length][laby.length];
        
    pino.add(new pari(0,0));
    kayty[0][0] = true;
    while(!pino.isEmpty()){
        
        
        
    
    pari p = pino.peek();
    
    String suunnat = "";
        
        
        for (int i = 0; i < 4; i++) {
            
            if(p.x+3 < uusiLaby.length && !kayty[p.x+3][p.y]) suunnat += 'o';
            
              if(p.y-3 >= 0 && !kayty[p.x][p.y-3]) suunnat += 'y';
              
                if(p.x-3 >= 0 && !kayty[p.x-3][p.y]) suunnat += 'v';
                
                  if(p.y+3 < uusiLaby.length && !kayty[p.x][p.y+3]) suunnat += 'a';
            
            
        }
                if(suunnat.equals("")){
                    pino.pop();
                    continue;
                }
        
            int r = rand.nextInt(suunnat.length());
    suunta(suunnat.charAt(r), p);

        
    }
   
        return uusiLaby;
    }
    
    
    /**
     * palauttaa labyrintin
     * @return labyrintti.
     */
    public int[][] getLaby(){
        return uusiLaby;
    }
    
    /**
     * hoitaa peruuttavassa haussa tarvittavien tietorakenteiden muokkausta annetun suunnan mukaan.
     * @param s suunnan kertova merkki
     * @param p koordinaattipari
     */
    private void suunta(char s,pari p){
        if(s == 'o'){
         
                kayty[p.x+3][p.y]=true;
                pino.add(new pari(p.x+3,p.y));
                
                poistaSeinat(p.x+2, p.y);
                poistaSeinat(p.x+2, p.y+1);
                
                
              
        }
        
        else if(s=='y'){
                kayty[p.x][p.y-3]=true;
                pino.add(new pari(p.x,p.y-3));
                
                 poistaSeinat(p.x, p.y-1);
                poistaSeinat(p.x+1, p.y-1);
                
                
            
        }
        
        else if(s == 'v'){
                kayty[p.x-3][p.y]=true;
                pino.add(new pari(p.x-3,p.y));
                
                   poistaSeinat(p.x-1, p.y);
                poistaSeinat(p.x-1, p.y+1);
                
            
            
        }
        
        else if(s=='a'){
                        
                kayty[p.x][p.y+3]=true;
                pino.add(new pari(p.x,p.y+3));
                
                   poistaSeinat(p.x, p.y+2);
                poistaSeinat(p.x+1, p.y+2);
                
            
        }
        
        else{
            System.out.println(s + " ei oikea suunta");
        }
    }
    /**
     * poistaa labyrintistä seinän 
     * @param x poistettavan seinän x-koordinaatti
     * @param y poistettavan seinän y-koordinaatti
     */
 private void poistaSeinat(int x, int y){

     
    uusiLaby[x][y] = 0;
}
    
    
}



/**
 * koordinaattien käsittelyä helpottava luokka 
 *
 */
class pari{
    int x,y;
    
    /**
     * luo koordinaattiolion
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public pari(int x,int y){
        this.x = x;
        this.y = y;
    }
}

