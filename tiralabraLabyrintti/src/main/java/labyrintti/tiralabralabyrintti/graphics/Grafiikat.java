package labyrintti.tiralabralabyrintti.graphics;

import javax.swing.JPanel;
import java.awt.*;
import labyrintti.tiralabralabyrintti.Labyrintinluoja;
import labyrintti.tiralabralabyrintti.Labyrintti;

/**
 *
 * Labyrintin piirtämiseen tarkoitettu luokka
 */
public class Grafiikat extends JPanel {

    Graphics2D g2d;
    int[][] laby;
    int width = 5;// 
    int height = 5;
    int wall = 2;

    Labyrintti l = new Labyrintti();

    public Grafiikat(int[][] laby) {
        this.laby = laby;

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setBackground(Color.blue);

        g2d = (Graphics2D) g;
        g2d.setColor(Color.white);


        int screencoordinatex = 0;
        int screencoordinatey = 0;
        for (int y = 0; y < laby.length; y++) {
            for (int x = 0; x < laby.length; x++) {

                if (laby[y][x] == 0) {
                    g2d.setColor(Color.white);
                    g2d.fillRect(screencoordinatex, screencoordinatey, width, height);
                } else if (laby[y][x] == 1) {

                    g2d.setColor(Color.gray);
                    g2d.fillRect(screencoordinatex, screencoordinatey, width, height);
                } else {
                    g2d.setColor(Color.red);
                    g2d.fillRect(screencoordinatex, screencoordinatey, width, height);
                }
                screencoordinatex += width;
            }
            screencoordinatex = 0;
            screencoordinatey += height;
        }

    }

}
