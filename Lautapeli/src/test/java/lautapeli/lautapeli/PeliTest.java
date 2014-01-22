/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lautapeli.lautapeli;

import lautapeli.lautapeli.Pelaaja;
import lautapeli.lautapeli.logiikka.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Incognito
 */
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
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
    public void YhdenLoopinPelinKierroslukuOnYksi(){
        peli.setYlaraja(1);
        peli.getPelaajat().get(0).setPisteet(peli.getYlaraja());
        peli.pelaa();
        assertEquals(1, peli.getKierros());
    }
    
    @Test
    public void PelinLoputtuaVahintaanYhdellaPelaajallaOnYlarajanVerranPisteita(){
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
