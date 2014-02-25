
package lautapeli.lautapeli.domain.kortti;


public class Haaste implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;
    private boolean lohikaarme;

    public Haaste() {
        nimi = "Haaste";
        tyyppi = "a";
        kuvaus = "Jos taistelussa on 2+ lohikäärmenoppaa,\n"
                + "lisää kaksi aarrenoppaa";
        hinta = 123;
        lohikaarme = false;
    }
    
    @Override
    public int suorita(String tyyppi) {
        if(lohikaarme){
            lohikaarme = false;
            return 2;
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
