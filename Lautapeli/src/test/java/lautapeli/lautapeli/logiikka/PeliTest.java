

package lautapeli.lautapeli.logiikka;

import lautapeli.lautapeli.domain.Pelaaja;
import lautapeli.lautapeli.logiikka.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PeliTest {
    
    public PeliTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Peli peli;
    
    @Before
    public void setUp() {
        peli = new Peli();
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
    @Test
    public void LuotuPeliJatkuu(){
        assertEquals(true, peli.getJatkuu());
    }
    
    @Test
    public void KaynnistamattomanPelinKierrosOnNolla(){
        assertEquals(0, peli.getKierros());
    }
    
    @Test
    public void YhdenLoopinKestavanPelinKierroslukuOnYksi(){
        peli.setYlaraja(1);
        
        peli.lisaaPelaaja(new Pelaaja(true));
        peli.lisaaPelaaja(new Pelaaja(true));
        
        peli.getPelaajat().get(0).setPisteet(peli.getYlaraja());
        
        peli.pelaa();
        assertEquals(1, peli.getKierros());
    }
    
    @Test
    public void PelinLoputtuaVahintaanYhdellaPelaajallaOnYlarajanVerranPisteita(){
        peli.lisaaPelaaja(new Pelaaja(true));
        peli.lisaaPelaaja(new Pelaaja(true));
        
        peli.getPelaajat().get(0).setPisteet(peli.getYlaraja());
        
        peli.pelaa();
        boolean test = false;
        for (Pelaaja p : peli.getPelaajat()) {
            if(p.getPisteet() >= peli.getYlaraja()){
                test = true;
            }
        }
        assertEquals(true, test);
    }
}
