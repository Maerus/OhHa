
package lautapeli.lautapeli.domain.kortti;


public interface Kortti{
//    private final String nimi;
//    private final String tyyppi;
//    private final int hinta;
//    private final String kuvaus;

    /**
     * Metodi palauttaa kortin tekemän muutoksen noppiin tyypin perusteella.
     * 
     * @param tyyppi
     * @return muutos
     */
    public int suorita(String tyyppi);
    public void tiedotaViholliset(int luuranko, int orkki, int lohikaarme);
    public String getNimi();
    public String getKuvaus();
    public String getTyyppi();
    public int getHinta();

}