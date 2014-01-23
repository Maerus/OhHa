
package lautapeli.lautapeli.domain;


public class Luolasto {
    private int vihollisnopat;
    private int taistelunopat;
    private int aarrenopat;

    public Luolasto(int vihollisnopat, int taistelunopat, int aarrenopat) {
        this.vihollisnopat = vihollisnopat;
        this.taistelunopat = taistelunopat;
        this.aarrenopat = aarrenopat;
    }

    public Luolasto() {
        this.vihollisnopat = 3;
        this.taistelunopat = 3;
        this.aarrenopat = 3;
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
    
    
    
}
