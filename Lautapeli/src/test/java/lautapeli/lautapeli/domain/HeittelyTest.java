package lautapeli.lautapeli.domain;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HeittelyTest {
    
    public HeittelyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Heittely heittely;
    
    @Before
    public void setUp() {
        heittely = new Heittely(new Luolasto(), new Npc(null), null);
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
    
    @Test
    public void heittelyssaHeitetaanKuusisivuisiaNoppia(){
        heittely.heittele(20);
        boolean a = true;
        for (int i = 0; i < heittely.getNopat().size(); i++) {
            if(heittely.getNopat().get(i) < 1 || heittely.getNopat().get(i) > 6){
                a = false;
            }
        }
        assertEquals(true, a);
    }
}
