package labyrintti.tiralabralabyrintti;

import labyrintti.tiralabralabyrintti.graphics.Ui;

public class LabyrinttienVertailu {

    private Ui ui;
    private Labyrintinluoja ll;
    private ReitinHakija rh;
    private int labyMaara = 1000;
    private int pisinReittiPeruuttavaLeveysHaulla;
    private int lyhyinReittiPeruuttavaLeveysHaulla;

    private int pisinReittiPeruuttavaSyvyysHaulla;
    private int lyhyinReittiPeruuttavaSyvyysHaulla;
    private int pisinReittiPrimLeveysHaulla;
    private int lyhyinReittiPrimLeveysHaulla;

    private int pisinReittiPrimSyvyyysHaulla;
    private int lyhyinReittiPrimSyvyysHaulla;

    public LabyrinttienVertailu(Ui ui) {

        this.ui = ui;
        ll = new Labyrintinluoja();
        rh = new ReitinHakija();
        lyhyinReittiPeruuttavaLeveysHaulla = 0;
        pisinReittiPeruuttavaLeveysHaulla = 0;
        lyhyinReittiPeruuttavaSyvyysHaulla = 0;
        pisinReittiPeruuttavaSyvyysHaulla = 0;

        pisinReittiPrimLeveysHaulla = 0;
        lyhyinReittiPrimLeveysHaulla = 0;
        pisinReittiPrimSyvyyysHaulla = 0;
        lyhyinReittiPrimSyvyysHaulla = 0;

    }

    /**
     * Generoi 1000 labyrinttiä Peruuttavalla haulla ja 1000 Primin algoritmillä
     * ja vertailee niitä keskenään käyttäen syvyys- ja leveyshakua.
     *
     * @param koko generoitavien labyrinttien koko
     */
    public void vertaa(int koko) {

        String reittiLeveys = "";
        String reittiSyvyys = "";
        int[][] laby;

        int[] peruuttava = new int[labyMaara];
        int[] prim = new int[labyMaara];

        System.out.println("generoidaan " + labyMaara + " "
                + koko + "X" + koko + " kokoista labyrinttiä peruuttavalla haulla");
        for (int i = 0; i < labyMaara; i++) {
            laby = ll.peruuttavaHaku(koko, koko);
            reittiLeveys = rh.haeReittiLeveysHaulla(0, 0, laby, laby.length - 2, laby.length - 2);
            reittiSyvyys = rh.haeReittiSyvyysHaulla(0, 0, laby, laby.length - 2, laby.length - 2);

            if (reittiSyvyys.equals("ei reittiä")) {
                i--;
                continue;
            }

            if (reittiLeveys.length() > pisinReittiPeruuttavaLeveysHaulla) {
                pisinReittiPeruuttavaLeveysHaulla = reittiLeveys.length();
            }

            if (lyhyinReittiPeruuttavaLeveysHaulla == 0
                    || lyhyinReittiPeruuttavaLeveysHaulla > reittiLeveys.length()) {
                lyhyinReittiPeruuttavaLeveysHaulla = reittiLeveys.length();
            }

            if (reittiSyvyys.length() > pisinReittiPeruuttavaSyvyysHaulla) {
                pisinReittiPeruuttavaSyvyysHaulla = reittiSyvyys.length();
            }

            if (lyhyinReittiPeruuttavaSyvyysHaulla == 0
                    || lyhyinReittiPeruuttavaSyvyysHaulla > reittiSyvyys.length()) {
                lyhyinReittiPeruuttavaSyvyysHaulla = reittiSyvyys.length();

            }

            peruuttava[i] = reittiLeveys.length();

        }

        System.out.println("generoidaan " + labyMaara + " " + koko
                + "X" + koko + " kokoista labyrinttiä Primin algoritmillä");
        System.out.println("");
        for (int i = 0; i < labyMaara; i++) {
            laby = ll.prim(koko, koko);
            reittiLeveys = rh.haeReittiLeveysHaulla(0, 0, laby, laby.length - 2, laby.length - 2);
            reittiSyvyys = rh.haeReittiSyvyysHaulla(0, 0, laby, laby.length - 2, laby.length - 2);

            if (reittiSyvyys.equals("ei reittiä")) {
                continue;
            }

            if (reittiLeveys.length() > pisinReittiPrimLeveysHaulla) {
                pisinReittiPrimLeveysHaulla = reittiLeveys.length();
            }

            if (lyhyinReittiPrimLeveysHaulla == 0 || lyhyinReittiPrimLeveysHaulla > reittiLeveys.length()) {
                lyhyinReittiPrimLeveysHaulla = reittiLeveys.length();
            }

            if (reittiSyvyys.length() > pisinReittiPrimSyvyyysHaulla) {
                pisinReittiPrimSyvyyysHaulla = reittiSyvyys.length();
            }

            if (lyhyinReittiPrimSyvyysHaulla == 0 || lyhyinReittiPrimSyvyysHaulla > reittiSyvyys.length()) {
                lyhyinReittiPrimSyvyysHaulla = reittiSyvyys.length();
            }
            prim[i] = reittiLeveys.length();

        }

        System.out.println(tulokset());

        ui.luoVertailuGraafi(peruuttava, prim);

    }

    public String tulokset() {

        return "Peruuttavalla haulla generoidut labyrintit:" + "\n"
                + "Pisin reitti käyttäen leveyshakua: "
                + pisinReittiPeruuttavaLeveysHaulla + "\n"
                + "lyhyin reitti käyttäen leveyshakua: "
                + +lyhyinReittiPeruuttavaLeveysHaulla + "\n"
                + "Pisin reitti käyttäen syvyyshakua: "
                + pisinReittiPeruuttavaSyvyysHaulla + "\n"
                + "lyhyin reitti käyttäen syvyyshakua: "
                + lyhyinReittiPeruuttavaSyvyysHaulla + "\n"
                + "\n"
                + "Primin algoritmillä generoidut labyrintit:" + "\n"
                + "Pisin reitti käyttäen leveyshakua: "
                + pisinReittiPrimLeveysHaulla + "\n"
                + "lyhyin reitti käyttäen leveyshakua: "
                + lyhyinReittiPrimLeveysHaulla + "\n"
                + "Pisin reitti käyttäen syvyyshakua: "
                + pisinReittiPrimSyvyyysHaulla + "\n"
                + "lyhyin reitti käyttäen syvyyshakua: "
                + +lyhyinReittiPrimSyvyysHaulla + "\n";

    }

}
