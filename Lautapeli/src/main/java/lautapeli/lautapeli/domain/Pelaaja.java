
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;


public class Pelaaja {
    private int pisteet;
    private boolean npc;
    private Random random;
    
    public Pelaaja(){
        this(false);
    }
    
    public Pelaaja(Boolean npc){
        pisteet = 0;
        this.npc = npc;
        random = new Random();
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int p) {
        pisteet = p;
    }

    public void setNpc(boolean npc) {
        this.npc = npc;
    }
    
    public boolean getNpc() {
        return npc;
    }
    
    public void lisaaPiste(){
        pisteet++;
    }

    public String valitseVuoroToimepide() {
        if (npc){
            return "pelaa";
        }
        //placeholder
        return "pelaa";
    }

    public void osta() {
        //placeholder
    }

    public Luolasto valitseLuolasto(ArrayList<Luolasto> luolastot) {
        if (npc){
            return luolastot.get(random.nextInt(luolastot.size()));
        }
        
        return null;
    }


}
