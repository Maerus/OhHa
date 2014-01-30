
package lautapeli.lautapeli.domain.kortti;


public abstract class Kortti{
    private String nimi;
    private String tyyppi;

    public Kortti(String nimi, String tyyppi) {
        this.nimi = nimi;
        this.tyyppi = tyyppi;
    }
    
    public abstract String getNimi();
    public abstract int suorita();
    public abstract String getTyyppi();

}