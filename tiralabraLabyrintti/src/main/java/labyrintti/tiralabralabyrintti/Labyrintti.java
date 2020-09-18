package labyrintti.tiralabralabyrintti;

/**
 * Labyrinttipohja.
 */
public class Labyrintti {
    
    private int[][] laby;

    /**
     * konstruktori
     */
    public Labyrintti(){

    }

    /**
     * luo labyrinttipohjan 0 = lattia, 1 = seinä.
     *
     * @param width labyrintin leveys
     * @param height labyrintin korkeus
     */
    public void luoUusiLabyrintti(final int width, final int height) { 
        laby = new int[width * 3 - 1][height * 3 - 1];
        lisaaSeinat();
    }

    /**
     *
     * lisää labyrinttiin seinät
     */
    void lisaaSeinat() { 
        for (int i = 0; i < laby.length; i++) { 
            for (int j = 0; j < laby.length; j++) { 
                if (i == 2 || i % 3 == 2 || j == 2 || j % 3 == 2) { 
                    laby[i][j] = 1;
                }

            }

        }
    }

    /**
     * tulostaa labyrintin
     *
     * @param laby tulostettava labyrintti
     */
    public void tulostaLabyrintti(final int[][] laby) {
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
    public int[][] getLaby() {
        return this.laby;
    }
}
