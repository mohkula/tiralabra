/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Deque;
import labyrintti.tiralabralabyrintti.Labyrintinluoja;
import labyrintti.tiralabralabyrintti.Labyrintti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mahi
 */
public class LabyrintinluojaTest extends Labyrintinluoja {

    Labyrintinluoja ll;
    Labyrintti l;

    public LabyrintinluojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        l = new Labyrintti();
        l.luoUusiLabyrintti(3, 3);
        ll = new Labyrintinluoja();

        ll.peruuttavaHaku(l.getLaby());
        ll.prim(l.getLaby());
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void poistaSeinatToimiiPeruuttavassaHaussa() {
        boolean lopeta = false;
       
        int y = -1;
        int x = -1;
        int[][] peruuttava = ll.getLaby('r');
        for (int i = 0; i < peruuttava.length; i++) {
            for (int j = 0; j < peruuttava.length; j++) {
                if (peruuttava[i][j] == 1) {
                    x = j;
                    y = i;
                    super.poistaSeinat(i, j,peruuttava);
                    lopeta = true;
                    break;
                }

            }
            if (lopeta) {
                break;
            }
        }
        
        assertEquals(peruuttava[x][y], 0);
    }
    
       @Test
    public void poistaSeinatToimiiPriminAlgoritmissa() {
        boolean lopeta = false;
        
           int y = -1;
        int x = -1;
        int[][] prim = ll.getLaby('p');
        for (int i = 0; i < prim.length; i++) {
            for (int j = 0; j < prim.length; j++) {
                if (prim[i][j] == 1) {
                    x = j;
                    y = i;
                    super.poistaSeinat(i, j,prim);
                    lopeta = true;
                    break;
                }

            }
            if (lopeta) {
                break;
            }
        }
        
                assertEquals(prim[x][y], 0);

    }
    
    
    
}



