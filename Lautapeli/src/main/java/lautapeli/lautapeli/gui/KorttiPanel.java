
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import lautapeli.lautapeli.domain.kortti.Kortti;


public class KorttiPanel {
    private JPanel panel;
    private Kortti kortti;

    public KorttiPanel(JPanel panel) {
        this.panel = panel;
//        this.kortti =
        
        this.panel.setBorder(new LineBorder(Color.orange, 2));
    }
    
    void luoKomponentit(){
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gbl);
        
        c.ipadx = 0;
        c.ipady = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        
        JLabel nimi = new JLabel("kortin nimi");
        nimi.setHorizontalAlignment(JLabel.CENTER);
        
        JTextField hinta = new JTextField("-1");
        hinta.setEditable(false);
        hinta.setBackground(Color.white);
        hinta.setBorder(new LineBorder(Color.yellow));
        hinta.setHorizontalAlignment(JTextField.CENTER);
        
        JTextArea kuvaus = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(kuvaus);
        kuvaus.setLineWrap(true);
        kuvaus.setEditable(false);
        JButton nappi = new JButton("Osta");
        
        panel.add(nimi, c);
        
        c.weightx = 0.2;
        c.gridx = 1;
        panel.add(hinta, c);
        
        c.weighty = 0.5;
        c.weightx = 0.5;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(scrollPane, c);
        
        c.weighty = 0.1;
        c.fill = GridBagConstraints.NONE;
        c.gridy = 2;
        panel.add(nappi, c);
        
    }

}