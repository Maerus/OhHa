
package lautapeli.lautapeli.domain.kortti;


public class LohikaarmeenMetsastaja implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;
    private boolean lohikaarme;

    public LohikaarmeenMetsastaja() {
        nimi = "Siunaus";
        tyyppi = "t";
        kuvaus = "Jos taistelussa on 2+ lohikäärmenoppaa,\n"
                + "lisää yksi taistelunoppa";
        hinta = 15;
        lohikaarme = false;
    }
    
    @Override
    public int suorita(String tyyppi) {
        if(lohikaarme){
            lohikaarme = false;
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
        if (lohikaarme > 0){
            this.lohikaarme = true;
        }
    }
    
}
