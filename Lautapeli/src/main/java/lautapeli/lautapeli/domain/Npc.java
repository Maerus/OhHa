
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;
import lautapeli.lautapeli.domain.kortti.Kortti;


public class Npc extends Pelaaja{
    private Random random;

    public Npc() {
        random = new Random();
    }
    
    /**
     * Metodi arpoo mitä tietokonepelaaja tekee vuorollaan.
     * 
     */
    @Override
    public void valitseVuoroToimepide(){
        //placeholder                                                               aaaaaaaaaa
    }
    
    /**
     * Metodi ostaa tietokonepelaajalle jonkun kortin, johon on varaa
     */
    @Override
    public void osta(Kortti kortti) {
        //placeholder                                                               aaaaaaaaaa
    }
    
    /**
     * Metodi arpoo tietokonepelaajalle luolaston jonka se valitsee
     * 
     * @param luolastot
     */
    @Override
    public void valitseLuolasto(ArrayList<Luolasto> luolastot) {
        Heittely a = new Heittely(luolastot.get(random.nextInt(3)) , this);
        a.heittele();
    }
}
