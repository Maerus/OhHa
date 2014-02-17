
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;
import lautapeli.lautapeli.logiikka.Peli;


class Heittely {
    private int vihollisnopat;
    private int taistelunopat;
    private int aarrenopat;
    private Pelaaja pelaaja;
    private int vaihe;
    private Random random;
    private ArrayList<Integer> nopat;
    private Peli peli;

    public Heittely(Luolasto luola , Pelaaja p, Peli peli) {
        pelaaja = p;
        
        vihollisnopat = luola.getVihollisnopat() + pelaaja.getViholliskorttimuutokset();
        taistelunopat = luola.getTaistelunopat() + pelaaja.getTaistelukorttimuutokset();
        aarrenopat = luola.getAarrenopat() + pelaaja.getAarrekorttimuutokset();
        
        vaihe = 1;
        random = new Random();
        nopat = new ArrayList<>();
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
    void heittele() {
        //ui.luoHeittelyFrame()
        peli.getUi().luoHeittelyraami();
        //hframe.haeHeittelytiedot()
        //
        if(pelaaja.getClass().equals(Npc.class)){
            heitaNopat(vihollisnopat);
            System.out.println("heittely metodi saavutettu");
            return;
        }
        
        heitaNopat(vihollisnopat);
        System.out.println("heittely metodi saavutettu");
        //placeholder stuff
    }
    
    /**
     * Metodi heittää vaihekohtaisesti luolastolta ja korteista saaman määrän noppia.
     * @param lkm 
     */
    void heitaNopat(int lkm){
        for (int i = 0; i < lkm; i++) {
            nopat.add(random.nextInt(6)+1);
        }
        reroll();
    }

    /**
     * Metodi suorittaa uudelleenheittelyn. 
     */
    private void reroll() {
        //placeholder
        
    }
}
