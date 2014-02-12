
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

    /**
     * Metodi jää odottamaan pelaajan toimintaa.
     * Toimintakomennon saatua metodi suorittaa halutun toiminnon.
     * 
     * @return
     * @throws java.lang.InterruptedException
     */
    public void valitseVuoroToimepide() throws InterruptedException {
        
        /*
        tapahtumakuuntelija triggeroi readyn kun valitaan toimenpide.
        valintana on joko luolasto tai kortti (kaupassa).
        luolaston kohdalla luodaan heittely, kortin kohdalla ostetaan kortti.
        */
        
        synchronized(lock){
            ready = true;
            lock.notifyAll();
        }
        synchronized(lock){
            while(!ready){
                lock.wait();
            }
        }
        
        ready = false;
        
        
        
        //yet a placeholder                                                          aaaaaaaaaa
        
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
            if(kortti.getTyyppi().equals("viholliskortti")){
                a += kortti.suorita();
            }
        }
        return a;
    }

    int getTaistelukorttimuutokset() {
        int a = 0;
        for (Kortti kortti : kortit) {
            if(kortti.getTyyppi().equals("taistelukortti")){
                a += kortti.suorita();
            }
        }
        return a;
    }

    int getAarrekorttimuutokset() {
        int a = 0;
        for (Kortti kortti : kortit) {
            if(kortti.getTyyppi().equals("aarrekortti")){
                a += kortti.suorita();
            }
        }
        return a;
    }


}
