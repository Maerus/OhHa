

package lautapeli.lautapeli;

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
        l = new Luolasto(7, 5, 8);
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
    @Test
    public void LuolastollaOikeaMaaraVNoppia(){
        assertEquals(7, l.getVihollisnopat());
    }
    
    @Test
    public void LuolastollaOikeaMaaraTNoppia(){
        assertEquals(5, l.getTaistelunopat());
    }
    
    @Test
    public void LuolastollaOikeaMaaraANoppia(){
        assertEquals(8, l.getAarrenopat());
    }
}
