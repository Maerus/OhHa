
package lautapeli.lautapeli.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lautapeli.lautapeli.domain.Heittely;


public class RerollKuuntelija implements ActionListener{
    private Heittely heittely;
    private Boolean[] nappitaulukko;

    public RerollKuuntelija(Heittely heittely, Boolean[] nappitaulukko) {
        this.heittely = heittely;
        this.nappitaulukko = nappitaulukko;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean a = false;
        for (Boolean nappi : nappitaulukko) {
            if (nappi == true){
                a = true;
            }
        }
        
        if (a){
            heittely.reroll();
        }
    }

}
