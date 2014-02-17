
package lautapeli.lautapeli.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


class HeittelyFrame {
    private JInternalFrame raami;

    public HeittelyFrame(JInternalFrame raami) {
        this.raami = raami;
    }
    
    private JPanel noppapanel;
    private JPanel nappipanel;

    void luoKomponentit() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        Container pane = new JPanel(gbl);
        raami.setContentPane(pane);
        
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridy = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.weightx = 0.8;
        
        noppapanel = new JPanel();
        pane.add(noppapanel, c);
        
        c.gridx = 1;
        c.weightx = 0.3;
        
        nappipanel = new JPanel();
        pane.add(nappipanel, c);
        
        noppapanel.setBorder(new BevelBorder(0));
        nappipanel.setBorder(new BevelBorder(0));
        
        luoNoppaKomponentit();
        luoNappiKomponentit();
    }

    private void luoNoppaKomponentit() {
        
    }

    private void luoNappiKomponentit() {
        
    }
    
    

}
