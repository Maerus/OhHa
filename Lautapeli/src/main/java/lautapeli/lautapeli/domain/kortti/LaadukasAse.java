
package lautapeli.lautapeli.domain.kortti;

import java.util.Random;


public class LaadukasAse implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;
    private Random r;

    public LaadukasAse() {
        nimi = "Laadukas Ase";
        tyyppi = "t";
        kuvaus = "(75%) Lisää nopan taisteluvaiheeseen\n"
                + "jos onnistuu, (25%) lisää toinen noppa";
        hinta = 18;
        r = new Random();
    }
    
    @Override
    public int suorita(String tyyppi) {
        int a = 0;
        if (r.nextInt(4) > 0){
            a++;
            if(r.nextInt(4) == 0) {
                a++;
            }
        }
        return a;
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
