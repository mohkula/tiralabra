
package labyrintti.tiralabralabyrintti.graphics;

import javax.swing.JFrame;
import labyrintti.tiralabralabyrintti.MainClass;


public class Freimi extends JFrame {
                 

                  public Freimi(int width, int height, int[][] laby ){
            this.setSize(width, height);
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             Grafiikat g = new Grafiikat(laby);
            this.add(g);
            this.setVisible(true);
           
    }
}
