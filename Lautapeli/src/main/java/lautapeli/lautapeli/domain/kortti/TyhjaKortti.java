
package lautapeli.lautapeli.domain.kortti;


public class TyhjaKortti implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;

    public TyhjaKortti() {
        nimi = "Tyhjä Kortti";
        tyyppi = "";
        kuvaus = "Korttipakka on tyhjä\n"
                + "Tämä kortti ei tee mitään";
        hinta = 999999;
    }
    
    @Override
    public int suorita(String tyyppi) {
        return 0;
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
