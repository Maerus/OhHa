
package lautapeli.lautapeli.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lautapeli.lautapeli.gui.NoppaButton;


public class NoppaToggleKuuntelija implements ActionListener{
    private NoppaButton nappi;
    private Boolean[] nappitaulukko; //napit alkaa nollasta

    public NoppaToggleKuuntelija(NoppaButton nappi, Boolean[] nappitaulukko) {
        this.nappi = nappi;
        this.nappitaulukko = nappitaulukko;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if ( nappi.isSelected() ){
            nappitaulukko[nappi.getI()] = true;
            System.out.println(nappi.getI() + " on nyt " + nappitaulukko[nappi.getI()]);
        } else if ( !nappi.isSelected() ){
            nappitaulukko[nappi.getI()] = false;
            System.out.println(nappi.getI() + " on nyt " + nappitaulukko[nappi.getI()]);
        }
    }

}
