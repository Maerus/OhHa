
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
    
    /**
     * Metodi lisää pelaajalle pisteen.
     */
    public void lisaaPiste(){
        pisteet++;
    }

    /**
     *
     * @return
     */
    public String valitseVuoroToimepide() {
        //placeholder
        return "pelaa";
    }

    /**
     * Metodi pyytää pelaajaa valitsemaan kaupasta kortin.
     */
    public void osta() {
        //placeholder
    }

    /**
     * Metodi pyytää pelaajaa valitsemaan luolaston.
     * @param luolastot
     */
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
