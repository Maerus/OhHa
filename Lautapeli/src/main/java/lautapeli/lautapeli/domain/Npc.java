
package lautapeli.lautapeli.domain;

import java.util.Random;
import lautapeli.lautapeli.domain.kortti.Kortti;
import lautapeli.lautapeli.logiikka.Peli;

/**
 * Tietokonepelaajan luokka, joka perii Pelaajaluokan ja vaihtaa pelaajan toiminnallisuudet satunnaisuudella.
 */
public class Npc extends Pelaaja{
    private Random r;

    public Npc(Peli peli) {
        super(peli);
        r = new Random();
    }
    
    
    /**
     * Metodi arpoo mitä tietokonepelaaja tekee vuorollaan.
     */
    @Override
    public void valitseVuoroToimepide(){
        if (r.nextInt(2) == 0){
            valinta = Valinta.LUOLASTO;
            int r3 = r.nextInt(3);
            super.setValittuLuolasto(super.peli.getLuolastot().get(r3));
        } else {
            valinta = Valinta.KORTTI;
            int r3 = r.nextInt(3)+1;
            setValittuKorttiruutu(r3);
            //ikävästi ui sidonnainen, ei voi oikein testata
            try{
                if(r3 == 1){
                setValittuKortti(peli.getUi().getKauppaPanel().getK1panel().getKortti());
            } else if (r3 == 2){
                setValittuKortti(peli.getUi().getKauppaPanel().getK2panel().getKortti());
            } else if (r3 == 3){
                setValittuKortti(peli.getUi().getKauppaPanel().getK3panel().getKortti());
            }
            } catch (Exception e){}
            
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
    
    
    @Override
    int getTaistelukorttimuutokset() {
        //helpotetaan tietokonepelaajan elämää, kun se ei osaa rerollata
        int a = 1;
        for (Kortti kortti : kortit) {
            if(kortti.getTyyppi().contains("t")){
                a += kortti.suorita("t");
            }
        }
        return a;
    }
}
