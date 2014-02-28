
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;

/**
 * Luokka on pino luolastokortteja, joista otetaan arvalla kolme kappaletta peliin.
 */
public class Luolastopakka {
    private ArrayList<Luolasto> pakka;
    private Random random;

    public Luolastopakka() {
        random = new Random();
        pakka = new ArrayList<>();
        lisaaLuolastot();
    }
    
    /**
     * Metodi lisää luolastot pakkaan, sekä arpoo mystisen luolaston arvot.
     */
    private void lisaaLuolastot() {
        int a = random.nextInt(5) + 4; //mystisen luolan arvojen arpominen
        int b = random.nextInt(5) + 2;
        
        pakka.add(new Luolasto(9, 3, 8, "Mahtivuoret"));
        pakka.add(new Luolasto(6, 4, 4, "Jäätynyt Tyrmä"));
        pakka.add(new Luolasto(5, 2, 6, "Umpiräme"));
        pakka.add(new Luolasto(a, b, a-2, "Mystinen Luola"));
        pakka.add(new Luolasto(8, 6, 5, "Örkkikylä"));
    }
    
    /**
     * Metodi valitsee arvalla yhden luolaston ja antaa sen peliluokalle, sekä poistaa sen pakasta.
     * @return luolasto
     */
    public Luolasto otaLuolasto(){
        int i = random.nextInt(pakka.size());
        Luolasto l = pakka.get(i);
        pakka.remove(i);
        return l;
    }

    public ArrayList<Luolasto> getPakka() {
        return pakka;
    }
    
    
    
}
