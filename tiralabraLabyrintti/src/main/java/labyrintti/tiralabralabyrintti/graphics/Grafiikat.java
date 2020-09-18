
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
   int width= 10;// 
    int height = 10;
    int wall = 2;
    
    
    int fc = 0;
    int wc = 0;
    
 public Grafiikat(int[][] laby){
     this.laby = laby;
 }
     public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        this.setBackground(Color.blue);
        
        g2d = (Graphics2D)g;
        g2d.setColor(Color.white);
        
        
//        g2d.fillRect(11, 11, width, height);
//            System.out.println(0);
//g2d.fillRect(11+width+2, 11, width, height);
System.out.println((laby.length)*(width+wall) + "\n");

//Labyrintti l = new Labyrintti(2,2);
//l.tulostaLabyrintti(laby);
//         for (int i = 0; i <= (laby.length-1)*(width+wall); i+= width+wall) {
//             for (int j = 0; j <= (laby.length-1)*(height+wall); j+= height+wall) {
//                 if(laby[(i-width+wall)/width][(j-height+wall)/height] == 0){
//                     fc ++;
//                                     // System.out.println((i-width+wall)/width + " " + (j-height+wall)/height);
//
//                        g2d.setColor(Color.white);
//                      g2d.fillRect(i+1,j+1, width, height);
//                 }
//                 else if(laby[(i-width+wall)/width][(j-height+wall)/height] == 1){
//                     System.out.println((i-width+wall)/width + " " + (j-height+wall)/height);
//                     wc++;
//                    g2d.setColor(Color.gray);
//                    g2d.fillRect(i+1,j+1, width, height);
//                }
//                 else{
//                     System.out.println("error");
//                 }
//             }
//         }

System.out.println(laby[3][2]);
int screencoordinatex = 0;
                     int screencoordinatey = 0;
         for (int y = 0; y < laby.length; y++) {
             for (int x = 0; x < laby.length; x++) {
                 
                 if(laby[x][y] == 0){
                     g2d.setColor(Color.white);
                     g2d.fillRect(screencoordinatey,screencoordinatex,width,height);
                 }
                 
                 else{
                     wc ++; 
                          g2d.setColor(Color.gray);
                     g2d.fillRect(screencoordinatey,screencoordinatex,width,height);
                 }
           screencoordinatex += height +2;}
             screencoordinatex = 0;
          screencoordinatey += width + 2;}
        
         System.out.println(wc);
       

     }
     
   
    
     
}
