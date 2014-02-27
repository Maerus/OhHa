
package lautapeli.lautapeli.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lautapeli.lautapeli.domain.Pelaaja;
import lautapeli.lautapeli.domain.Valinta;
import lautapeli.lautapeli.domain.kortti.Kortti;


public class KaupanKorttiNappikuuntelija implements ActionListener{
    private Pelaaja pelaaja;
    private Kortti kortti;
    private int i;

    public KaupanKorttiNappikuuntelija(Pelaaja pelaaja, Kortti kortti, int i) {
        this.pelaaja = pelaaja;
        this.kortti = kortti;
        this.i = i;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        pelaaja.setValinta(Valinta.KORTTI);
        pelaaja.setValittuKorttiruutu(i);
        pelaaja.setValittuKortti(kortti);
        pelaaja.notifioiLukko();
    }

}
