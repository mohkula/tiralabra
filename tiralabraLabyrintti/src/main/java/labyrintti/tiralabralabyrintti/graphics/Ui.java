package labyrintti.tiralabralabyrintti.graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import labyrintti.tiralabralabyrintti.Labyrintinluoja;
import labyrintti.tiralabralabyrintti.ReitinHakija;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import labyrintti.tiralabralabyrintti.Labyrintti;
import labyrintti.tiralabralabyrintti.LabyrinttienVertailu;

public class Ui {

    char mikaLaby;
    JFrame frame;
    JPanel panel;
    JTextField size;
    JLabel reitti;
    Labyrintinluoja ll;
    LabyrinttienVertailu lv;
    ReitinHakija rh;

    Freimi fr = new Freimi(1056, 1056, 1000, 0);

    public Ui() {

        lv = new LabyrinttienVertailu();

        ll = new Labyrintinluoja();
        rh = new ReitinHakija();
        panel = new JPanel();
        panel.setLayout(null);
        frame = new JFrame();

        JFrame frame = new JFrame();
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        JButton peruuttavaNappi = new JButton("Generoi labyrintti peruuttavalla haulla");
        peruuttavaNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {

                    int x = Integer.parseInt(size.getText());

                    if (x <= 0) {
                        reitti.setText("Pitää olla suurempi kuin 0");
                        return;
                    }

                    if (x > 340) {
                        reitti.setText("Saa olla enintään 340");
                        return;

                    }
                    int[][] laby = ll.peruuttavaHaku(x, x);

                    mikaLaby = 'r';
                    fr.updateGraphics(laby);
                } catch (NumberFormatException nfe) {
                    if (size.getText().equals("e")) {
                        int[][] laby = ll.luoTestiLaby(5, 5);
                        mikaLaby = 't';
                          fr.updateGraphics(laby);
                    }

                }

            }
        });

        JButton primNappi = new JButton("Generoi labyrintti Primin algoritmillä");
        primNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {

                    int x = Integer.parseInt(size.getText());

                    if (x <= 0) {
                        reitti.setText("Pitää olla suurempi kuin 0");
                        return;
                    }

                    if (x > 340) {
                        reitti.setText("Saa olla enintään 340");
                        return;

                    }

                    int[][] laby = ll.prim(x, x);
                    mikaLaby = 'p';
                    fr.updateGraphics(laby);
                } catch (NumberFormatException nfe) {
                    if (size.getText().equals("e")) {
                        int[][] laby = ll.luoTestiLaby(5, 5);
                        mikaLaby = 't';
                          fr.updateGraphics(laby);
                    }
                }

            }
        });

        JButton etsireittiLeveys = new JButton("Etsi reitti leveyshaulla");
        etsireittiLeveys.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    int[][] laby = ll.getLaby(mikaLaby);
                    String r = rh.haeReittiLeveysHaulla(0, 0, laby, laby.length - 2, laby.length - 2);

                    fr.updateGraphics(rh.luoReittiLaby(laby, r, 0, 0, 3));

                    reitti.setText("reitin pituus: " + Integer.toString(r.length()));
                } catch (NullPointerException npe) {
                    reitti.setText("Et ole vielä generoinut labyrinttiä");
                }
            }
        });

        JButton etsiReittiSyvyys = new JButton("Etsi reitti syvyyshaulla");
        etsiReittiSyvyys.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    int[][] laby = ll.getLaby(mikaLaby);
                    String r = rh.haeReittiSyvyysHaulla(0, 0, laby, laby.length - 2, laby.length - 2);

                    if (r.equals("ei reittiä")) {
                        reitti.setText("Stack overflow :( , kokeile leveyshakua");
                    } else {
                        fr.updateGraphics(rh.luoReittiLaby(laby, r, 0, 0, 4));

                        reitti.setText("reitin pituus: " + Integer.toString(r.length()));
                    }
                } catch (NullPointerException npe) {
                    reitti.setText("Et ole vielä generoinut labyrinttiä");
                }

            }
        });

        JButton Testit = new JButton("Aja testit");
        Testit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                lv.vertaa(100);

            }
        });

        size = new JTextField("10");
        reitti = new JLabel("");
        JLabel koko = new JLabel("labyrintin koko. Max 340");

        panel.add(koko);
        panel.add(size);
        panel.add(peruuttavaNappi);
        panel.add(primNappi);
        panel.add(etsireittiLeveys);
        panel.add(etsiReittiSyvyys);
        panel.add(Testit);
        panel.add(reitti);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("");
        frame.pack();
        frame.setVisible(true);

    }

}
