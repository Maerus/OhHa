
package lautapeli.lautapeli.domain;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import lautapeli.lautapeli.domain.kortti.Kortti;
import lautapeli.lautapeli.logiikka.Peli;


public class Npc extends Pelaaja{
    private Random r;
    private Peli peli;

    public Npc(Peli peli) {
        super(peli);
        r = new Random();
    }
    
    private Valinta valinta;
    private Kortti valittuKortti;
    private Luolasto valittuLuolasto;
    
    /**
     * Metodi arpoo mitä tietokonepelaaja tekee vuorollaan.
     * 
     */
    @Override
    public void valitseVuoroToimepide(){
        if (r.nextInt(2) == 0){
            valinta = Valinta.LUOLASTO;
            int r3 = r.nextInt(3);
            setValittuLuolasto(peli.getLuolastot().get(r3));
            //MIKSEI TOIMI ARGH
        } else {
            valinta = Valinta.KORTTI;
            int r3 = r.nextInt(3)+1;
            setValittuKorttiruutu(r3);
            if(r3 == 1){
                setValittuKortti(peli.getUi().getKauppaPanel().getK1panel().getKortti());
                //GRRRR 
            } else if (r3 == 2){
                setValittuKortti(peli.getUi().getKauppaPanel().getK2panel().getKortti());
                //GRRRR
            } else if (r3 == 3){
                setValittuKortti(peli.getUi().getKauppaPanel().getK3panel().getKortti());
                //GRRRR
            }
            
        }
        
        
        if (valinta == Valinta.LUOLASTO){
            Heittely heittely = new Heittely(valittuLuolasto, this, peli);
            heittely.suoritaHeittely();
        } else if (valinta == Valinta.KORTTI) {
            if(!osta(valittuKortti)){
                valitseVuoroToimepide();
            }
        }
    }
    
}
