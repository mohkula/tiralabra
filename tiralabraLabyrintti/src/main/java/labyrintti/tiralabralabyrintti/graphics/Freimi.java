package labyrintti.tiralabralabyrintti.graphics;

import javax.swing.JFrame;

/**
 *
 * ikkuna johon grafiikat piirretään.
 */
public class Freimi extends JFrame {

    int width;
    int height;

    public Freimi(int width, int height, int x, int y) {
        this.height = height;
        this.width = width;
        this.setSize(width, height);
        this.setLocation(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Päivittää ikkunassa näkyvän labyrintin annetun labyrintin mukaiseksi.
     * @param laby annettu labyrintti
     */
    public void updateGraphics(int[][] laby) {
        Grafiikat g = new Grafiikat(laby, width, height);
        this.add(g);
        this.setVisible(true);
    }
}
