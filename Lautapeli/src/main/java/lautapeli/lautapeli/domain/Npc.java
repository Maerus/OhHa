
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;


public class Npc extends Pelaaja{
    private Random random;

    public Npc() {
        random = new Random();
    }
    
    /**
     * Metodi arpoo mitä tietokonepelaaja tekee vuorollaan.
     * 
     * @return vuorotoimenpide
     */
    @Override
    public String valitseVuoroToimepide(){
        return "pelaa";
        //placeholder
    }
    
    /**
     *
     */
    @Override
    public void osta() {
        //placeholder
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
