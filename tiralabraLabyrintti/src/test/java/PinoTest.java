/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import omatTietorakenteet.Pino;
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
public class PinoTest {


    Pino p;
    public PinoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
         p = new Pino(5);
         for (int i = 0; i < 5; i++) {
            p.lisaa(i);
        }
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
    public void oikeassaJarjestyksessa(){

                assertEquals((p.PalautaEka()), 4);


    }

    @Test
    public void pinoOnOikeanKokoinen(){
        assertEquals(p.getSize(), 5);
    }
}


















