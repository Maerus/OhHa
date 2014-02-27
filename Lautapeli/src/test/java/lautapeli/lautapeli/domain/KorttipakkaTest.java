

package lautapeli.lautapeli.domain;

import lautapeli.lautapeli.domain.kortti.Kortti;
import lautapeli.lautapeli.domain.kortti.TyhjaKortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KorttipakkaTest {
    
    public KorttipakkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Korttipakka k;
    
    @Before
    public void setUp() {
        k = new Korttipakka();
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
    @Test
    public void korttipakassa30Korttia(){
        assertEquals(30, k.getPakka().size());
    }
    
    @Test
    public void tyhjaPakkaAntaaTyhjaKortin(){
        for (int i = 0; i < 30; i++) {
            k.otaKortti();
        }
        Kortti kortti = k.otaKortti();
        assertEquals(TyhjaKortti.class, kortti.getClass());
    }
    
    @Test
    public void korttipakkaTyhjeneeYhdellaKunOtetaanKortti(){
        k.otaKortti();
        assertEquals(29, k.getPakka().size());
    }
}
