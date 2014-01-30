
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;


class Heittely {
    private int vihollisnopat;
    private int taistelunopat;
    private int aarrenopat;
    private Pelaaja pelaaja;
    private int vaihe;
    private Random random;
    private ArrayList<Integer> nopat;

    public Heittely(Luolasto luola , Pelaaja p) {
        pelaaja = p;
        
        vihollisnopat = luola.getVihollisnopat() + pelaaja.getViholliskorttimuutokset();
        taistelunopat = luola.getTaistelunopat() + pelaaja.getTaistelukorttimuutokset();
        aarrenopat = luola.getAarrenopat() + pelaaja.getAarrekorttimuutokset();
        
        vaihe = 1;
        random = new Random();
        nopat = new ArrayList<>();
    }

    public ArrayList<Integer> getNopat() {
        return nopat;
    }

    void heittele() {
        heitaNopat(vihollisnopat);
    }
    
    void heitaNopat(int lkm){
        for (int i = 0; i < lkm; i++) {
            nopat.add(random.nextInt(6)+1);
        }
        reroll();
    }

    private void reroll() {
        //placeholder
        
        //vaihekohtaiset toiminnot tänne
    }
}