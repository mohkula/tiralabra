package labyrintti.tiralabralabyrintti;

import omatTietorakenteet.Jono;

public class ReitinHakija {

    private Labyrintti l = new Labyrintti();
    private int[][] reittiLaby;
    private boolean[][] kayty;
    private String syvyysHakuReitti;

    public ReitinHakija() {

    }

    /**
     * luo labyrintin, johon reitti on merkattu numerolla 3.
     *
     * @param laby labyrintti, johon reitti merkitään
     * @param reitti kuljettava reitti merkkijonona
     * @param x reitin alun x-koordinaatti
     * @param y reitin alun y-koordinaatti
     * @return labyrintti, johon reitti on merkattu numerolla 3
     */
    public int[][] luoReittiLaby(int[][] laby, String reitti, int x, int y, int arvo) {
        reittiLaby = new int[laby.length][laby.length];
        for (int i = 0; i < laby.length; i++) {
            for (int j = 0; j < laby.length; j++) {
                reittiLaby[i][j] = laby[i][j];

            }
        }

        for (int i = 0; i < reitti.length(); i++) {
            switch (reitti.charAt(i)) {

                case 'o':
                    for (int i2 = 0; i2 < 3; i2++) {
                        reittiLaby[y][x] = arvo;
                        reittiLaby[y + 1][x] = arvo;
                        x++;
                    }
                    reittiLaby[y][x] = arvo;
                    reittiLaby[y + 1][x] = arvo;
                    reittiLaby[y][x + 1] = arvo;
                    reittiLaby[y + 1][x + 1] = arvo;

                    break;

                case 'y':

                    for (int i2 = 0; i2 < 3; i2++) {
                        reittiLaby[y][x] = arvo;
                        reittiLaby[y][x + 1] = arvo;
                        y--;
                    }

                    break;

                case 'v':

                    for (int i2 = 0; i2 < 3; i2++) {
                        reittiLaby[y][x] = arvo;
                        reittiLaby[y + 1][x] = arvo;
                        x--;
                    }

                    break;

                case 'a':
                    for (int i2 = 0; i2 < 3; i2++) {
                        reittiLaby[y][x] = arvo;
                        reittiLaby[y][x + 1] = arvo;
                        y++;
                    }
                    reittiLaby[y][x] = arvo;
                    reittiLaby[y][x + 1] = arvo;
                    reittiLaby[y + 1][x] = arvo;
                    reittiLaby[y + 1][x + 1] = arvo;

                    break;

            }

        }
        return reittiLaby;

    }

    /**
     * Luo reitin käyttäen leveyshakua.
     *
     * @param x reitin alun x-koordinaatti
     * @param y reitin alun y-koordinaatti
     * @param laby labyrintti, josta reitti etsitään
     * @param maaliX maalin x-koordinaatti
     * @param maaliY maalin y-koordinaatti
     * @return reitti merkkijonona
     */
    public String haeReittiLeveysHaulla(int x, int y, int[][] laby, int maaliX, int maaliY) {

        if (laby[y][x] == 1 || laby[maaliY][maaliX] == 1) {
            return null;
        }

        boolean[][] kayty = new boolean[laby.length][laby.length];

        Jono jono = new Jono(laby.length * laby.length);

        Kulkija k = new Kulkija(x, y);
        jono.lisaa(k);
        kayty[x][y] = true;

        while (!jono.onkoTyhja()) {
            Object o = jono.palautaJaPoistaEka();
            k = (Kulkija) o;
            if (k.x == maaliX && k.y == maaliY) {
                return k.getReitti();
            }

            if (k.y + 3 < laby.length && laby[k.x][k.y + 2] == 0 && !kayty[k.x][k.y + 3]) {
                Kulkija uusiKulkija = new Kulkija(k.x, k.y + 3);
                String s = k.getReitti();
                s += 'o';
                uusiKulkija.lisaaReittiin(s);
                jono.lisaa(uusiKulkija);

                kayty[k.x][k.y + 3] = true;

            }

            if (k.x - 3 >= 0 && laby[k.x - 2][k.y] == 0 && !kayty[k.x - 3][k.y]) {
                Kulkija uusiKulkija = new Kulkija(k.x - 3, k.y);
                String s = k.getReitti();
                s += 'y';
                uusiKulkija.lisaaReittiin(s);
                jono.lisaa(uusiKulkija);

                kayty[k.x - 3][k.y] = true;
            }

            if (k.y - 3 >= 0 && laby[k.x][k.y - 2] == 0 && !kayty[k.x][k.y - 3]) {
                Kulkija uusiKulkija = new Kulkija(k.x, k.y - 3);
                String s = k.getReitti();
                s += 'v';
                uusiKulkija.lisaaReittiin(s);
                jono.lisaa(uusiKulkija);

                kayty[k.x][k.y - 3] = true;
            }

            if (k.x + 3 < laby.length && laby[k.x + 2][k.y] == 0 && !kayty[k.x + 2][k.y]) {
                Kulkija uusiKulkija = new Kulkija(k.x + 3, k.y);
                String s = k.getReitti();
                s += 'a';
                uusiKulkija.lisaaReittiin(s);
                jono.lisaa(uusiKulkija);

                kayty[k.x + 3][k.y] = true;
            }

        }

        System.err.println("Reittiä ei löytynyt");

        return null;
    }

