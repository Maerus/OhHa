
package lautapeli.lautapeli.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lautapeli.lautapeli.gui.KorttiFrameButton;
import lautapeli.lautapeli.logiikka.Peli;


public class KorttiNappiKuuntelija implements ActionListener{
    private int nappiIndeksi;
    private Peli peli;

    public KorttiNappiKuuntelija(KorttiFrameButton nappi, Peli peli) {
        this.nappiIndeksi = nappi.getPelaajaIndeksi();
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.getUi().luoKorttiraami(peli.getPelaajat().get(nappiIndeksi));
    }
}
