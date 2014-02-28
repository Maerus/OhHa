
package lautapeli.lautapeli.logiikka;

import java.util.ArrayList;
import lautapeli.lautapeli.domain.Korttipakka;
import lautapeli.lautapeli.domain.Luolasto;
import lautapeli.lautapeli.domain.Luolastopakka;
import lautapeli.lautapeli.domain.Npc;
import lautapeli.lautapeli.domain.Pelaaja;
import lautapeli.lautapeli.domain.kortti.Kortti;
import lautapeli.lautapeli.gui.Kayttoliittyma;

/**
 * Pelilogiikka, joka suorittaa pelin kierrosloopin.
 */
public class Peli {
    private int kierros;
    private boolean jatkuu;
    private ArrayList<Pelaaja> pelaajat;
    private int ylaraja;
    private ArrayList<Luolasto> luolastot;
    private ArrayList<Kortti> kauppa;
    private Kayttoliittyma ui;
    private Luolastopakka luolastopakka;
    private Korttipakka korttipakka;
    
    public Peli(Kayttoliittyma ui){
        kierros = 0;
        jatkuu = true;
        pelaajat = new ArrayList<>();
        
        ylaraja = 50;
        luolastot = new ArrayList<>();
        
        kauppa = new ArrayList<>();
        this.ui = ui;
        luolastopakka = new Luolastopakka();
        korttipakka = new Korttipakka();
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
    private void lisaaPelaajat() {
        lisaaPelaaja(new Pelaaja(this));
        lisaaPelaaja(new Npc(this));
        lisaaPelaaja(new Npc(this));
        lisaaPelaaja(new Npc(this));
    }

    public ArrayList<Luolasto> getLuolastot() {
        return luolastot;
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
        lisaaPelaajat();
        lisaaLuolastot();
    }
    
    
    /**
     * Public metodi pelin käynnistämiseen.
     */
    public void pelaa(){
        kaynnistaKierros();
    }
    
    
    /**
     * Metodi valitsee kolme luolastoa luolastopakasta ja asettaa ne peliin.
     */
    void lisaaLuolastot(){
        luolastot.add(luolastopakka.otaLuolasto());
        luolastot.add(luolastopakka.otaLuolasto());
        luolastot.add(luolastopakka.otaLuolasto());
    }
    
    /**
     * Metodi käynnistää pelikierroksen.
     * Metodi looppaa itseänsä, kunnes joku pelaaja ylittää vuorollansa pisterajan.
     * 
     */
    void kaynnistaKierros(){
        kierros++;
        
        try{
            ui.kierros.setText("Kierros:  " + kierros);
        } catch (Exception e) {
            //testien ui päivityksen ohitukseen, koska testeissä ui = null
        }
        
        for (int i = 0; i < 4; i++) {
            suoritaVuoro(pelaajat.get(i), i);
        }
        
        if (jatkuu){
            kaynnistaKierros();
        }
        
        if (!jatkuu){
            try{
                ui.luoLoppuraami();
                pysayta();
            } catch (Exception e){}
        }
    }
    
    /**
     * Metodi pysäyttää peliloopin.
     */
    private void pysayta(){
        final Object lukko = new Object();
        boolean ready = false;
        synchronized(lukko){
            while(!ready){
                try{
                    lukko.wait();
                } catch (InterruptedException e) {}
            }
        }
    }
    
    
    /**
     * Metodi suorittaa pelaajan vuoron.
     * Vuoron lopulla pelaajalle annetaan piste ja kolme rahaa.
     * 
     * @param pelaaja
     */
    private void suoritaVuoro(Pelaaja pelaaja, int pelaajanumero){
        pelaaja.valitseVuoroToimepide();
        paivitaPelaajaKomponentit(pelaajanumero);
        
        
        pelaaja.lisaaPiste();
        pelaaja.lisaaRahaa(3);
        
        if (pelaaja.getPisteet() >= ylaraja){
            jatkuu = false;
        }
        paivitaPelaajaKomponentit(pelaajanumero);
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {}
    }
    
    
    /**
     * Metodi päivityttää vuoron suorittaneen pelaajan tiedot käyttöliittymään.
     * 
     * @param pelaajanumero 
     */
    private void paivitaPelaajaKomponentit(int pelaajanumero) {
        if (pelaajanumero == 0){
            try{
                ui.getPpanel().paivitaKomponentit();
            }catch(Exception e){}
        }
        if (pelaajanumero == 1){
            try{
                ui.getN1panel().paivitaKomponentit();
            }catch(Exception e){}
        }
        if (pelaajanumero == 2){
            try{
                ui.getN2panel().paivitaKomponentit();
            }catch(Exception e){}
        }
        if (pelaajanumero == 3){
            try{
                ui.getN3panel().paivitaKomponentit();
            }catch(Exception e){}
        }
    }

    public Kayttoliittyma getUi() {
        return ui;
    }
    
    public Korttipakka getKorttipakka(){
        return korttipakka;
    }

    
    
}
