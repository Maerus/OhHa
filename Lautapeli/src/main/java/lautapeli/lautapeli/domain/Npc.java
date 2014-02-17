
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;
import lautapeli.lautapeli.domain.kortti.Kortti;
import lautapeli.lautapeli.logiikka.Peli;


public class Npc extends Pelaaja{
    private Random random;
    private Peli peli;

    public Npc(Peli peli) {
        super(peli);
        random = new Random();
    }
    
    /**
     * Metodi arpoo mitä tietokonepelaaja tekee vuorollaan.
     * 
     */
    @Override
    public void valitseVuoroToimepide(){
        //EI TEE VIELÄ MITÄÄN VUOROLLAAN
        //placeholder                                                               aaaaaaaaaa
    }
    
    /**
     * Metodi ostaa tietokonepelaajalle kortin
     * @return true koska testattu ennestään.
     * 
     */
    @Override
        public boolean osta(Kortti kortti) {
            return true;
        //placeholder                                                               aaaaaaaaaa
    }
    
    /**
     * Metodi arpoo tietokonepelaajalle luolaston jonka se valitsee
     * 
     * @param luolastot
     */
    
    public void valitseLuolasto(ArrayList<Luolasto> luolastot) {
        Heittely a = new Heittely(luolastot.get(random.nextInt(3)), this, peli);
        a.heittele();
    }
}
