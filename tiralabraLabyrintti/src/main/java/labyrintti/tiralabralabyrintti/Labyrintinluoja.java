package labyrintti.tiralabralabyrintti;

import omatTietorakenteet.ArrayLista;
import omatTietorakenteet.Pino;

/**
 *
 * labyrintin luontiin tarkoitettuja algoritmejä.
 */
public class Labyrintinluoja {

    /**
     * Pino koordinaateille.
     */
    //private Deque<Koordinaatit> pino;
    private Pino pino;
    private final int labyAskel = 3;

    /**
     * Peruuttavalla haulla generoitu labyrintti.
     */
    private int[][] peruuttava;

    /**
     * Primin algoritmillä generoitu labyrintti.
     */
    private int[][] prim;

    /**
     * Tyhja labyrintti
     */
    private int[][] testi;

    private final Labyrintti l = new Labyrintti();

    /**
     * luo labyrintin peruuttavalla haulla.
     *
     * @param width labyrintin leveys
     * @param height labyrintin korkeus
     * @return peruuttavalla haulla luotu labyrintti
     */
    public int[][] peruuttavaHaku(final int width, final int height) {
        pino = new Pino(width * height);
        l.luoUusiLabyrintti(width, height);

        peruuttava = new int[l.getLaby().length][l.getLaby().length];
        for (int i = 0; i < peruuttava.length; i++) {
            for (int j = 0; j < peruuttava.length; j++) {
                peruuttava[i][j] = l.getLaby()[i][j];
            }
        }

        boolean[][] kayty = new boolean[l.getLaby().length][l.getLaby().length];

        int aloitusX;
        int aloitusY;

        if (peruuttava.length % 2 == 0) {
            aloitusX = (peruuttava.length / 2) - 1;
            aloitusY = aloitusX;
        } else {
            aloitusX = (peruuttava.length / 2) - 2;
            aloitusY = aloitusX;
        }

        pino.lisaa(new Koordinaatit(aloitusX, aloitusY));
        kayty[aloitusX][aloitusY] = true;
        while (!pino.onkoTyhja()) {

            Koordinaatit p = (Koordinaatit) pino.PalautaEka();

            String suunnat = "";

            if (p.x + labyAskel < peruuttava.length
                    && !kayty[p.x + labyAskel][p.y]) {
                suunnat += 'o';
            }

            if (p.y - labyAskel >= 0 && !kayty[p.x][p.y - labyAskel]) {
                suunnat += 'y';
            }

            if (p.x - labyAskel >= 0 && !kayty[p.x - labyAskel][p.y]) {
                suunnat += 'v';
            }

            if (p.y + labyAskel < peruuttava.length && !kayty[p.x][p.y + labyAskel]) {
                suunnat += 'a';
            }

            if (suunnat.equals("")) {
                pino.poistaEka();

                continue;
            }

            long nano = System.nanoTime();

            int r = (int) nano % suunnat.length();
            if (r < 0) {
                r = -1 * r;
            }

            suunta(suunnat.charAt(r), p, peruuttava, kayty);

        }

        return peruuttava;
    }

    /**
     * Luo labyrintin Primin algoritmillä.
     *
     * @param width labyrintin leveys
     * @param height labyrintin korkeus
     * @return primin algoritmillä luotu labyrintti
     */
    public int[][] prim(final int width, final int height) {
        l.luoUusiLabyrintti(width, height);
        int[][] laby = l.getLaby();

        prim = new int[laby.length][laby.length];
        for (int i = 0; i < prim.length; i++) {
            for (int j = 0; j < prim.length; j++) {
                prim[i][j] = laby[i][j];
            }
        }

        int[][] tilat = new int[laby.length][laby.length];
        ArrayLista etu = new ArrayLista(laby.length * laby.length);

        int aloitusX;
        int aloitusY;

        if (prim.length % 2 == 0) {
            aloitusX = (prim.length / 2) - 1;
            aloitusY = aloitusX;
        } else {
            aloitusX = (prim.length / 2) - 2;
            aloitusY = aloitusX;
        }

        tilat[aloitusX][aloitusY] = 1;

        Koordinaatit k = new Koordinaatit(aloitusX, aloitusY);

        lisaaEtuun(k, tilat, etu);

        while (!etu.onkoTyhja()) {

            long nano = System.nanoTime();

            int r = ((int) nano % etu.GetKoko());

            if (r < 0) {
                r = -1 * r;
            }

            Koordinaatit uusiSolu = (Koordinaatit) etu.haeIndeksilla(r);
            tilat[uusiSolu.x][uusiSolu.y] = 1;
            etu.poistaIndeksilla(r);
            lisaaEtuun(uusiSolu, tilat, etu);
            String suunnat = "";
            if (uusiSolu.x + labyAskel < prim.length
                    && tilat[uusiSolu.x + labyAskel][uusiSolu.y] == 1) {
                suunnat += 'o';
            }
            if (uusiSolu.y - labyAskel >= 0
                    && tilat[uusiSolu.x][uusiSolu.y - labyAskel] == 1) {
                suunnat += 'y';
            }
            if (uusiSolu.x - labyAskel >= 0
                    && tilat[uusiSolu.x - labyAskel][uusiSolu.y] == 1) {
                suunnat += 'v';
            }
            if (uusiSolu.y + labyAskel < prim.length
                    && tilat[uusiSolu.x][uusiSolu.y + labyAskel] == 1) {
                suunnat += 'a';
            }
            r = (int) System.nanoTime() % suunnat.length();

            if (r < 0) {
                r = -1 * r;
            }
            lisaaSolu(suunnat.charAt(r), uusiSolu, prim);
        }
        return prim;
    }

