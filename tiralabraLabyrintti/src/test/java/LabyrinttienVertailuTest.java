/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import labyrintti.tiralabralabyrintti.LabyrinttienVertailu;
import labyrintti.tiralabralabyrintti.graphics.Ui;
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
public class LabyrinttienVertailuTest {


     LabyrinttienVertailu lv;
    public LabyrinttienVertailuTest() {
       lv = new LabyrinttienVertailu(new Ui());
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
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
    public void tulokestPalauttaaOikein(){
        assertEquals(lv.tulokset(),"Peruuttavalla haulla generoidut labyrintit:" + "\n"
                + "Pisin reitti käyttäen leveyshakua: "
                + 0 + "\n"
                + "lyhyin reitti käyttäen leveyshakua: "
                + +0 + "\n"
                + "Pisin reitti käyttäen syvyyshakua: " + "\n"
                + +0
                + "lyhyin reitti käyttäen syvyyshakua: "
                + 0 + "\n"
                + "Primin algoritmillä generoidut labyrintit:" + "\n"
                + "Pisin reitti Primin algoritmillä käyttäen leveyshakua: "
                + 0 + "\n"
                + "lyhyin reitti Primin algoritmillä käyttäen leveyshakua: "
                + 0 + "\n"
                + "Pisin reitti käyttäen syvyyshakua: "
                + 0 + "\n"
                + "lyhyin reitti käyttäen syvyyshakua: "
                + +0 + "\n");
    }
}
