package lautapeli.lautapeli;

import javax.swing.SwingUtilities;
import lautapeli.lautapeli.gui.Kayttoliittyma;
import lautapeli.lautapeli.logiikka.Peli;


public class LautaMain 
{
    public static void main( String[] args ) {
        SwingUtilities.invokeLater(new Kayttoliittyma());
    }
}
