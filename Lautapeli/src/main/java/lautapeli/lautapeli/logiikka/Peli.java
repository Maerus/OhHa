
package lautapeli.lautapeli.logiikka;

import java.util.ArrayList;
import lautapeli.lautapeli.domain.Luolasto;
import lautapeli.lautapeli.domain.Npc;
import lautapeli.lautapeli.domain.Pelaaja;
import lautapeli.lautapeli.domain.kortti.Kortti;


public class Peli {
    private int kierros;
    private boolean jatkuu;
    private ArrayList<Pelaaja> pelaajat;
    private int ylaraja;
    private ArrayList<Luolasto> luolastot;
    private ArrayList<Kortti> kauppa;
    
    public Peli(){
        kierros = 0;
        jatkuu = true;
        pelaajat = new ArrayList<>();
        
        ylaraja = 20;
        luolastot = new ArrayList<>();
        
        kauppa = new ArrayList<>();
        
    }

    public boolean getJatkuu() {
        return jatkuu;
    }

    public void setJatkuu(boolean x) {
        jatkuu = x;
    }

    public int getKierros() {
        return kierros;
    }
    
    /**
     * Metodi lisää peliin pelaajan.
     * @param p 
     */
    public void lisaaPelaaja(Pelaaja p){
        pelaajat.add(p);
    }
    
    /**
     * metodi lisää pelaajat peliin.
     */
    private void lisääPelaajat() {
        lisaaPelaaja(new Pelaaja());
        lisaaPelaaja(new Npc());
        lisaaPelaaja(new Npc());
        lisaaPelaaja(new Npc());
    }
    
    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }
    
    public void setYlaraja(int i){
        ylaraja = i;
    }

    public int getYlaraja() {
        return ylaraja;
    }
    
    /**
     * Metodi käynnistää pelilogiikan loopin.
     */
    public void alusta(){
        lisääPelaajat();
        lisaaLuolastot();
    }
    
    public void pelaa() throws InterruptedException{
        kaynnistaKierros();
    }
    
    /**
     * Metodi valitsee kolme luolastoa luolastopakasta ja asettaa ne peliin.
     */
    void lisaaLuolastot(){
        
        /*
        Luolastot laitetaan pakkaan, josta ne otetaan tässä metodissa peliin
        */
        
        //placeholder
        luolastot.add(new Luolasto());
        luolastot.add(new Luolasto());
        luolastot.add(new Luolasto());
    }
    
    void lisaaKorttiKauppaan(){
        
        /*
        korttipakasta nostetaan kolme korttia kauppaan
        */
        
        //placeholder                                                               aaaaaaaaaa
    }
    
    /**
     * Metodi käynnistää pelikierroksen.
     * Metodi looppaa itseänsä, kunnes joku pelaaja ylittää vuorollansa pisterajan.
     * 
     * @throws InterruptedException 
     */
    void kaynnistaKierros() throws InterruptedException{
        kierros++;
        
        for (Pelaaja pelaaja : pelaajat) {
            suoritaVuoro(pelaaja);
        }
        
        if (jatkuu){
            kaynnistaKierros();
        }
    }
    
    /**
     * Metodi suorittaa pelaajan vuoron.
     * 
     * @param pelaaja
     * @throws InterruptedException 
     */
    private void suoritaVuoro(Pelaaja pelaaja) throws InterruptedException {
        pelaaja.valitseVuoroToimepide();
        
        if (pelaaja.getPisteet() >= ylaraja){
            jatkuu = false;
        }
        pelaaja.lisaaPiste(); //test?
    }


    
    
}
