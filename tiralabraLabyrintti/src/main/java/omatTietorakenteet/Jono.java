package omatTietorakenteet;

/**
 * Jonon toteutus
 *
 */
public class Jono {

    private int size, vikai;
    private Object[] lista;

    public Jono(int koko) {

        lista = new Object[koko];
        size = 0;

    }

    /**
     * Lisää listaan objectin.
     *
     * @param o lisättävä objekti
     */
    public void lisaa(Object o) {
        if (onkoTyhja()) {
            lista[0] = o;
            vikai = 0;
        } else {
            lista[vikai + 1] = o;
            vikai++;
        }

        size++;
    }

    /**
     * Palauttaa ja poistaa jonon ensimmäisen objektin.
     *
     * @return ensimmäinen objekti
     */
    public Object palautaJaPoistaEka() {
        Object o = lista[0];

        for (int i = 1; i <= vikai; i++) {
            lista[i - 1] = lista[i];
        }
        vikai--;
        size--;

        return o;
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
