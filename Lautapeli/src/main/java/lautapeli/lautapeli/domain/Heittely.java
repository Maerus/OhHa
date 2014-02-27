
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;
import lautapeli.lautapeli.domain.kortti.Kortti;
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
    private Luolasto luola;
    private Korttipakka korttipakka;

    public Heittely(Luolasto luola , Pelaaja p, Peli peli) {
        pelaaja = p;
        this.luola = luola; 
        rerollit = 2;
        vaihe = 0;
        random = new Random();
        this.peli = peli;
        try{
            korttipakka = peli.getKorttipakka(); //testiä varten try-catchin sisällä
        } catch (Exception e){}
        
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
        vihollisnopat = luola.getVihollisnopat() + pelaaja.getViholliskorttimuutokset();
        heittele(vihollisnopat);
        if (!pelaaja.getClass().equals(Npc.class)){
            heittelyraami = peli.getUi().luoHeittelyraami(this);
            odota();
        }
        tallennaViholliset();
        for (Kortti kortti : pelaaja.getKortit()) {
            kortti.tiedotaViholliset(luuranko, orkki, lohari);
        }
        
        taistelunopat = luola.getTaistelunopat() + pelaaja.getTaistelukorttimuutokset();
        heittele(taistelunopat);
        if (!pelaaja.getClass().equals(Npc.class)){
            heittelyraami.paivitaVaihe();
            odota();
        }
        taistele();
        
        if (voitto){
            aarrenopat = luola.getAarrenopat() + pelaaja.getAarrekorttimuutokset();
            heittele(aarrenopat);
        } else {
            heittele(0);
        }
        if (!pelaaja.getClass().equals(Npc.class)){
            heittelyraami.paivitaVaihe();
            odota();
        }
        palkitse();
    }
    
    private int luuranko;
    private int orkki;
    private int lohari;
    private void tallennaViholliset(){
        luuranko=0;
        orkki=0;
        lohari=0;
        for (Integer noppa : nopat) {
            if (noppa > 1 && noppa < 4){
                luuranko++;
            } else if (noppa > 3 && noppa < 6){
                orkki++;
            } else if (noppa == 6){
                lohari++;
            }
        }
        
        luuranko = luuranko/2;
        if(orkki > 0){
            orkki--;
        }
        if(lohari < 2){
            lohari = 0;
        }
    }
    
    private boolean voitto;
    private void taistele() {
        voitto = false;
        int nyrkit = 0;
        int jousi = 0;
        int miekka = 0;
        int tulipallo = 0;
        for (Integer noppa : nopat) {
            if (noppa > 1 && noppa < 4){
                nyrkit++;
            } else if (noppa == 4){
                jousi++;
            } else if (noppa == 5){
                miekka++;
            } else if (noppa == 6){
                tulipallo++;
            }
        }
        nyrkit = nyrkit/2;
        if(jousi > 0){
            jousi--;
        }
        if(miekka > 0){
            miekka--;
        }
        if(tulipallo < 2){
            tulipallo = 0;
        }
        int voima = nyrkit+jousi+miekka+tulipallo;
        int vastus = luuranko+orkki+lohari;
        if (voima >= vastus){
            voitto = true;
        }
    }
    
    private void palkitse() {
        int raha1 = 0;
        int raha2 = 0;
        int voittopiste = 0;
        int kortti = 0;
        for (Integer noppa : nopat) {
            if (noppa > 1 && noppa < 4){
                raha1++;
            } else if (noppa == 4){
                raha2++;
            } else if (noppa == 5){
                voittopiste++;
            } else if (noppa == 6){
                kortti++;
            }
        }
        if (raha1 < 2){
            raha1 = 0;
        } else {
            int i = raha1 - 2;
            raha1 = 3 + i*2;
        }
        if (raha2 < 2){
            raha2 = 0;
        } else {
            int j = raha2 - 2;
            raha2 = 5 + j*3;
        }
        if(voittopiste > 0){
            voittopiste--;
        }
        kortti = kortti / 3;
        // määrittää montako korttia saadaan pakasta
        
        for (int i = 0; i < voittopiste; i++) {
            pelaaja.lisaaPiste();
        }
        pelaaja.lisaaRahaa(raha1+raha2);
        for (int i = 0; i < kortti; i++) {
            pelaaja.lisaaKortti(korttipakka.otaKortti());                    
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
                heittelyraami.getNoppanapit().get(i).paivitaKuva(getVaihe(), uusinoppa);
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
