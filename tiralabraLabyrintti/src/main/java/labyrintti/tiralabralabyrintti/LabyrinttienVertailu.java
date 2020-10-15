package labyrintti.tiralabralabyrintti;

import labyrintti.tiralabralabyrintti.graphics.Freimi;

public class LabyrinttienVertailu {

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

    public LabyrinttienVertailu() {
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

//        fr = new Freimi(380, 380, 0, 0);
//        fr2 = new Freimi(380, 380, 1000, 0);
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

        System.out.println("generoidaan " + labyMaara + " "
                + koko + "X" + koko + " kokoista labyrinttiä peruuttavalla haulla");
        for (int i = 0; i < labyMaara; i++) {
            laby = ll.peruuttavaHaku(koko, koko);
            reittiLeveys = rh.haeReittiLeveysHaulla(0, 0, laby, laby.length - 2, laby.length - 2);
            reittiSyvyys = rh.haeReittiSyvyysHaulla(0, 0, laby, laby.length - 2, laby.length - 2);

            if (reittiSyvyys.equals("ei reittiä")) {
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

                if (lyhyinReittiPeruuttavaSyvyysHaulla <= 10) {

                    System.out.println(reittiSyvyys);
                }
            }

        }

        System.out.println("generoidaan " + labyMaara + " " + koko
                + "X" + koko + " kokoista labyrinttiä Primin algoritmillä");
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

        }

        System.out.println("");
        System.out.println("Peruuttavalla haulla generoidut labyrintit:" + "\n");

        System.out.println("Pisin reitti käyttäen leveyshakua: "
                + pisinReittiPeruuttavaLeveysHaulla);
        System.out.println("lyhyin reitti käyttäen leveyshakua: "
                + lyhyinReittiPeruuttavaLeveysHaulla);

        System.out.println("Pisin reitti käyttäen syvyyshakua: "
                + pisinReittiPeruuttavaSyvyysHaulla);
        System.out.println("lyhyin reitti käyttäen syvyyshakua: "
                + lyhyinReittiPeruuttavaSyvyysHaulla + "\n");

        System.out.println("Primin algoritmillä generoidut labyrintit:" + "\n");

        System.out.println("Pisin reitti Primin algoritmillä käyttäen leveyshakua: "
                + pisinReittiPrimLeveysHaulla);
        System.out.println("lyhyin reitti Primin algoritmillä käyttäen leveyshakua: "
                + lyhyinReittiPrimLeveysHaulla);

        System.out.println("Pisin reitti käyttäen syvyyshakua: "
                + pisinReittiPrimSyvyyysHaulla);
        System.out.println("lyhyin reitti käyttäen syvyyshakua: "
                + lyhyinReittiPrimSyvyysHaulla);

    }

}
