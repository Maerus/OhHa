

package lautapeli.lautapeli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LuolastopakkaTest {
    
    public LuolastopakkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private Luolastopakka l;
    
    @Before
    public void setUp() {
        l = new Luolastopakka();
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
    @Test
    public void luolastopakassaOn5Luolastoa(){
        assertEquals(5, l.getPakka().size());
    }
    
    @Test
    public void pakkaPieneneeOikein(){
        l.otaLuolasto();
        assertEquals(4, l.getPakka().size());
    }
    
    @Test
    public void mystinenLuolaSaaOikeatArvot(){
        Luolasto luola = haeMystinen();
        boolean a = true;
        if(luola.getVihollisnopat() < 4){
            a = false;
        }
        if(luola.getVihollisnopat() > 8){
            a = false;
        }
        if(luola.getTaistelunopat() < 2){
            a = false;
        }
        if(luola.getTaistelunopat() > 6){
            a = false;
        }
        if(luola.getAarrenopat()< 2){
            a = false;
        }
        if(luola.getAarrenopat()> 6){
            a = false;
        }
        
        assertEquals(true, a);
    }
    
    Luolasto haeMystinen(){
        Luolasto luola = l.otaLuolasto();
        if (!luola.getNimi().equals("Mystinen Luola")){
            luola = haeMystinen();
            return luola;
        }
        return luola;
    }
}
