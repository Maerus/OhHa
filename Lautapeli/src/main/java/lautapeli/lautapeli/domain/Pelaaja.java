
package lautapeli.lautapeli.domain;

import lautapeli.lautapeli.domain.kortti.Kortti;
import java.util.ArrayList;


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
        //placeholder
    }

    int getViholliskorttimuutokset() {
        int a = 0;
        for (Kortti kortti : kortit) {
            if(kortti.getTyyppi().equals("viholliskortti")){
                a += kortti.suorita();
            }
        }
        return a;
    }

    int getTaistelukorttimuutokset() {
        int a = 0;
        for (Kortti kortti : kortit) {
            if(kortti.getTyyppi().equals("taistelukortti")){
                a += kortti.suorita();
            }
        }
        return a;
    }

    int getAarrekorttimuutokset() {
        int a = 0;
        for (Kortti kortti : kortit) {
            if(kortti.getTyyppi().equals("aarrekortti")){
                a += kortti.suorita();
            }
        }
        return a;
    }


}
