

package lautapeli.lautapeli.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NimiGenTest {
    
    public NimiGenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    NimiGen n;
    
    @Before
    public void setUp() {
        n = new NimiGen();
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
    @Test
    public void nimigeneraattorinListaPieneneeKunOtetaanNimi(){
        int a = n.getLista().size();
        n.haeNimi();
        assertEquals(a-1, n.getLista().size());
    }
    
    @Test
    public void nimigeneraattorinListastaKatoaaOtettuNimi(){
        String a = n.haeNimi();
        assertEquals(false, n.getLista().contains(a));
    }
}
