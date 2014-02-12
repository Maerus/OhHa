
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import lautapeli.lautapeli.domain.Luolasto;


public class LuolastoPanel {
    private JPanel panel;
    private Luolasto luolasto;

    public LuolastoPanel(JPanel panel) {
        this.panel = panel;
//        this.luolasto =
        
        this.panel.setBorder(new LineBorder(new Color(40,100,40), 2));
    }
    
    void luoKomponentit (){
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gbl);
        
        JTextField nimikentta = new JTextField("luolaston nimi asddsasdasddssad");
        nimikentta.setHorizontalAlignment(JTextField.CENTER);
        nimikentta.setEditable(false);
        nimikentta.setBackground(Color.white);
        JLabel vNopatTeksti = new JLabel("Viholliset");
        JLabel tNopatTeksti = new JLabel("Voittopotentiaali");
        JLabel aNopatTeksti = new JLabel("Aarteet");
        JButton Nappi = new JButton("Valitse");
        
        
        
        JTextField vNopat = new JTextField("-1");
        vNopat.setHorizontalAlignment(JTextField.CENTER);
        vNopat.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        vNopat.setEditable(false);
        vNopat.setBackground(Color.white);
        
        JTextField tNopat = new JTextField("-1");
        tNopat.setHorizontalAlignment(JTextField.CENTER);
        tNopat.setBorder(new LineBorder(Color.RED, 2));
        tNopat.setEditable(false);
        tNopat.setBackground(Color.white);
        
        JTextField aNopat = new JTextField("-1");
        aNopat.setHorizontalAlignment(JTextField.CENTER);
        aNopat.setBorder(new LineBorder(Color.CYAN, 2));
        aNopat.setEditable(false);
        aNopat.setBackground(Color.white);
        
        c.ipadx = 0;
        c.ipady = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        
        nimikentta.setPreferredSize(new Dimension(500, 25));
        panel.add(nimikentta,c);
        
        c.gridwidth = 1;
        c.gridy = 1;
        
        c.anchor = GridBagConstraints.SOUTHEAST;
        panel.add(vNopatTeksti, c);
        c.anchor = GridBagConstraints.SOUTH;
        c.gridx = 1;
        panel.add(tNopatTeksti, c);
        c.anchor = GridBagConstraints.SOUTHWEST;
        c.gridx = 2;
        panel.add(aNopatTeksti, c);
        
        c.gridx = 0;
        
        c.ipady = 10;
        c.ipadx = 30;
        c.gridy = 2;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.NORTHEAST;
        panel.add(vNopat, c);
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        panel.add(tNopat, c);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 2;
        panel.add(aNopat, c);
        
        c.ipady = 0;
        c.ipadx = 0;
        c.weightx = 0.3;
        c.gridx = 3;
        c.gridy = 1;
        c.gridheight = 3;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.ipadx = 30;
        panel.add(Nappi, c);
    }
    
}
