
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import lautapeli.lautapeli.util.NimiGen;


public class Kayttoliittyma implements Runnable {
    
    private JFrame raami;
    private NimiGen nimigen;

    public Kayttoliittyma() {
        nimigen = new NimiGen();
    }
    

    @Override
    public void run() {
        raami = new JFrame("Lautapeli"); // vaihda nimi...
        raami.setResizable(false);
        raami.setPreferredSize(new Dimension(800, 600));
        
        raami.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(raami.getContentPane());
        
        raami.pack();
        raami.setVisible(true);
    }

    private void luoKomponentit(Container pane) {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        pane.setLayout(gbl);
        
        JPanel peliPanel = new JPanel();
        JPanel pelaajatPanel = new JPanel();
        
        c.fill = GridBagConstraints.BOTH;
        
        c.weighty = 0.5;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(peliPanel,c);
        peliPanel.setBorder(new LineBorder(Color.GRAY, 1));
        
        
        c.weightx = 0.2;
        c.gridx = 1;
        pane.add(pelaajatPanel,c);
        pelaajatPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        
        luoPelaajaKomponentit(pelaajatPanel, gbl, c);
    }

    private void luoPelaajaKomponentit(JPanel panel, GridBagLayout gbl, GridBagConstraints c) {
        panel.setLayout(gbl);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        
        JPanel pelaajaPanel = new JPanel();
        JPanel npc1Panel = new JPanel();
        JPanel npc2Panel = new JPanel();
        JPanel npc3Panel = new JPanel();
        
        pelaajaPanel.setBorder(new LineBorder(Color.red, 2));
        npc1Panel.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        npc2Panel.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        npc3Panel.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        
        panel.add(pelaajaPanel,c);
        
        c.weighty = 0.5;
        c.gridy = 1;
        panel.add(npc1Panel,c);
        
        c.gridy = 2;
        panel.add(npc2Panel,c);
        
        c.gridy = 3;
        panel.add(npc3Panel,c);
        
        pelaajaKomponentit(pelaajaPanel, gbl, c);
        npc1Komponentit(npc1Panel, gbl, c);
        npc2Komponentit(npc2Panel, gbl, c);
        npc3Komponentit(npc3Panel, gbl, c);
        // kysy peliluokan kautta pelaajien tiedot komponentteihin
    }

    private void pelaajaKomponentit(JPanel panel, GridBagLayout gbl, GridBagConstraints c) {
        panel.setLayout(gbl);
        c.ipadx = 0;
        c.ipady = 0;
        
        JTextField nimikentta = new JTextField(nimigen.haeNimi());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridwidth = 2;
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(nimikentta, c);
        
        JLabel pisteet = new JLabel("Pisteet:");
        c.ipady = 20;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(pisteet, c);
        
        JTextField pistekentta = new JTextField("     0");
        pistekentta.setBorder(new LineBorder(Color.green, 2));
        pistekentta.setEditable(false);
        pistekentta.setBackground(Color.white);
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(pistekentta, c);
        
        JLabel rahat = new JLabel("Rahaa:");
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(rahat, c);
        
        JTextField rahakentta = new JTextField("     0");
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

    private void npc1Komponentit(JPanel panel, GridBagLayout gbl, GridBagConstraints c) {
        //pls no copy pasterino
        panel.setLayout(gbl);
        
        c.ipadx = 0;
        c.ipady = 0;
        JTextField nimikentta = new JTextField(nimigen.haeNimi());
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
        
        JTextField pistekentta = new JTextField("     0");
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
        
        JTextField rahakentta = new JTextField("     0");
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

    private void npc2Komponentit(JPanel panel, GridBagLayout gbl, GridBagConstraints c) {
        panel.setLayout(gbl);
        
        c.ipadx = 0;
        c.ipady = 0;
        JTextField nimikentta = new JTextField(nimigen.haeNimi());
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
        
        JTextField pistekentta = new JTextField("     0");
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
        
        JTextField rahakentta = new JTextField("     0");
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

    private void npc3Komponentit(JPanel panel, GridBagLayout gbl, GridBagConstraints c) {
        panel.setLayout(gbl);
        
        c.ipadx = 0;
        c.ipady = 0;
        JTextField nimikentta = new JTextField(nimigen.haeNimi());
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
        
        JTextField pistekentta = new JTextField("     0");
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
        
        JTextField rahakentta = new JTextField("     0");
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
