
package lautapeli.lautapeli.domain.kortti;


public class MekaaninenAugmentaatio implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;

    public MekaaninenAugmentaatio() {
        nimi = "Mekaaninen Augmentaatio";
        tyyppi = "vta";
        kuvaus = "Lisää yhden nopan kaikkiin heittelyihin";
        hinta = 15;
    }
    
    @Override
    public int suorita(String tyyppi) {
        return 1;
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
