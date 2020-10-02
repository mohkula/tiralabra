
import omatTietorakenteet.ArrayLista;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayListaTest {


    ArrayLista lista;
    public ArrayListaTest() {
        lista = new ArrayLista(5);
        for (int i = 0; i < 5; i++) {
            lista.lisaa(i);
        }
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
    public void KokoOnOikea(){
        assertEquals(lista.GetKoko(), 5);
    }


    @Test
    public void hakuPalauttaaOikein(){
        int a = (int) lista.hae(2);
        assertEquals(a, 2);
    }

    @Test
    public void hakuPalauttaaNull(){



        assertEquals(lista.hae(6), null);
    }



    @Test
    public void poistoToimii(){
        lista.poista(2);
                assertEquals(lista.toString(), "0134");
                lista.poista(3);
                assertEquals(lista.toString(), "014");

                   assertEquals(lista.hae(2), null);


    }



}
