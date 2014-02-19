
package lautapeli.lautapeli.domain;


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
        this.vihollisnopat = 3;
        this.taistelunopat = 4;
        this.aarrenopat = 5;
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
