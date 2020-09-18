/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class LabyrinttiTest {
    Labyrintti l;
    public LabyrinttiTest() {
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
    public void labyrinttiOnOikeanKokoinen(){
        
        assertEquals(l.getLaby().length, 8);
        
    }
    
    
    @Test
    public void labyrintissaOnSeinatOikeissaKohdissa(){
        
        assertEquals(l.getLaby()[2][1], 1 );
        assertEquals(l.getLaby()[5][5], 1 );
    }
}
