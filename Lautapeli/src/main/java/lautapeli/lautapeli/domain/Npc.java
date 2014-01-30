
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;


public class Npc extends Pelaaja{
    private Random random;

    public Npc() {
        random = new Random();
    }
    
    @Override
    public String valitseVuoroToimepide(){
        return "pelaa";
    }
    
    @Override
    public void osta() {
        //placeholder
    }
    
    @Override
    public void valitseLuolasto(ArrayList<Luolasto> luolastot) {
        Heittely a = new Heittely(luolastot.get(random.nextInt(3)) , this);
        a.heittele();
    }
}
