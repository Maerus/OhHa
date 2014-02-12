
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

    public KauppaPanel(JPanel panel) {
        this.panel = panel;
        
        this.panel.setBorder(new LineBorder(Color.GRAY, 2));
    }
    
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
        
        KorttiPanel k1panel = new KorttiPanel(kortti1);
        k1panel.luoKomponentit();
        KorttiPanel k2panel = new KorttiPanel(kortti2);
        k2panel.luoKomponentit();
        KorttiPanel k3panel = new KorttiPanel(kortti3);
        k3panel.luoKomponentit();
    }
}
