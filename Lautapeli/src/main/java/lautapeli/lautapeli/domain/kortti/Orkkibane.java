
package lautapeli.lautapeli.domain.kortti;


public class Orkkibane implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;
    private boolean orkki;

    public Orkkibane() {
        nimi = "Örkkibane";
        tyyppi = "t";
        kuvaus = "Myyttinen kirves.\n"
                + "Jos taistelussa on 2+ örkkinoppaa,\n"
                + "lisää yksi taistelunoppa";
        hinta = 123;
        orkki = false;
    }
    
    @Override
    public int suorita(String tyyppi) {
        if(orkki){
            orkki = false;
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
        if (orkki > 0){
            this.orkki = true;
        }
    }
}
