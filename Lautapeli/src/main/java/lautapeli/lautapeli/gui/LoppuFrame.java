
package lautapeli.lautapeli.gui;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;


public class LoppuFrame {
    private JInternalFrame raami;

    public LoppuFrame(JInternalFrame raami) {
        this.raami = raami;
        raami.setBounds(150, 150, 300, 100);
        raami.setVisible(true);
        raami.setResizable(false);
    }
    
    public void luoKomponentit(){
        
        JLabel teksti = new JLabel("Peli päättyi.");
        teksti.setHorizontalAlignment(JLabel.CENTER);
        raami.add(teksti);
    }
    
}
