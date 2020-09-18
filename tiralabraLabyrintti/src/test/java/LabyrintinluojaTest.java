/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import labyrintti.tiralabralabyrintti.Labyrintinluoja;
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
        ll = new Labyrintinluoja();
        int[][] laby = new int[3][3];

        ll.peruuttavaHaku(laby);
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
    public void poistaSeinatToimii() {
        boolean lopeta = false;
        for (int i = 0; i < ll.getLaby().length; i++) {
            for (int j = 0; j < ll.getLaby().length; j++) {
                if (ll.getLaby()[i][j] == 1) {
                    super.poistaSeinat(i, j);
                    lopeta = true;
                    break;
                }

            }
            if (lopeta) {
                break;
            }
        }
    }
}
