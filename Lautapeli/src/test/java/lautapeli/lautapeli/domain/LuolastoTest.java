

package lautapeli.lautapeli.domain;

import lautapeli.lautapeli.domain.Luolasto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LuolastoTest {
    
    public LuolastoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Luolasto l;
    
    @Before
    public void setUp() {
        l = new Luolasto(7, 5, 8, "asd");
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
    @Test
    public void luolastollaOikeaMaaraVNoppia(){
        assertEquals(7, l.getVihollisnopat());
    }
    
    @Test
    public void luolastollaOikeaMaaraTNoppia(){
        assertEquals(5, l.getTaistelunopat());
    }
    
    @Test
    public void luolastollaOikeaMaaraANoppia(){
        assertEquals(8, l.getAarrenopat());
    }
    
    @Test
    public void luolastonNimiAsettuuOikein(){
        assertEquals("asd", l.getNimi());
    }
    
    @Test
    public void geneerisenLuolastonNimiOikein(){
        Luolasto g = new Luolasto();
        assertEquals("generic luolasto", g.getNimi());
    }
}
