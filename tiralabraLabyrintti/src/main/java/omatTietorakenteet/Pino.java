package omatTietorakenteet;

/**
 * Pinon toteutus.
 *
 * @author mahi
 */
public class Pino {

    private int size, ekai;
    private Object[] lista;

    public Pino(int koko) {

        lista = new Object[koko];
        size = 0;

    }

    /**
     * Lisää objektin pinoon.
     *
     * @param o lisättävä objekti
     */
    public void lisaa(Object o) {
        if (onkoTyhja()) {
            lista[0] = o;
            ekai = 0;
        } else {
            lista[ekai + 1] = o;
            ekai++;
        }

        size++;
    }

    /**
     * Palauttaa ensimmäisen objektin
     *
     * @return ensimmäinen objekti
     */
    public Object PalautaEka() {

        Object o = lista[ekai];
        return o;
    }

    /**
     * Poistaa ensimmäisen objektin
     */
    public void poistaEka() {

        if (ekai >= 0) {
            lista[ekai] = null;
            ekai--;
        }
        size--;

    }

    public boolean onkoTyhja() {
        if (getSize() == 0) {
            return true;
        }

        return false;
    }

    public int getSize() {
        return size;
    }
}
