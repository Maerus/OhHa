

package lautapeli.lautapeli.domain;

import java.util.Random;
import lautapeli.lautapeli.domain.kortti.Kortti;
import lautapeli.lautapeli.domain.kortti.TestiKortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelaajaTest {
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Pelaaja p;
    Random r;
    @Before
    public void setUp() {
        p = new Pelaaja();
        r = new Random();
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
    @Test
    public void luodunPelaajanPisteetOnNolla(){
        assertEquals(0, p.getPisteet());
    }
    
    @Test
    public void pelaajanPisteetLisataanOikein(){
        int a = 0;
        for (int i = 0; i < 1+r.nextInt(10); i++) {
            p.lisaaPiste();
            a++;
        }
        assertEquals(a, p.getPisteet());
    }
    
    @Test
    public void nollaKorttiaTuoNollaMuutostaVihollisnoppiin(){
        assertEquals(0, p.getViholliskorttimuutokset());
    }
    
    @Test
    public void nollaKorttiaTuoNollaMuutostaTaistelunoppiin(){
        assertEquals(0, p.getTaistelukorttimuutokset());
    }
    
    @Test
    public void nollaKorttiaTuoNollaMuutostaAarrenoppiin(){
        assertEquals(0, p.getAarrekorttimuutokset());
    }
    
    @Test
    public void testikorttiMuuttaaVNoppiaYhdella(){
        p.lisaaKortti(new TestiKortti());
        assertEquals(1, p.getViholliskorttimuutokset());
    }
    
    @Test
    public void testikorttiMuuttaaTNoppiaKahdella(){
        p.lisaaKortti(new TestiKortti());
        assertEquals(2, p.getTaistelukorttimuutokset());
    }
    
    @Test
    public void testikorttiMuuttaaANoppiaKolmella(){
        p.lisaaKortti(new TestiKortti());
        assertEquals(3, p.getAarrekorttimuutokset());
    }
    
    @Test
    public void kortinOstaminenOnnistuuKunRahaaOnTarpeeksi(){
        p.getKortit().clear();
        p.setRaha(150);
        Kortti a = new TestiKortti();
        p.osta(a);
        assertEquals(true, p.getKortit().contains(a));
    }
    
    @Test
    public void kortinOstaminenEiOnnistuKunRahaaEiOleTarpeeksi(){
        p.getKortit().clear();
        p.setRaha(100);
        Kortti a = new TestiKortti();
        p.osta(a);
        assertEquals(false, p.getKortit().contains(a));
    }
    
    @Test
    public void kortinOstaminenVahentaaRahatOikein(){
        p.setRaha(150);
        p.osta(new TestiKortti());
        assertEquals(27, p.getRaha());
    }
}
