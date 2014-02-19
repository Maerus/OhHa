
package lautapeli.lautapeli.domain.kortti;


public class TestiKortti implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;

    public TestiKortti() {
        nimi = "testikortti";
        tyyppi = "vta";
        kuvaus = "Pelaajan omistamat kortit vaikuttavat noppien määriin heittelyssä\nluolaston lisäksi";
        hinta = 123;
    }
    
    
    @Override
    public int suorita(String tyyppi) {
        if (tyyppi.equals("v")){
            return 1;
        }
        
        if (tyyppi.equals("t")){
            return 2;
        }
        
        if (tyyppi.equals("a")){
            return 3;
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

}