    /**
     * Luo reitin käyttäen syvyyshakua.
     *
     * @param x reitin alun x-koordinaatti
     * @param y reitin alun y-koordinaatti
     * @param laby labyrintti josta reitti etsitään
     * @param maaliX reitin lopun x-koordinaatti
     * @param maaliYreitin lopun y-koordinaatti
     * @return valmis reitti merkkijonona.
     */
    public String haeReittiSyvyysHaulla(int x, int y, int[][] laby, int maaliX, int maaliY) {
        boolean lopetaRekursio = false;
        syvyysHakuReitti = "ei reittiä";
        kayty = new boolean[laby.length][laby.length];

        haku(new Kulkija(x, y), laby, maaliX, maaliY, lopetaRekursio, null, "");
        return syvyysHakuReitti;
    }


    /**
     * Apumetodi syvyyshaulle.
     *
     * @param k Kulkija joka aloittaa haun
     * @param laby labyrintti josta reitti etsitään
     * @param maaliX reitin lopun x-koordinaatti
     * @param maaliYreitin lopun y-koordinaatti
     * @param lopetaRekursio rekursion katkaisuun tarkoitettu boolean
     * @param edellinen edellinen kulkija
     * @param suunta suunta johon kulkija on liikkunut
     */
    private void haku(Kulkija k, int[][] laby, int maaliX, int maaliY, boolean lopetaRekursio, Kulkija edellinen, String suunta) {

        if (lopetaRekursio) {
            return;
        }

        if (k.x < 0 || k.y < 0 || k.x >= laby.length || k.y >= laby.length) {

            return;
        }
        if (kayty[k.x][k.y]) {
            return;
        }

        switch (suunta) {
            case "a":

                if (laby[k.x - 1][k.y] == 1) {
                    return;
                }
                break;

            case "o":
                if (laby[k.x][k.y - 1] == 1) {
                    return;
                }
                break;

            case "y":

                if (laby[k.x + 1][k.y] == 1) {
                    return;
                }
                break;

            case "v":

                if (laby[k.x][k.y + 1] == 1) {
                    return;
                }
                break;
        }

        if (edellinen != null) {
            k.lisaaReittiin(edellinen.getReitti() + suunta);
        }

        if (k.x == maaliX && k.y == maaliY) {
            syvyysHakuReitti = k.getReitti();
            lopetaRekursio = true;
        }

        kayty[k.x][k.y] = true;

        try {

            Kulkija uusik = new Kulkija(k.x + 3, k.y);
            //  uusik.lisaaReittiin(k.getReitti());
            haku(uusik, laby, maaliX, maaliY, lopetaRekursio, k, "a");
            uusik = new Kulkija(k.x, k.y + 3);
            // uusik.lisaaReittiin(k.getReitti());
            haku(uusik, laby, maaliX, maaliY, lopetaRekursio, k, "o");
            uusik = new Kulkija(k.x - 3, k.y);
            //  uusik.lisaaReittiin(k.getReitti());
            haku(uusik, laby, maaliX, maaliY, lopetaRekursio, k, "y");
            uusik = new Kulkija(k.x, k.y - 3);
            // uusik.lisaaReittiin(k.getReitti());
            haku(uusik, laby, maaliX, maaliY, lopetaRekursio, k, "v");
        } catch (StackOverflowError e) {
            syvyysHakuReitti = "ei reittiä";
            lopetaRekursio = true;
            return;
        }
    }

}

/**
 * Leveysaussa käytettävä koordinaattiolio joka tallentaa kuljetun reitin
 * merkkijonona.
 *
 * @author mahi
 */
class Kulkija {

    int x;
    int y;
    String reitti;

    public Kulkija(int x, int y) {
        this.x = x;
        this.y = y;

        reitti = "";
    }

    /**
     * Palauttaa reitin merkkijonona.
     *
     * @return reitti merkkijonona
     */
    public String getReitti() {
        return reitti;
    }

    /**
     * Lisää reittiin merkkejä.
     *
     * @param s reittiin lisättävä merkkijono.
     */
    public void lisaaReittiin(String s) {
        reitti += s;
    }

}
