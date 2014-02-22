
package lautapeli.lautapeli.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import lautapeli.lautapeli.domain.Heittely;


public class HeittelynValmiusKuuntelija implements ActionListener{
    private Heittely heittely;
    private JInternalFrame raami;

    public HeittelynValmiusKuuntelija(Heittely heittely, JInternalFrame raami) {
        this.heittely = heittely;
        this.raami = raami;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(heittely.getVaihe().equals("Aarrenopat")){
            raami.dispose();
        }
        heittely.notifioiLukko();
    }

}
