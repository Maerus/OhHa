
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import lautapeli.lautapeli.domain.Heittely;


public class HeittelyFrame {
    private JInternalFrame raami;
    private Heittely heittely;
    private ArrayList<NoppaButton> noppanapit;
    
    public HeittelyFrame(JInternalFrame raami, Heittely heittely) {
        this.heittely = heittely;
        this.raami = raami;
        noppanapit = new ArrayList<>();
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
        c.weightx = 1;
        
        luoNoppaKomponentit();
        luoNappiKomponentit();
        
        
        pane.add(noppapanel, c);
        
        c.gridx = 1;
        c.weightx = 0.1;
        
        pane.add(nappipanel, c);
        
        
    }
    
    private NoppaButton kasiteltavaNappi;
    private Boolean[] nappitaulukko;
    
    /**
     * Metodi luo noppanapit raamiin.
     * Napeille jaetaan indeksi ja nopan luku.
     * Indeksiä käytetään nopan käsittelyyn napin togglessa, rerolleissa.
     */
    private void luoNoppaKomponentit() {
        noppapanel = new JPanel();
        noppapanel.setBorder(new BevelBorder(0));
        
        GridLayout gl = new GridLayout(3, 5);
        noppapanel.setLayout(gl);
        
        for (int i = 0; i < 15; i++) {
            kasiteltavaNappi = new NoppaButton(i, i);
            noppanapit.add(kasiteltavaNappi);
            noppapanel.add(kasiteltavaNappi);
        }
        nappitaulukko = new Boolean[noppanapit.size()];
        for (int i = 0; i < nappitaulukko.length; i++) {
            nappitaulukko[i] = false;
        }
    }
    

    
    private JTextField vaihe;
    private JTextField rerollit;
    private JButton rerollnappi;
    private JButton valmisnappi;
    
    private void luoNappiKomponentit() {
        nappipanel = new JPanel();
        nappipanel.setBorder(new BevelBorder(0));
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.SOUTH;
        c.ipady = 10;
        
        nappipanel.setLayout(gbl);
        vaihe = new JTextField(heittely.getVaihe());
        vaihe.setColumns(10);
        vaihe.setEditable(false);
        vaihe.setBackground(Color.WHITE);
        vaihe.setHorizontalAlignment(JTextField.CENTER);
        nappipanel.add(vaihe,c);
        
        c.anchor = GridBagConstraints.NORTH;
        c.gridy = 1;
        
        rerollit = new JTextField("Rerollit: " + heittely.getRerollit());
        rerollit.setColumns(10);
        rerollit.setEditable(false);
        rerollit.setBackground(Color.WHITE);
        rerollit.setHorizontalAlignment(JTextField.CENTER);
        nappipanel.add(rerollit,c);
        
        c.anchor = GridBagConstraints.SOUTH;
        c.gridy = 2;
        
        rerollnappi = new JButton("Rerollaa");
        nappipanel.add(rerollnappi,c);
        
        c.anchor = GridBagConstraints.NORTH;
        c.gridy = 3;
        
        valmisnappi = new JButton("Valmis");
        nappipanel.add(valmisnappi,c);
    }
    
    public void paivitaNappiKomponentit(){
        rerollit.setText("Rerollit: " + heittely.getRerollit());
        vaihe.setText(heittely.getVaihe());
    }

}
