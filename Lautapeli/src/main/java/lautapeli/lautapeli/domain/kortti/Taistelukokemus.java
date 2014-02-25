
package lautapeli.lautapeli.domain.kortti;


public class Taistelukokemus implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;

    public Taistelukokemus() {
        nimi = "Taistelukokemus";
        tyyppi = "t";
        kuvaus = "Lisää yhden nopan taisteluvaiheeseen";
        hinta = 123;
    }

    @Override
    public int suorita(String tyyppi) {
        return 1;
    }

    @Override
    public int getHinta() {
        return hinta;
    }

    @Override
    public String getKuvaus() {
        return kuvaus;
    }

    @Override
    public String getNimi() {
        return nimi;
    }

    @Override
    public String getTyyppi() {
        return tyyppi;
    }

    @Override
    public void tiedotaViholliset(int luuranko, int orkki, int lohikaarme) {
    }


}
