
package labyrintti.tiralabralabyrintti.graphics;

import javax.swing.JPanel;
import java.awt.*;
import labyrintti.tiralabralabyrintti.Labyrintinluoja;

/**
 * 
 * Labyrintin piirtämiseen tarkoitettu luokka
 */
public class Grafiikat extends JPanel {
    
    Graphics2D g2d;
   int[][] laby;
    
    
 public Grafiikat(int[][] laby){
     this.laby = laby;
 }
     public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        this.setBackground(Color.blue);
        
        g2d = (Graphics2D)g;
        g2d.setColor(Color.white);
        
        
        
         for (int i = 0; i < laby.length; i++) {
             for (int j = 0; j < laby.length; j++) {
                 if(laby[i][j] == 0){
                      g2d.fillRect(i+6, +6, 5, 5);
                 }
             }
         }
        
        
       

     }
     
   
    
     
}
