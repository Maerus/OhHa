

package lautapeli.lautapeli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NpcTest {
    
    public NpcTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Npc n;
    
    @Before
    public void setUp() {
        n  = new Npc(null);
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
//    @Test borked
//    public void npcValitseeOstamisenTaiPelaamisen(){
//        boolean a = false;
//        String b = n.valitseVuoroToimepide();
//        if(b.equals("pelaa")){
//            a = true;
//        } else if (b.equals("osta")){
//            a = true;
//        }
//        assertEquals(true, a);
//    }
}
