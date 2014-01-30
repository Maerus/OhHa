
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;


public class Pelaaja {
    private int pisteet;
    private ArrayList<Kortti> kortit;
    
    public Pelaaja(){
        pisteet = 0;
        kortit = new ArrayList<>();
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int p) {
        pisteet = p;
    }
    
    public void lisaaPiste(){
        pisteet++;
    }

    public String valitseVuoroToimepide() {
        //placeholder
        return "pelaa";
    }

    public void osta() {
        //placeholder
    }

    public void valitseLuolasto(ArrayList<Luolasto> luolastot) {
        //nope
        
    }


}
