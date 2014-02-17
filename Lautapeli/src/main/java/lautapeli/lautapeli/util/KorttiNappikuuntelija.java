
package lautapeli.lautapeli.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lautapeli.lautapeli.domain.Pelaaja;
import lautapeli.lautapeli.domain.Valinta;
import lautapeli.lautapeli.domain.kortti.Kortti;


public class KorttiNappikuuntelija implements ActionListener{
    private Pelaaja pelaaja;
    private Kortti kortti;

    public KorttiNappikuuntelija(Pelaaja pelaaja, Kortti kortti) {
        this.pelaaja = pelaaja;
        this.kortti = kortti;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        disabloiPerusIkkuna();
        pelaaja.setValinta(Valinta.KORTTI);
        pelaaja.setValittuKortti(kortti);
        pelaaja.notifioiLukko();
    }

    private void disabloiPerusIkkuna() {
        //placeholder
    }

}
