
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;
import lautapeli.lautapeli.gui.HeittelyFrame;
import lautapeli.lautapeli.logiikka.Peli;


public class Heittely {
    private int vihollisnopat;
    private int taistelunopat;
    private int aarrenopat;
    private Pelaaja pelaaja;
    private int vaihe;
    private int rerollit;
    private Random random;
    private ArrayList<Integer> nopat;
    private Peli peli;
    private HeittelyFrame heittelyraami;

    public Heittely(Luolasto luola , Pelaaja p, Peli peli) {
        pelaaja = p;
        
        vihollisnopat = luola.getVihollisnopat() + pelaaja.getViholliskorttimuutokset();
        taistelunopat = luola.getTaistelunopat() + pelaaja.getTaistelukorttimuutokset();
        aarrenopat = luola.getAarrenopat() + pelaaja.getAarrekorttimuutokset();
        
        rerollit = 2;
        vaihe = 0;
        random = new Random();
        
        this.peli = peli;
    }

    public ArrayList<Integer> getNopat() {
        return nopat;
    }
    
    
    
    /**
     * Metodi aloittaa heittelytoiminnan, johon kuuluu uuden heittelyraamin luominen
     * ja noppien visualisointi, sekä noppien valinta ja rerollaus.
     * Heittely on kolmiosainen ja siihen kuuluu kullekin noppatyypille omat rollit.
     */
    void suoritaHeittely() {
        heittele(vihollisnopat);
        heittelyraami = peli.getUi().luoHeittelyraami(this);
        odota();
        tallennaViholliset();
        
        heittele(taistelunopat);
        heittelyraami.paivitaVaihe();
        odota();
//        tallennaTaistelu();
        
        heittele(aarrenopat);
        heittelyraami.paivitaVaihe();
        odota();
//        palkitse();
    }
    
    private int vihA;
    private int vihB;
    private int vihC;
    private void tallennaViholliset(){
        vihA=0;
        vihB=0;
        vihC=0;
        for (Integer noppa : nopat) {
            if (noppa > 1 && noppa < 3){
                vihA++;
            } else if (noppa > 3 && noppa < 6){
                vihB++;
            } else if (noppa == 6){
                vihC++;
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
    
    public void notifioiLukko(){
        synchronized(lock){
            ready = true;
            lock.notify();
        }
    }
    
    /**
     * Metodi suorittaa yhden heittelytilanteen ja 
     * @param noppamaara 
     */
    void heittele(int noppamaara) {
        nopat = new ArrayList<>();
        vaihe++;
        
        if(pelaaja.getClass().equals(Npc.class)){
            heitaNopat(noppamaara);
            System.out.println("heittely metodi saavutettu");
            return;
        }
        
        heitaNopat(noppamaara);
    }
    
    /**
     * Metodi heittää vaihekohtaisesti luolastolta ja korteista saaman määrän noppia.
     * @param lkm 
     */
    void heitaNopat(int lkm){
        for (int i = 0; i < lkm; i++) {
            nopat.add(random.nextInt(6)+1);
        }
    }

    /**
     * Metodi suorittaa uudelleenheittelyn. 
     */
    public void reroll() {
        if (rerollit == 0){
            return;
        }
        rerollit--;
        
        for (int i = 0; i < heittelyraami.getTaulukko().length; i++) {
            if ( heittelyraami.getTaulukko()[i] == true ){
                int uusinoppa = random.nextInt(6)+1;
                nopat.set(i, uusinoppa);
                heittelyraami.getNoppanapit().get(i).setText("" + uusinoppa);
            }
        }
        peli.getUi().getHeittelyraami().paivitaNappiKomponentit();
    }

    public String getVaihe() {
        if (vaihe == 1){
            return "Vihollisnopat";
        } else if (vaihe == 2){
            return "Taistelunopat";
        } else if (vaihe == 3){
            return "Aarrenopat";
        }
        return "";
    }

    public int getRerollit() {
        return rerollit;
    }

    public void setRerollit(int i) {
        rerollit = i;
    }


    
}
