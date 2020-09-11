
package labyrintti.tiralabralabyrintti;
/**
 * Labyrinttipohja
 */
public class Labyrintti {
    int[][] laby;
    
    
    /**
     * 
     * 
     * @param width labyrintin leveys
     * @param height labyrintin korkeus
     */
    public Labyrintti(int width, int height){
        laby = new int[width*3 -1][height*3 - 1];
        LisaaSeinat();
    }
    
    
    /**
     * 
     * lisää labyrinttiin seinät
     */
    void LisaaSeinat(){
         for (int i = 0; i < laby.length; i++) {
            for (int j = 0; j < laby.length; j++) {
                if(i==2 || i%3 ==2 || j == 2 ||  j%3 == 2){
                    laby[i][j] = 1;
                }
                
                
            }
            
        }
    }
    
    /**
     * tulostaa labyrintin
     * @param laby tulostettava labyrintti 
     */
    public void tulostaLabyrintti(int[][] laby){
        for (int i = 0; i < laby.length; i++) {
            for (int j = 0; j < laby.length; j++) {
                System.out.print(laby[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * 
     * @return labyrintti 
     */
    public int[][] getLaby(){
        return this.laby;
    }
}
