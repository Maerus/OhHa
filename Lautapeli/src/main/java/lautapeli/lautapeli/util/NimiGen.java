
package lautapeli.lautapeli.util;

import java.util.ArrayList;
import java.util.Random;


public class NimiGen {
    private ArrayList<String> lista;
    private Random r;

    public NimiGen() {
        lista = new ArrayList<>();
        r = new Random();
        
        lista.add("Jaakob");
        lista.add("Matterson");
        lista.add("Felei");
        lista.add("Mikaela");
        lista.add("Lotus");
        lista.add("Harrison");
        lista.add("Godor");
        lista.add("Takae");
        //lisää
    }
    
    /**
     * Metodi palauttaa nimen listasta ja poistaa sen.
     * 
     * @return nimi
     */
    public String haeNimi(){
        int i = r.nextInt(lista.size());
        String nimi = lista.get(i);
        lista.remove(i);
        return nimi;
    }

    public ArrayList<String> getLista() {
        return lista;
    }
    
    
}
