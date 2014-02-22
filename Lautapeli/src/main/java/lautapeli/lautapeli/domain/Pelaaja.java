
package lautapeli.lautapeli.domain;

import lautapeli.lautapeli.domain.kortti.Kortti;
import java.util.ArrayList;
import lautapeli.lautapeli.logiikka.Peli;


public class Pelaaja {
    private int pisteet;
    private int raha;
    private ArrayList<Kortti> kortit;
    private Peli peli;
    
    public Pelaaja(Peli peli){
        pisteet = 0;
        raha = 0;
        kortit = new ArrayList<>();
        this.peli = peli;
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int p) {
        pisteet = p;
    }
    
    /**
     * Metodi lisää pelaajalle pisteen.
     */
    public void lisaaPiste(){
        pisteet++;
    }
    

    public ArrayList<Kortti> getKortit() {
        return kortit;
    }
    
    private Valinta valinta;
    public void setValinta(Valinta valinta) {
        this.valinta = valinta;
    }
    
    private Kortti valittuKortti;
    public void setValittuKortti(Kortti valittuKortti) {
        this.valittuKortti = valittuKortti;
    }
    
    private Luolasto valittuLuolasto;
    public void setValittuLuolasto(Luolasto valittuLuolasto) {
        this.valittuLuolasto = valittuLuolasto;
    }
    
    
    /**
     * Metodi jää odottamaan pelaajan toimintaa.
     * Toimintakomennon saatua metodi suorittaa halutun toiminnon.
     * Toiminto on joko heittely valitussa luolastossa tai kortin osto kaupasta.
     * 
     */
    public void valitseVuoroToimepide() {
        valinta = Valinta.EI_VALINTAA;
        valittuKortti = null;
        valittuLuolasto = null;
        
        odota();
        //actionlistener syöttää uuden valinnan ja valitun kohteen samalla, kun lopettaa odottamisen.
        if (valinta == Valinta.LUOLASTO){
            Heittely heittely = new Heittely(valittuLuolasto, this, peli);
            heittely.suoritaHeittely();
        } else if (valinta == Valinta.KORTTI) {
            if(!osta(valittuKortti)){
                valitseVuoroToimepide();
            }
        }
    }
    
    private final Object lock = new Object();
    private boolean ready;
    private void odota(){
        ready = false;
        synchronized(lock){
            while(!ready){
                try{
                    lock.wait();
                } catch (InterruptedException e) {}
            }
        }
    }
    
    /**
     * Metodi avaa valitseVuoroToimepide() metodin lukon ja päästää sen jatkamaan eteenpäin.
     */
    public void notifioiLukko(){
        synchronized(lock){
            ready = true;
            lock.notify();
        }
    }
    


    /**
     * Metodi ostaa pelaajalle kortin kaupasta, jos siihen on varaa.
     * 
     * (Nappia en tosin anna painaa jos rahaa ei ole :V)
     * 
     * @param kortti
     * @return onnistuiko ostaminen
     */
    public boolean osta(Kortti kortti) {
        if (raha >= kortti.getHinta()){
            raha = raha - kortti.getHinta();
            kortit.add(kortti);
            return true;
        }
        //tänne actionEvent poistamaan kaupasta kyseinen kortti                     aaaaaaaaaa
        //tai sitten ihan vaan tehdään metodi, joka päivittää sen kortin :|
        return false;
    }
    
    /**
     * metodi korttien testausta varten pelaajan kanssa
     * 
     * @param kortti 
     */
    public void lisaaKortti(Kortti kortti){
        kortit.add(kortti);
    }
    
    /**
     * metodi ostamisen testausta varten
     * @param i 
     */
    public void setRaha(int i){
        if(i < 0){
            raha = 0;
        } else {
            raha = i;
        }
    }
    
    public void lisaaRahaa(int i){
        if (raha + i < 0){
            raha = 0;
        } else {
            raha += i;
        }
    }

    public int getRaha() {
        return raha;
    }

    int getViholliskorttimuutokset() {
        int a = 0;
        for (Kortti kortti : kortit) {
            if(kortti.getTyyppi().contains("v")){
                a += kortti.suorita("v");
            }
        }
        return a;
    }

    int getTaistelukorttimuutokset() {
        int a = 0;
        for (Kortti kortti : kortit) {
            if(kortti.getTyyppi().contains("t")){
                a += kortti.suorita("t");
            }
        }
        return a;
    }

    int getAarrekorttimuutokset() {
        int a = 0;
        for (Kortti kortti : kortit) {
            if(kortti.getTyyppi().contains("a")){
                a += kortti.suorita("a");
            }
        }
        return a;
    }


}
