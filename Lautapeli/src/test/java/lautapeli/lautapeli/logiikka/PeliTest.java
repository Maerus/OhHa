

package lautapeli.lautapeli.logiikka;

import lautapeli.lautapeli.domain.Npc;
import lautapeli.lautapeli.domain.Pelaaja;
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
        peli = new Peli(null);
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
    @Test
    public void luotuPeliJatkuu(){
        assertEquals(true, peli.getJatkuu());
    }
    
    @Test
    public void kaynnistamattomanPelinKierrosOnNolla(){
        assertEquals(0, peli.getKierros());
    }
    
    @Test
    public void pelinAlustusLuo4Pelaajaa(){
        peli.alusta();
        assertEquals(4, peli.getPelaajat().size());
    }
    
    @Test
    public void pelinAlustusLisaa3Luolastoa(){
        peli.alusta();
        assertEquals(3, peli.getLuolastot().size());
    }
    
    @Test
    public void yhdenLoopinKestavanPelinKierroslukuOnYksi() throws InterruptedException{
        peli.setYlaraja(1);
        
        peli.lisaaPelaaja(new Npc(peli));
        peli.lisaaPelaaja(new Npc(peli));
        peli.lisaaPelaaja(new Npc(peli));
        peli.lisaaPelaaja(new Npc(peli));
        
        peli.getPelaajat().get(0).setPisteet(peli.getYlaraja());
        
        peli.pelaa();
        assertEquals(1, peli.getKierros());
    }
    
    @Test
    public void pelinLoputtuaVahintaanYhdellaPelaajallaOnYlarajanVerranPisteita() throws InterruptedException{
        peli.lisaaPelaaja(new Npc(peli));
        peli.lisaaPelaaja(new Npc(peli));
        peli.lisaaPelaaja(new Npc(peli));
        peli.lisaaPelaaja(new Npc(peli));
        
        peli.getPelaajat().get(0).setPisteet(peli.getYlaraja());
        
        peli.lisaaLuolastot();
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