    /**
     * Lisää koordinaatin k ympärillä olevat käymättömät solut arraylistiin.
     *
     * @param k koordinaatti
     * @param tilat tilaMatriisi, joka kertoo labyrinttien solujen tilat
     * @param etu arraylista johon solut lisätään
     */
    public void lisaaEtuun(final Koordinaatit k, final int[][] tilat,
            final ArrayLista etu) {

        if (k.x + labyAskel < prim.length && tilat[k.x + labyAskel][k.y] == 0) {

            etu.lisaa(new Koordinaatit(k.x + labyAskel, k.y));
            tilat[k.x + labyAskel][k.y] = 2;
        }

        if (k.y - labyAskel >= 0 && tilat[k.x][k.y - labyAskel] == 0) {
            etu.lisaa(new Koordinaatit(k.x, k.y - labyAskel));
            tilat[k.x][k.y - labyAskel] = 2;

        }

        if (k.x - labyAskel >= 0 && tilat[k.x - labyAskel][k.y] == 0) {

            etu.lisaa(new Koordinaatit(k.x - labyAskel, k.y));
            tilat[k.x - labyAskel][k.y] = 2;

        }

        if (k.y + labyAskel < prim.length && tilat[k.x][k.y + labyAskel] == 0) {

            etu.lisaa(new Koordinaatit(k.x, k.y + labyAskel));
            tilat[k.x][k.y + labyAskel] = 2;

        }

    }

    /**
     * poistaa seinät labyrintin kahden solun välillä, luoden niiden välille
     * yhteyden.
     *
     *
     * @param s merkki, joka kertoo mihin suuntaan annetusta koordinaatista
     * luodaan yhteys
     * @param k labyrinttikoordinaatti, josta lähdetään luomaan yhteyttä
     * @param prim labyrintti, joka on kyseessä
     */
    public void lisaaSolu(final char s, final Koordinaatit k, final int[][] prim) {

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
     * Palauttaa joko primin algoritmillä tai peruuttavalla haulla generoidun
     * labyrintin.
     *
     * @param c merkki joka kertoo mikä labyrintti palautetaan.
     * @return labyrintti
     */
    public int[][] getLaby(final char c) {

        if (c == 'r') {
            return peruuttava;
        } else if (c == 'p') {
            return prim;
        } else if (c == 't') {
            return testi;
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

            kayty[p.x + labyAskel][p.y] = true;
            pino.lisaa(new Koordinaatit(p.x + labyAskel, p.y));

            poistaSeinat(p.x + 2, p.y, laby);
            poistaSeinat(p.x + 2, p.y + 1, laby);

        } else if (s == 'y') {
            kayty[p.x][p.y - labyAskel] = true;
            pino.lisaa(new Koordinaatit(p.x, p.y - labyAskel));

            poistaSeinat(p.x, p.y - 1, laby);
            poistaSeinat(p.x + 1, p.y - 1, laby);

        } else if (s == 'v') {
            kayty[p.x - labyAskel][p.y] = true;
            pino.lisaa(new Koordinaatit(p.x - labyAskel, p.y));

            poistaSeinat(p.x - 1, p.y, laby);
            poistaSeinat(p.x - 1, p.y + 1, laby);

        } else if (s == 'a') {

            kayty[p.x][p.y + labyAskel] = true;
            pino.lisaa(new Koordinaatit(p.x, p.y + labyAskel));

            poistaSeinat(p.x, p.y + 2, laby);
            poistaSeinat(p.x + 1, p.y + 2, laby);

        } else {
            System.out.println(s + " ei oikea suunta");
        }
    }

    /**
     * Luo testilabyrintin jossa näkee paremmin leveys- ja syvyyshaun eron.
     *
     * @param width leveys
     * @param height korkeus
     * @return testilabyrintti
     */

    public int[][] luoTestiLaby(int width, int height) {

        int[][] testiLaby = new int[(width * 3) - 1][(width * 3) - 1];

        testiLaby[testiLaby.length - 1][(testiLaby.length / 2) + 1] = 1;
        testiLaby[testiLaby.length - 2][(testiLaby.length / 2) + 1] = 1;
        testiLaby[testiLaby.length - 3][(testiLaby.length / 2) + 1] = 1;

        testi = testiLaby;
        return testiLaby;

    }

    /**
     * poistaa labyrintistä seinän.
     *
     * @param x poistettavan seinän x-koordinaatti
     * @param y poistettavan seinän y-koordinaatti
     */
    protected void poistaSeinat(final int x, final int y, final int[][] laby) {

        laby[y][x] = 0;
    }

    /**
     * Palauttaa pinon.
     *
     * @return pino
     */
    protected Pino getPino() {
        return pino;
    }

}
