
package lautapeli.lautapeli.domain.kortti;


public interface Kortti{
//    private final String nimi;
//    private final String tyyppi;
//    private final int hinta;
//    private final String kuvaus;

    /**
     * Metodi palauttaa kortin tekemän muutoksen noppiin
     * @return muutos
     */
    public int suorita();
    
    public String getNimi();
    public String getKuvaus();
    public String getTyyppi();
    public int getHinta();

}