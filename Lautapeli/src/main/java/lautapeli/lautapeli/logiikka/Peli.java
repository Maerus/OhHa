
package lautapeli.lautapeli.logiikka;

import java.util.ArrayList;
import lautapeli.lautapeli.Pelaaja;


public class Peli {
    private int kierros;
    private boolean jatkuu;
    private ArrayList<Pelaaja> pelaajat;
    private int ylaraja;

    
    public Peli(){
        kierros = 0;
        jatkuu = true;
        pelaajat = new ArrayList<>();
        pelaajat.add(new Pelaaja());
        ylaraja = 20;
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
        kaynnistaKierros();
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
            pelaaja.pelaa();
        }
        
        if (pelaaja.getPisteet() >= ylaraja){
            jatkuu = false;
        }
    }
    
    
}
