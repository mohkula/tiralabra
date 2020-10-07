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
    int width;
    int height;
    int wall = 2;

    Labyrintti l = new Labyrintti();

    public Grafiikat(int[][] laby , int freimix, int freimiy) {
        this.laby = laby;
        width = freimix/laby.length;
        height = freimiy/laby.length;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setBackground(Color.black);

        g2d = (Graphics2D) g;
        g2d.setColor(Color.white);


        int screencoordinatex = 2;
        int screencoordinatey = 0;
        for (int y = 0; y < laby.length; y++) {
            for (int x = 0; x < laby.length; x++) {

                if (laby[y][x] == 0) {
                    g2d.setColor(Color.white);
                    g2d.fillRect(screencoordinatex, screencoordinatey, width, height);
                } else if (laby[y][x] == 1) {

                    g2d.setColor(Color.gray);
                    g2d.fillRect(screencoordinatex, screencoordinatey, width, height);
                } else if(laby[y][x] == 3){
                    g2d.setColor(Color.red);
                    g2d.fillRect(screencoordinatex, screencoordinatey, width, height);
                }else if(laby[y][x] == 4){
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(screencoordinatex, screencoordinatey, width, height);
                }
                screencoordinatex += width;
            }
            screencoordinatex = 2;
            screencoordinatey += height;
        }

    }

}
