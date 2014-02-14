
package lautapeli.lautapeli.domain;

import lautapeli.lautapeli.domain.kortti.Kortti;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;


public class Pelaaja {
    private int pisteet;
    private int raha;
    private ArrayList<Kortti> kortit;
    private final ReentrantLock lock;
    private boolean ready;
    
    public Pelaaja(){
        pisteet = 0;
        raha = 0;
        kortit = new ArrayList<>();
        lock = new ReentrantLock();
        ready = false;
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

    /**
     * Metodi jää odottamaan pelaajan toimintaa.
     * Toimintakomennon saatua metodi suorittaa halutun toiminnon.
     * Toiminto on joko heittely valitussa luolastossa tai kortin osto kaupasta.
     * 
     */
    public void valitseVuoroToimepide(){
        
        /*
        tapahtumakuuntelija triggeroi readyn lukolle tjsp kun valitaan toimenpide.
        valintana on joko luolasto tai kortti (kaupassa).
        luolaston kohdalla luodaan heittely, kortin kohdalla ostetaan kortti.
        */
        
        //tänne tarttis joku lukitus joka aukeaa, kun painetaan sopivaa nappulaa
        
        //idk asdasdadad
        
        //placeholder                                                               aaaaaaaaaa
        
    }

    /**
     * Metodi ostaa pelaajalle kortin kaupasta, jos siihen on varaa.
     * 
     * (Nappia en tosin anna painaa jos rahaa ei ole :V)
     * 
     * @param kortti
     */
    public void osta(Kortti kortti) {
        if (raha > kortti.getHinta()){
            raha -= kortti.getHinta();
            kortit.add(kortti);
        }
        //tänne actionEvent poistamaan kaupasta kyseinen kortti                     aaaaaaaaaa
        //tai sitten ihan vaan tehdään metodi, joka päivittää sen kortin :|
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
    
    /**
     * Metodi pyytää pelaajaa valitsemaan luolaston.
     * @param luolastot
     */
    public void valitseLuolasto(ArrayList<Luolasto> luolastot) {
        //placeholder                                                               aaaaaaaaaa
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
