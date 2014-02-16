
package lautapeli.lautapeli.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lautapeli.lautapeli.domain.Luolasto;
import lautapeli.lautapeli.domain.Pelaaja;
import lautapeli.lautapeli.domain.Valinta;


public class LuolaNappikuuntelija implements ActionListener{
    private Pelaaja pelaaja;
    private Luolasto luolasto;

    public LuolaNappikuuntelija(Pelaaja pelaaja, Luolasto luolasto) {
        this.pelaaja = pelaaja;
        this.luolasto = luolasto;
    }

    @Override
    public synchronized void actionPerformed(ActionEvent ae) {
        pelaaja.setValinta(Valinta.LUOLASTO);
        pelaaja.setValittuLuolasto(luolasto);
        pelaaja.notifioiLukko();
    }

}
