
package lautapeli.lautapeli.domain.kortti;


public abstract class Kortti{
    private String nimi;
    private String tyyppi;

    public Kortti(String nimi, String tyyppi) {
        this.nimi = nimi;
        this.tyyppi = tyyppi;
    }
    
    public abstract String getNimi();

    /**
     * Metodi palauttaa kortin tekemän muutoksen noppiin
     * @return muutos
     */
    public abstract int suorita();
    public abstract String getTyyppi();

}