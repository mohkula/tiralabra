package labyrintti.tiralabralabyrintti.graphics;

import javax.swing.JFrame;
import labyrintti.tiralabralabyrintti.MainClass;

/**
 *
 * ikkuna johon grafiikat piirretään.
 */
public class Freimi extends JFrame {

    public Freimi(int width, int height, int[][] laby) {
        this.setSize(width, height);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Grafiikat g = new Grafiikat(laby);
        this.setVisible(true);
        this.add(g);

    }
}
