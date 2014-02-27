
package lautapeli.lautapeli.gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import lautapeli.lautapeli.domain.Pelaaja;
import lautapeli.lautapeli.util.KorttiListSelectionListener;

public class KorttiFrame {
    private JInternalFrame raami;
    private Pelaaja pelaaja;

    public KorttiFrame(JInternalFrame frame, Pelaaja pelaaja) {
        raami = frame;
        this.pelaaja = pelaaja;
        raami.setBounds(130, 120, 500, 200);
        raami.setVisible(true);
        raami.setClosable(true);
        raami.setResizable(false);
    }
    
    private JList korttilista;
    private DefaultListModel listModel;
    private JTextArea kuvausruutu;
    
    /**
     * Metodi luo korttiraamin sisäiset komponentit.
     */
    void luoKomponentit(){
        GridLayout gl = new GridLayout(1, 2);
        raami.setLayout(gl);
        rakennaKorttilista();
        rakennaKuvausruutu();
        korttilista.addListSelectionListener(new KorttiListSelectionListener(korttilista, kuvausruutu, pelaaja));
        JScrollPane scrollpane1 = new JScrollPane(korttilista);
        JScrollPane scrollpane2 = new JScrollPane(kuvausruutu);
        raami.add(scrollpane1);
        raami.add(scrollpane2);
        
        raami.setLocation(raami.getLocation());
    }
    
    /**
     * Metodi rakentaa ja säätää listakomponentin;
     */
    private void rakennaKorttilista() {
        listModel = new DefaultListModel();
        luoLista();
        korttilista = new JList(listModel);
        korttilista.setLayoutOrientation(JList.VERTICAL);
        korttilista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        korttilista.setVisibleRowCount(-1);
    }

    private void rakennaKuvausruutu() {
        kuvausruutu = new JTextArea();
        kuvausruutu.setEditable(false);
        kuvausruutu.setBackground(Color.white);
    }
    
    /**
     * Metodi hakee pelaajalta listan korteista ja lisää ne listakomponenttiin
     */
    private void luoLista() {
        for (int i = 0; i < pelaaja.getKortit().size(); i++) {
            listModel.addElement(pelaaja.getKortit().get(i).getNimi());
        }
    }
            
            
            
            
    
    
}
