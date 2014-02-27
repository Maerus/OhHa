
package lautapeli.lautapeli.gui;

import javax.swing.JButton;


public class KorttiFrameButton extends JButton{
    private int pelaajaIndeksi;

    public KorttiFrameButton(int pelaaja, String nimi) {
        super(nimi);
        pelaajaIndeksi = pelaaja;
    }

    public int getPelaajaIndeksi() {
        return pelaajaIndeksi;
    }
    
    
    
}
