
package lautapeli.lautapeli.domain.kortti;

import java.util.Random;


public class Rohkeus implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;
    private Random r;

    public Rohkeus() {
        nimi = "Rohkeus";
        tyyppi = "va";
        kuvaus = "Lisää yhden vihollisnopan, sekä\n"
                + "lisää 1-2 aarrenoppaa";
        hinta = 20;
        r = new Random();
    }
    
    @Override
    public int suorita(String tyyppi) {
        if (tyyppi.equals("v")){
            return 1;
        }
        
        if (tyyppi.equals("a")){
            return r.nextInt(2)+1;
        }
        
        return 0;
    }
    
    @Override
    public String getNimi() {
        return nimi;
    }
    
    @Override
    public String getKuvaus() {
        return kuvaus;
    }

    @Override
    public String getTyyppi() {
        return tyyppi;
    }

    @Override
    public int getHinta() {
        return hinta;
    }

    @Override
    public void tiedotaViholliset(int luuranko, int orkki, int lohikaarme) {
    }
}
