
package lautapeli.lautapeli.util;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lautapeli.lautapeli.domain.Pelaaja;


public class KorttiListSelectionListener implements ListSelectionListener{
    private JList korttilista;
    private JTextArea kuvausruutu;
    private Pelaaja pelaaja;

    public KorttiListSelectionListener(JList korttilista, JTextArea kuvausruutu, Pelaaja pelaaja) {
        this.korttilista = korttilista;
        this.kuvausruutu = kuvausruutu;
        this.pelaaja = pelaaja;
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        if (lse.getValueIsAdjusting() == false) {
            if (korttilista.getSelectedIndex() == -1) {
                kuvausruutu.setText("");
            } else {
                kuvausruutu.setText(pelaaja.getKortit().get(korttilista.getSelectedIndex()).getKuvaus());
            }
        }
    }

}
