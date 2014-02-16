package lautapeli.lautapeli;

import javax.swing.SwingUtilities;
import lautapeli.lautapeli.gui.Kayttoliittyma;


public class LautaMain 
{
    public static void main( String[] args ) {
//        SwingUtilities.invokeLater(new Kayttoliittyma());
        new Kayttoliittyma().run();
    }
}
