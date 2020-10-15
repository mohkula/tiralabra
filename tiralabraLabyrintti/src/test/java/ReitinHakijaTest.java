/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import labyrintti.tiralabralabyrintti.Labyrintti;
import labyrintti.tiralabralabyrintti.ReitinHakija;
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



public class ReitinHakijaTest {

    int[][] laby;
    ReitinHakija rh;


    public ReitinHakijaTest() {
        Labyrintti l = new Labyrintti();
        rh = new ReitinHakija();

     laby = new int[14][14];

     laby[0][5] = 1;
     laby[1][5] = 1;
     laby[2][0] = 1;
     laby[2][1] = 1;
     laby[2][2] = 1;
     laby[2][5] = 1;
     laby[2][8] = 1;
     laby[2][9] = 1;
     laby[2][10] = 1;
     laby[2][11] = 1;
     laby[3][5] = 1;
     laby[3][8] = 1;
     laby[3][11] = 1;
     laby[4][5] = 1;
     laby[4][8] = 1;
     laby[4][11] = 1;
     laby[5][2] = 1;
     laby[5][3] = 1;
     laby[5][4] = 1;
     laby[5][5] = 1;
     laby[5][8] = 1;
     laby[5][11] = 1;
     laby[6][2] = 1;
     laby[6][8] = 1;
     laby[6][11] = 1;
     laby[7][2] = 1;
     laby[7][8] = 1;
     laby[7][11] = 1;
     laby[8][2] = 1;
     laby[8][3] = 1;
     laby[8][4] = 1;
     laby[8][5] = 1;
     laby[8][8] = 1;
     laby[8][11] = 1;
     laby[9][2] = 1;
     laby[9][8] = 1;
     laby[10][2] = 1;
     laby[10][8] = 1;
     laby[11][2] = 1;
     laby[11][5] = 1;
     laby[11][6] = 1;
     laby[11][7] = 1;
     laby[11][8] = 1;
     laby[11][11] = 1;
     laby[11][12] = 1;
     laby[11][13] = 1;
     laby[12][5] = 1;
     laby[13][5] = 1;


     l.tulostaLabyrintti(laby);

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
    public void LeveysHakuToimii(){



        assertEquals(rh.haeReittiLeveysHaulla(0, 0, laby, laby.length - 2, laby.length - 2), "oavaaaoyoyyyooaaavao");

    }


     @Test
    public void SyvyysHakuToimii(){



        assertEquals(rh.haeReittiSyvyysHaulla(0, 0, laby, laby.length - 2, laby.length - 2), "oavaaaoyoyyyooaaavao");

    }
}
