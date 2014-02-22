
package lautapeli.lautapeli.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lautapeli.lautapeli.domain.Heittely;


public class RerollKuuntelija implements ActionListener{
    private Heittely heittely;

    public RerollKuuntelija(Heittely heittely) {
        this.heittely = heittely;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        heittely.reroll();
    }

}
