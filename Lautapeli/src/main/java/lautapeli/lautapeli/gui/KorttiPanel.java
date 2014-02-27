
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import lautapeli.lautapeli.domain.kortti.Kortti;
import lautapeli.lautapeli.domain.kortti.TestiKortti;
import lautapeli.lautapeli.domain.kortti.TyhjaKortti;
import lautapeli.lautapeli.util.KaupanKorttiNappikuuntelija;


public class KorttiPanel {
    private JPanel panel;
    private Kortti kortti;
    private KauppaPanel kauppapanel;
    private int i;

    public KorttiPanel(JPanel panel, KauppaPanel kauppa, int i) {
        this(panel, new TestiKortti(), kauppa, i);
    }
    
    public KorttiPanel(JPanel panel, Kortti kortti, KauppaPanel kauppa, int i){
        this.panel = panel;
        this.kortti = kortti;
        this.kauppapanel = kauppa;
        this.i = i;
        
        this.panel.setBorder(new LineBorder(Color.orange, 2));
    }

    public int getI() {
        return i;
    }
    
    private JTextField nimi;
    private JTextField hinta;
    private JTextArea kuvaus;
    private JButton nappi;
    private KaupanKorttiNappikuuntelija kuuntelija;
    
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
        
        nimi = new JTextField(kortti.getNimi());
        nimi.setHorizontalAlignment(JTextField.CENTER);
        nimi.setColumns(1);
        nimi.setEditable(false);
        // Scrollpane auttaa pitämään komponentin koon vakiona
        JScrollPane scroll3 = new JScrollPane(nimi);
        
        hinta = new JTextField("" + kortti.getHinta());
        hinta.setColumns(1);
        // Scrollpane auttaa pitämään komponentin koon vakiona
        JScrollPane scroll2 = new JScrollPane(hinta);
        hinta.setEditable(false);
        hinta.setBackground(Color.white);
        hinta.setBorder(new LineBorder(Color.yellow));
        hinta.setHorizontalAlignment(JTextField.CENTER);
        
        kuvaus = new JTextArea(1,1);
        // Scrollpane ja (1,1) rajaus auttaa pitämään komponentin koon vakiona     (dunno y [1,1] tho)
        kuvaus.setText(kortti.getKuvaus());
        JScrollPane scrollPane = new JScrollPane(kuvaus);
        kuvaus.setLineWrap(true);
        kuvaus.setEditable(false);
        nappi = new JButton("Osta");
        kuuntelija = new KaupanKorttiNappikuuntelija(kauppapanel.getUi().getPeli().getPelaajat().get(0), kortti, i);
        nappi.addActionListener(kuuntelija);
        
        panel.add(scroll3, c); //NIMI
        
        c.weightx = 0.1;
        c.gridx = 1;
        panel.add(scroll2, c); //HINTA
        
        c.weighty = 0.5;
        c.weightx = 0.5;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(scrollPane, c); //KUVAUS
        
        c.weighty = 0.1;
        c.fill = GridBagConstraints.NONE;
        c.gridy = 2;
        panel.add(nappi, c);
        
    }
    
    public void paivitaKortti(Kortti kortti){
        this.kortti = kortti;
        nimi.setText(kortti.getNimi());
        hinta.setText("" + kortti.getHinta());
        kuvaus.setText(kortti.getKuvaus());
        if (this.kortti.equals(TyhjaKortti.class)){
            nappi.setEnabled(false);
        }
        nappi.removeActionListener(kuuntelija);
        kuuntelija = new KaupanKorttiNappikuuntelija(kauppapanel.getUi().getPeli().getPelaajat().get(0), kortti, i);
        nappi.addActionListener(kuuntelija);
    }

    public Kortti getKortti() {
        return kortti;
    }
}
