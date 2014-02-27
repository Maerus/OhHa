
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;


public class KauppaPanel {
    private JPanel panel;
    private Kayttoliittyma ui;

    public KauppaPanel(JPanel panel, Kayttoliittyma ui) {
        this.panel = panel;
        this.ui = ui;
        
        this.panel.setBorder(new LineBorder(Color.GRAY, 2));
    }
    
    private KorttiPanel k1panel;
    private KorttiPanel k2panel;
    private KorttiPanel k3panel;
    
    void luoKomponentit(){
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gbl);
        
        c.ipadx = 100;
        c.ipady = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        
        JLabel label = new JLabel("~  Kauppa  ~");
        JPanel kortti1 = new JPanel();
        JPanel kortti2 = new JPanel();
        JPanel kortti3 = new JPanel();
        
        label.setBorder(new BevelBorder(1));
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, c);
        
        c.ipadx = 0;
        c.gridwidth = 1;
        c.gridy = 1;
        c.weighty = 0.9;
        c.fill = GridBagConstraints.BOTH;
        panel.add(kortti1, c);
        
        c.gridx = 1;
        panel.add(kortti2, c);
        
        c.gridx = 2;
        panel.add(kortti3, c);
        
        k1panel = new KorttiPanel(kortti1, ui.getPeli().getKorttipakka().otaKortti(), this, 1);
        k1panel.luoKomponentit();
        
        k2panel = new KorttiPanel(kortti2, ui.getPeli().getKorttipakka().otaKortti(), this, 2);
        k2panel.luoKomponentit();
        
        k3panel = new KorttiPanel(kortti3, ui.getPeli().getKorttipakka().otaKortti(), this, 3);
        k3panel.luoKomponentit();
    }
    
    

    public KorttiPanel getK1panel() {
        return k1panel;
    }

    public KorttiPanel getK2panel() {
        return k2panel;
    }

    public KorttiPanel getK3panel() {
        return k3panel;
    }

    public Kayttoliittyma getUi() {
        return ui;
    }
    
    
}
