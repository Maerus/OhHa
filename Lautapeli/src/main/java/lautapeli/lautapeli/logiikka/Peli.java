
package lautapeli.lautapeli.logiikka;

import java.util.ArrayList;
import lautapeli.lautapeli.domain.Luolasto;
import lautapeli.lautapeli.domain.Pelaaja;


public class Peli {
    private int kierros;
    private boolean jatkuu;
    private ArrayList<Pelaaja> pelaajat;
    private int ylaraja;
    private ArrayList<Luolasto> luolastot;
    
    public Peli(){
        kierros = 0;
        jatkuu = true;
        pelaajat = new ArrayList<>();
        
        ylaraja = 20;
        luolastot = new ArrayList<>();
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
    
    public void lisaaPelaaja(Pelaaja p){
        pelaajat.add(p);
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
    
    public void pelaa() {
        lisaaLuolastot();
        kaynnistaKierros();
    }
    
    void lisaaLuolastot(){
        //placeholder
        luolastot.add(new Luolasto());
        luolastot.add(new Luolasto());
        luolastot.add(new Luolasto());
    } 
    
    void kaynnistaKierros(){
        kierros++;
        
        for (Pelaaja pelaaja : pelaajat) {
            suoritaVuoro(pelaaja);
        }
        
        if (jatkuu){
            kaynnistaKierros();
        }
    }
    
    private void suoritaVuoro(Pelaaja pelaaja) {
        /*
        Ensin kysytään pelaajalta mennäänkö luolastoon vai kauppaan.
        Kaupassa suoritetaan ostotoimenpide ja lopetetaan vuoro.
        Luolastossa heitetään nopat.
        jne jne
        */
        
        if(pelaaja.valitseVuoroToimepide().equals("kauppa")){
            pelaaja.osta();
        } else {
            pelaaja.valitseLuolasto(luolastot);
        }
        
        if (pelaaja.getPisteet() >= ylaraja){
            jatkuu = false;
        }
        pelaaja.lisaaPiste(); //test
    }
    
    
}
