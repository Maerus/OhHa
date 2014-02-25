
package lautapeli.lautapeli.domain.kortti;


public class Siunaus implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;
    private boolean luuranko;

    public Siunaus() {
        nimi = "Siunaus";
        tyyppi = "t";
        kuvaus = "Jos taistelussa on 2+ luurankonoppaa,\n"
                + "lisää yksi taistelunoppa";
        hinta = 123;
        luuranko = false;
    }
    
    @Override
    public int suorita(String tyyppi) {
        if(luuranko){
            luuranko = false;
            return 1;
        } else {
            return 0;
        }
        
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
        if (luuranko > 0){
            this.luuranko = true;
        }
    }
    
}
