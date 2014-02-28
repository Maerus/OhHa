
package lautapeli.lautapeli.domain;

/**
 * Luolasto on pelimekaanisesti tärkeä komponentti, johon kuuluu eri määriä noppia eri heittelyvaiheisiin.
 */
public class Luolasto {
    private int vihollisnopat;
    private int taistelunopat;
    private int aarrenopat;
    private String nimi;

    public Luolasto(int vihollisnopat, int taistelunopat, int aarrenopat, String nimi) {
        this.vihollisnopat = vihollisnopat;
        this.taistelunopat = taistelunopat;
        this.aarrenopat = aarrenopat;
        this.nimi = nimi;
    }

    public Luolasto() {
        this.vihollisnopat = 10;
        this.taistelunopat = 10;
        this.aarrenopat = 10;
        this.nimi = "testiluolasto";
    }

    public int getAarrenopat() {
        return aarrenopat;
    }

    public int getTaistelunopat() {
        return taistelunopat;
    }

    public int getVihollisnopat() {
        return vihollisnopat;
    }

    public String getNimi() {
        return nimi;
    }
    
    
    
}
