package omatTietorakenteet;

/**
 * ArrayListan toteutus
 *
 */
public class ArrayLista {

    private int koko;
    private Object[] lista;
    private int vikai;

    public ArrayLista(int koko) {
        lista = new Object[koko];
        vikai = 0;
        koko = 0;
    }

    /**
     * Lisää objectin listaan.
     *
     * @param o lisättävä objecti
     */
    public void lisaa(Object o) {
        lista[vikai] = o;
        vikai++;
        koko++;
    }

    /**
     * Hakee objectin listasta.
     *
     * @param ob haettava objecti
     * @return haettu objecti
     */
    public Object hae(Object ob) {

        for (Object o : lista) {
            if (o.equals(ob)) {
                return o;
            }

        }
        return null;

    }

    /**
     * Hakee listasta indeksillä.
     *
     * @param i indeksi, jolla haetaan listasta
     * @return haettu objecti
     */
    public Object haeIndeksilla(int i) {

        return lista[i];

    }

    /**
     * Poistaa listasta objectin.
     *
     * @param ob poistettava objecti
     */
    public void poista(Object ob) {

        for (int i = 0; i < koko; i++) {
            if (lista[i].equals(ob)) {
                koko--;
                siirraVasemmalle(i);

            }
        }

    }

    /**
     * Poistaa listasta indeksillä.
     *
     * @param i indeksi, josta poistetaan
     */
    public void poistaIndeksilla(int i) {

        koko--;
        siirraVasemmalle(i);

    }

    /**
     * Siirtää listan objecteja yhden askeleen vasemmalle, tietystä indeksistä.
     *
     * @param index indeksi, josta aletaan siirtämään
     */
    private void siirraVasemmalle(int index) {
        for (int i = index + 1; i <= koko; i++) {
            lista[i - 1] = lista[i];

        }

        vikai--;

    }

    /**
     * palauttaa listan koon.
     *
     * @return listan koko
     */
    public int GetKoko() {
        return koko;
    }

    /**
     * Palauttaa listan sisällön merkkijonona
     *
     * @return listan sisältö merkkijonona
     */
    public String toString() {
        String s = "";

        for (int i = 0; i < koko; i++) {
            s += lista[i];
        }

        return s;
    }

    public boolean onkoTyhja() {
        if (koko == 0) {
            return true;
        }

        return false;
    }

}
