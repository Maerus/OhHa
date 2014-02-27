
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import lautapeli.lautapeli.domain.Pelaaja;
import lautapeli.lautapeli.util.KorttiNappiKuuntelija;


public class PelaajaPanel {
    private String nimi;
    private JPanel panel;
    private Pelaaja pelaaja;
    private int i;
    private Kayttoliittyma ui;

    PelaajaPanel(String nimi, JPanel panel, Pelaaja pelaaja, int i, Kayttoliittyma ui) {
        this.nimi = nimi;
        this.panel = panel;
        this.panel.setBorder(new LineBorder(Color.RED, 2));
        this.pelaaja = pelaaja;
        this.ui = ui;
        this.i = i;
    }
    
     private JTextField pistekentta;
     private JTextField rahakentta;
     private KorttiFrameButton korttinappi;
     private JTextField nimikentta;
    
    void luoKomponentit() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gbl);
        c.ipadx = 0;
        c.ipady = 0;
        
        nimikentta = new JTextField(nimi);
        nimikentta.setHorizontalAlignment(JTextField.CENTER);
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
        
        pistekentta = new JTextField("" + pelaaja.getPisteet());
        pistekentta.setColumns(1);
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
        
        rahakentta = new JTextField("" + pelaaja.getRaha());
        rahakentta.setColumns(1);
        rahakentta.setHorizontalAlignment(JTextField.CENTER);
        rahakentta.setBorder(new LineBorder(Color.yellow, 2));
        rahakentta.setEditable(false);
        rahakentta.setBackground(Color.white);
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 1;
        c.gridy = 2;
        panel.add(rahakentta, c);
        
        korttinappi = new KorttiFrameButton(i, "  Kortit  ");
        korttinappi.addActionListener(new KorttiNappiKuuntelija(korttinappi, ui.getPeli()));
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
    
    public void paivitaKomponentit(){
        pistekentta.setText("" + pelaaja.getPisteet());
        rahakentta.setText("" + pelaaja.getRaha());
    }

}
