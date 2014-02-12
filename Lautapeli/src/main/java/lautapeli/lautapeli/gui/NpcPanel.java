
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import lautapeli.lautapeli.domain.Pelaaja;


public class NpcPanel {
    private String nimi;
    private JPanel panel;
    private Pelaaja pelaaja;

    NpcPanel(String nimi, JPanel panel) {
        this.nimi = nimi;
        this.panel = panel;
        this.panel.setBorder(new LineBorder(Color.DARK_GRAY, 2));
//        this.pelaaja = 
    }
    
    void luoKomponentit() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gbl);
        
        c.ipadx = 0;
        c.ipady = 0;
        JTextField nimikentta = new JTextField(nimi);
        nimikentta.setEditable(false);
        nimikentta.setBackground(Color.white);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridwidth = 2;
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(nimikentta, c);
        
        JTextField pistekentta = new JTextField("-1");
        pistekentta.setHorizontalAlignment(JTextField.CENTER);
        pistekentta.setBorder(new LineBorder(Color.green, 2));
        pistekentta.setEditable(false);
        pistekentta.setBackground(Color.white);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.ipadx = 25;
        c.ipady = 15;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(pistekentta, c);
        
        JTextField rahakentta = new JTextField("-1");
        rahakentta.setHorizontalAlignment(JTextField.CENTER);
        rahakentta.setBorder(new LineBorder(Color.yellow, 2));
        rahakentta.setEditable(false);
        rahakentta.setBackground(Color.white);
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(rahakentta, c);
        
        JButton korttinappi = new JButton("Kortit");
        c.ipadx = 10;
        c.ipady = 0;
        c.gridwidth = 2;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(korttinappi, c);
    }
}
