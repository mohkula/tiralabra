package labyrintti.tiralabralabyrintti;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

/**
 *
 * labyrintin luontiin tarkoitettuja algoritmejä.
 */
public class Labyrintinluoja {

    private Deque<pari> pino = new ArrayDeque<pari>();
    private boolean[][] kayty;
    private Random rand = new Random();
    private int[][] uusiLaby;
    private Labyrintti l = new Labyrintti();

    /**
     * luo labyrintin peruuttavalla haulla.
     *
     * @param laby labyrinttipohja.
     * @return peruuttavalla haulla luotu labyrintti.
     */
    public int[][] peruuttavaHaku(final int[][] laby) {
        uusiLaby = new int[laby.length][laby.length];
        for (int i = 0; i < uusiLaby.length; i++) {
            for (int j = 0; j < uusiLaby.length; j++) {
                uusiLaby[i][j] = laby[i][j];
            }
        }

        kayty = new boolean[laby.length][laby.length];

        pino.push(new pari(0, 0));
        kayty[0][0] = true;
        while (!pino.isEmpty()) {

            pari p = pino.getFirst();

            //System.out.println("pinon p koordinaatit: " +  p.x + " "+ p.y);
            String suunnat = "";
//l.tulostaLabyrintti(uusiLaby);

            if (p.x + 3 < uusiLaby.length && !kayty[p.x + 3][p.y]) {
                suunnat += 'o';
            }

            if (p.y - 3 >= 0 && !kayty[p.x][p.y - 3]) {
                suunnat += 'y';
            }

            if (p.x - 3 >= 0 && !kayty[p.x - 3][p.y]) {
                suunnat += 'v';
            }

            if (p.y + 3 < uusiLaby.length && !kayty[p.x][p.y + 3]) {
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
            suunta(suunnat.charAt(r), p);

            //                      l.tulostaLabyrintti(uusiLaby);
            //  System.out.println("");
        }

        return uusiLaby;
    }

    /**
     * palauttaa labyrintin.
     *
     * @return labyrintti.
     */
    public int[][] getLaby() {
        return uusiLaby;
    }

    /**
     * hoitaa peruuttavassa haussa tarvittavien tietorakenteiden muokkausta
     * annetun suunnan mukaan.
     *
     * @param s suunnan kertova merkki
     * @param p koordinaattipari
     */
    private void suunta(final char s, final pari p) {
        if (s == 'o') {

            // System.out.println("oikealle" + "\n");
            kayty[p.x + 3][p.y] = true;
            pino.push(new pari(p.x + 3, p.y));

            poistaSeinat(p.x + 2, p.y);
            poistaSeinat(p.x + 2, p.y + 1);

        } else if (s == 'y') {
            // System.out.println("ylös" + "\n");
            kayty[p.x][p.y - 3] = true;
            pino.push(new pari(p.x, p.y - 3));

            poistaSeinat(p.x, p.y - 1);
            poistaSeinat(p.x + 1, p.y - 1);

        } else if (s == 'v') {
            //System.out.println("vasemmalle" + "\n");
            kayty[p.x - 3][p.y] = true;
            pino.push(new pari(p.x - 3, p.y));

            poistaSeinat(p.x - 1, p.y);
            poistaSeinat(p.x - 1, p.y + 1);

        } else if (s == 'a') {

            // System.out.println("alas" + "\n");
            kayty[p.x][p.y + 3] = true;
            pino.push(new pari(p.x, p.y + 3));

            poistaSeinat(p.x, p.y + 2);
            poistaSeinat(p.x + 1, p.y + 2);

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
    protected void poistaSeinat(int x, int y) {

        uusiLaby[y][x] = 0;
    }

}

/**
 * koordinaattien käsittelyä helpottava luokka
 *
 */
class pari {

     int x, y;

    /**
     * luo koordinaattiolion
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    pari(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
