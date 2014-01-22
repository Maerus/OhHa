
package lautapeli.lautapeli;


public class Pelaaja {
    private int pisteet;
    
    public Pelaaja(){
        pisteet = 0;
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
        //
        return "pelaa";
    }

    public void osta() {
        //
    }

    public void pelaa() {
        //
    }
}
