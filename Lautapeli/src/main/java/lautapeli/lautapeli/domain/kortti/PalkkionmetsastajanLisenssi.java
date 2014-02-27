
package lautapeli.lautapeli.domain.kortti;


public class PalkkionmetsastajanLisenssi implements Kortti{
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private int hinta;
    private boolean orkki;

    public PalkkionmetsastajanLisenssi() {
        nimi = "Palkkionmetsästäjän Lisenssi";
        tyyppi = "a";
        kuvaus = "Jos taistelussa on 2+ örkkinoppaa,\n"
                + "lisää yksi aarrenoppa";
        hinta = 20;
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
