
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import lautapeli.lautapeli.domain.Pelaaja;


public class PelaajaPanel {
    private String nimi;
    private JPanel panel;
    private Pelaaja pelaaja;

    PelaajaPanel(String nimi, JPanel panel) {
        this.nimi = nimi;
        this.panel = panel;
        this.panel.setBorder(new LineBorder(Color.RED, 2));
//        this.pelaaja = 
    }
    
    void luoKomponentit() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gbl);
        c.ipadx = 0;
        c.ipady = 0;
        
        JTextField nimikentta = new JTextField(nimi);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridwidth = 2;
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(nimikentta, c);
        
        JLabel pisteet = new JLabel("Pisteet:");
        pisteet.setHorizontalAlignment(JLabel.CENTER);
        c.ipady = 20;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(pisteet, c);
        
        JTextField pistekentta = new JTextField("-1");
        pistekentta.setHorizontalAlignment(JTextField.CENTER);
        pistekentta.setBorder(new LineBorder(Color.green, 2));
        pistekentta.setEditable(false);
        pistekentta.setBackground(Color.white);
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(pistekentta, c);
        
        JLabel rahat = new JLabel("Rahaa:");
        rahat.setHorizontalAlignment(JLabel.CENTER);
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(rahat, c);
        
        JTextField rahakentta = new JTextField("-1");
        rahakentta.setHorizontalAlignment(JTextField.CENTER);
        rahakentta.setBorder(new LineBorder(Color.yellow, 2));
        rahakentta.setEditable(false);
        rahakentta.setBackground(Color.white);
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 1;
        c.gridy = 2;
        panel.add(rahakentta, c);
        
        JButton korttinappi = new JButton("  Kortit  ");
        c.ipadx = 10;
        c.ipady = 10;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridwidth = 2;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(korttinappi, c);
    }

}
