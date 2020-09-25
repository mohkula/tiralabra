
package labyrintti.tiralabralabyrintti.graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import labyrintti.tiralabralabyrintti.Labyrintinluoja;
import labyrintti.tiralabralabyrintti.Labyrintti;
import labyrintti.tiralabralabyrintti.ReitinHakija;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ui {
    
char mikaLaby;
JFrame frame;
JPanel panel;
JTextField size;
JLabel reitti;
 Labyrintinluoja ll;
      ReitinHakija rh;

Freimi fr = new Freimi(380, 380,1000,0);
    public Ui(){
        
        ll = new Labyrintinluoja();
rh = new ReitinHakija();
      panel = new JPanel();
panel.setLayout(null);
     frame=new JFrame();     
     
      
                JFrame frame = new JFrame();
                frame.setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        
        
        
        JButton peruuttavaNappi = new JButton("generoi labyrintti peruuttavalla haulla");
        peruuttavaNappi.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent arg0) {
             

        int[][] laby = ll.peruuttavaHaku(Integer.parseInt(size.getText()),Integer.parseInt(size.getText()));
        mikaLaby = 'r';
            fr.updateGraphics(laby);
           
          }
        });
        
        
          
        JButton primNappi = new JButton("generoi labyrintti Primin algoritmillä");
        primNappi.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent arg0) {
             

        int[][] laby = ll.prim(Integer.parseInt(size.getText()),Integer.parseInt(size.getText()));
        mikaLaby = 'p';
            fr.updateGraphics(laby);
           
          }
        });
        
        
        
         JButton etsiReittiNappi = new JButton("Etsi reitti");
        etsiReittiNappi.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent arg0) {

    int[][] laby = ll.getLaby(mikaLaby);
                  String   r = rh.HaeReittiLeveysHaulla(0, 0, laby, laby.length-2,laby.length-2);

       fr.updateGraphics(rh.LuoReittiLaby(laby, r, 0, 0));
          
        
        reitti.setText("reitin pituus: " + Integer.toString(r.length()));
          }
        });
        
        
        
         size = new JTextField("10");
         reitti = new JLabel("");
        JLabel   koko = new JLabel("labyrintin koko");
        
        panel.add(koko);
        panel.add(size);
        panel.add(peruuttavaNappi);
        panel.add(primNappi);
        panel.add(etsiReittiNappi);
         panel.add(reitti);
        frame.add(panel, BorderLayout.CENTER );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("");
        frame.pack();
        frame.setVisible(true);
        
        
        

    }
  
    
}
