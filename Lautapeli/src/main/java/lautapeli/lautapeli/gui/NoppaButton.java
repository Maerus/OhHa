
package lautapeli.lautapeli.gui;

import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;


public class NoppaButton extends JToggleButton{
    private int i;
    private int noppa;

    public NoppaButton(int i, int noppa) {
        this.i = i;
        this.noppa = noppa;
        setBorder(new BevelBorder(0));
        setText("" + noppa);
    }

    public int getI() {
        return i;
    }

    public int getNoppa() {
        return noppa;
    }
    
    
}
