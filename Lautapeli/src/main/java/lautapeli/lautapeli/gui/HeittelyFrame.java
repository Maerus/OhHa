
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import lautapeli.lautapeli.domain.Heittely;
import lautapeli.lautapeli.util.HeittelynValmiusKuuntelija;
import lautapeli.lautapeli.util.NoppaToggleKuuntelija;
import lautapeli.lautapeli.util.RerollKuuntelija;

/**
 * Luokka luo raamin heittelytilannetta varten.
 */
public class HeittelyFrame {
    private JInternalFrame raami;
    private Heittely heittely;
    private ArrayList<NoppaButton> noppanapit;
    private Boolean[] nappitaulukko;
    
    public HeittelyFrame(JInternalFrame raami, Heittely heittely) {
        this.heittely = heittely;
        this.raami = raami;
    }
    
    private JPanel noppapanel;
    private JPanel nappipanel;
    
    /**
     * Luo komponentit heittelyraamiin.
     */
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
        
        //bugfix purukumia
        //komponentit ei näykynyt jos ei raamia liikuttanut
        raami.setLocation(raami.getLocation());
    }
    
    private NoppaButton kasiteltavaNappi;
    
    /**
     * Metodi luo noppanapit raamiin.
     * Napeille jaetaan indeksi ja nopan luku.
     * Indeksiä käytetään nopan käsittelyyn napin togglessa, rerolleissa.
     */
    private void luoNoppaKomponentit() {
        noppanapit = new ArrayList<>();
        noppapanel = new JPanel();
        noppapanel.setBorder(new BevelBorder(0));
        
        int a;
        if(heittely.getNopat().size() < 16){
            GridLayout gl = new GridLayout(3, 5);
            noppapanel.setLayout(gl);
            a = 15;
        } else {
            GridLayout gl = new GridLayout(4, 7);
            noppapanel.setLayout(gl);
            a = 28;
        }
        
        nappitaulukko = new Boolean[heittely.getNopat().size()];
        for (int i = 0; i < heittely.getNopat().size(); i++) {
            nappitaulukko[i] = false;
        }
        
        for (int i = 0; i < heittely.getNopat().size(); i++) {
            kasiteltavaNappi = new NoppaButton(i, heittely.getNopat().get(i), heittely.getVaihe());
            noppanapit.add(kasiteltavaNappi);
            noppapanel.add(kasiteltavaNappi);
            kasiteltavaNappi.addActionListener(new NoppaToggleKuuntelija(kasiteltavaNappi, nappitaulukko));
        }
        //täyttää gridlayoutin loput osat tyhjällä jottei noppanapit veny
        
        for (int i = 0; i < a - heittely.getNopat().size(); i++) {
            noppapanel.add(new JLabel(""));
        }
    }
    
    public Boolean[] getTaulukko(){
        return nappitaulukko;
    }

    public ArrayList<NoppaButton> getNoppanapit() {
        return noppanapit;
    }
    
    private JTextField vaihe;
    private JTextField rerollit;
    private JButton rerollnappi;
    private JButton valmisnappi;
    
    /**
     * Luo oikealla olevat tiedotustekstiruudut, sekä rerollaus- ja valmiusnapit.
     */
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
        
        rerollnappi.addActionListener(new RerollKuuntelija(heittely, nappitaulukko));
        valmisnappi.addActionListener(new HeittelynValmiusKuuntelija(heittely, raami));
    }
    
    /**
     * Päivittää rerollien määrän, kun rerollaus käytetään.
     */
    public void paivitaNappiKomponentit(){
        rerollit.setText("Rerollit: " + heittely.getRerollit());
    }
    
    /**
     * Tyhjentää raamin, ja luo sen uudestaan uuden vaiheen perusteella, sekä resetoi rerollit kahteen.
     */
    public void paivitaVaihe() {
        heittely.setRerollit(2);
        raami.getContentPane().removeAll();
        luoKomponentit();
    }

}
