
package lautapeli.lautapeli.domain.kortti;

/**
 * Kortti on pelimekaanisesti tärkeä komponentti, joka vaikuttaa pelaajan kykyyn onnistua heittelyissä ja saada enemmän pisteitä ja loottia.
 */
public interface Kortti{

    /**
     * Metodi palauttaa kortin tekemän muutoksen noppiin tyypin perusteella.
     * 
     * @param tyyppi
     * @return muutos
     */
    public int suorita(String tyyppi);
    
    /**
     * Metodi tiedottaa, mitä vihollisia on tullut vastaan vihollisnopista,
     * jotta spesifiset kortit voivat suorittaa erikoistuneen toimintansa.
     * @param luuranko
     * @param orkki
     * @param lohikaarme 
     */
    public void tiedotaViholliset(int luuranko, int orkki, int lohikaarme);
    
    public String getNimi();
    public String getKuvaus();
    public String getTyyppi();
    public int getHinta();

}