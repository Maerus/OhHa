
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import lautapeli.lautapeli.logiikka.Peli;
import lautapeli.lautapeli.util.NimiGen;


public class Kayttoliittyma implements Runnable {
    
    private JFrame raami;
    private NimiGen nimigen;
    private Peli peli;

    public Kayttoliittyma() {
        nimigen = new NimiGen();
    }
    

    @Override
    public void run() {
        raami = new JFrame("Lautapeli"); // vaihda nimi...
        raami.setResizable(false);
        raami.setPreferredSize(new Dimension(800, 600));
        
        raami.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        peli = new Peli(this);
        peli.alusta();
        luoKomponentit(raami.getContentPane());
        
        raami.pack();
        raami.setVisible(true);
        peli.pelaa();
    }

    /**
     * Metodi luo ikkunan peruskomponentit.
     * 
     * @param pane 
     */
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
        
        c.weightx = 0.4;
        c.ipadx = 50;
        c.gridx = 1;
        pane.add(pelaajatPanel,c);
        pelaajatPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        
        luoPeliKomponentit(peliPanel);
        luoPelaajaKomponentit(pelaajatPanel);
    }
    


    /**
     * Metodi luo vasemmalle sijoittuvat luolasto- ja kauppakomponentit.
     * 
     * @param panel 
     */
    private void luoPeliKomponentit(JPanel panel) {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gbl);
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.5;
        c.weighty = 0.3;
        c.gridx = 0;
        c.gridy = 0;
        JPanel luola1 = new JPanel();
        JPanel luola2 = new JPanel();
        JPanel luola3 = new JPanel();
        JPanel kauppa = new JPanel();
        
        panel.add(luola1, c);
        
        c.gridy = 1;
        panel.add(luola2, c);
        
        c.gridy = 2;
        panel.add(luola3, c);
        
        c.gridy = 3;
        c.weighty = 0.7;
        panel.add(kauppa, c);
        
        LuolastoPanel luolasto1 = new LuolastoPanel(this, luola1, peli.getLuolastot().get(0));
        luolasto1.luoKomponentit();
        
        LuolastoPanel luolasto2 = new LuolastoPanel(this, luola2, peli.getLuolastot().get(1));
        luolasto2.luoKomponentit();
        
        LuolastoPanel luolasto3 = new LuolastoPanel(this, luola3, peli.getLuolastot().get(2));
        luolasto3.luoKomponentit();
        
        KauppaPanel kauppaPanel = new KauppaPanel(kauppa, this);
        kauppaPanel.luoKomponentit();
    }
    
//    public void luoLopetusruutu(){
//        
//    }

    
    
    public JLabel kierros;
    private PelaajaPanel ppanel;
    private NpcPanel n1panel;
    private NpcPanel n2panel;
    private NpcPanel n3panel;
    
    /**
     * Metodi luo oikealle sijoittuvat pelaajakomponentit.
     * 
     * @param panel 
     */
    private void luoPelaajaKomponentit(JPanel panel) {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gbl);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        
        kierros = new JLabel("Kierros:  " + peli.getKierros());
        kierros.setHorizontalAlignment(JLabel.CENTER);
        kierros.setBorder(new BevelBorder(0));
        
        panel.add(kierros,c);
        
        JPanel pelaajaPanel = new JPanel();
        JPanel npc1Panel = new JPanel();
        JPanel npc2Panel = new JPanel();
        JPanel npc3Panel = new JPanel();
        
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 0.5;
        c.gridy = 1;
        panel.add(pelaajaPanel,c);
        
        c.gridy = 2;
        panel.add(npc1Panel,c);
        
        c.gridy = 3;
        panel.add(npc2Panel,c);
        
        c.gridy = 4;
        panel.add(npc3Panel,c);
        
        ppanel = new PelaajaPanel(nimigen.haeNimi(), pelaajaPanel, peli.getPelaajat().get(0));
        ppanel.luoKomponentit();
        
        n1panel = new NpcPanel(nimigen.haeNimi(), npc1Panel, peli.getPelaajat().get(1));
        n1panel.luoKomponentit();
        
        n2panel = new NpcPanel(nimigen.haeNimi(), npc2Panel, peli.getPelaajat().get(2));
        n2panel.luoKomponentit();
        
        n3panel = new NpcPanel(nimigen.haeNimi(), npc3Panel, peli.getPelaajat().get(3));
        n3panel.luoKomponentit();
    }
    
    
    
    public PelaajaPanel getPpanel() {
        return ppanel;
    }

    public NpcPanel getN1panel() {
        return n1panel;
    }

    public NpcPanel getN2panel() {
        return n2panel;
    }

    public NpcPanel getN3panel() {
        return n3panel;
    }

    public Peli getPeli() {
        return peli;
    }
    
}
