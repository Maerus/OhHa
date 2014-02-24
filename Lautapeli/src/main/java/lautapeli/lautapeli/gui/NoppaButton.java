
package lautapeli.lautapeli.gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;


public class NoppaButton extends JToggleButton{
    private int i;
    private int noppa;

    public NoppaButton(int i, int noppa, String vaihe) {
        this.i = i;
        this.noppa = noppa;
        setBorder(new BevelBorder(0));
//        setText("" + noppa);
        asetaKuva(vaihe);
    }

    public int getI() {
        return i;
    }

    public int getNoppa() {
        return noppa;
    }

    public void asetaKuva(String vaihe) {
        if (noppa == 1){
            ImageIcon tyhjaikoni = new ImageIcon(new ImageIcon(getClass().getResource("/tyhja.jpg")).getImage());
            setIcon(tyhjaikoni);
        } else if (vaihe.equals("Vihollisnopat")) {
            asetaVKuva();
        } else if (vaihe.equals("Taistelunopat")) {
            asetaTKuva();
        } else if (vaihe.equals("Aarrenopat")) {
            asetaAKuva();
        }
    }

    private void asetaVKuva() {
        if (noppa == 2 || noppa == 3){
            ImageIcon skelly = new ImageIcon(new ImageIcon(getClass().getResource("/skellyface.jpg")).getImage());
            setIcon(skelly);
        } else if (noppa == 4 || noppa == 5){
            ImageIcon orkki = new ImageIcon(new ImageIcon(getClass().getResource("/orkki.jpg")).getImage());
            setIcon(orkki);
        } else if (noppa == 6){
            ImageIcon lohikaarme = new ImageIcon(new ImageIcon(getClass().getResource("/doragon.jpg")).getImage());
            setIcon(lohikaarme);
        }
    }

    private void asetaTKuva() {
        if (noppa == 2 || noppa == 3){
            ImageIcon nyrkki = new ImageIcon(new ImageIcon(getClass().getResource("/nyrkky.jpg")).getImage());
            setIcon(nyrkki);
        } else if (noppa == 4){
            ImageIcon jousi = new ImageIcon(new ImageIcon(getClass().getResource("/bow.jpg")).getImage());
            setIcon(jousi);
        } else if (noppa == 5){
            ImageIcon miekka = new ImageIcon(new ImageIcon(getClass().getResource("/sord.jpg")).getImage());
            setIcon(miekka);
        } else if (noppa == 6){
            ImageIcon tulipallo = new ImageIcon(new ImageIcon(getClass().getResource("/greatballsoffire.jpg")).getImage());
            setIcon(tulipallo);
        }
    }

    private void asetaAKuva() {
        if (noppa == 2 || noppa == 3){
            ImageIcon raha1 = new ImageIcon(new ImageIcon(getClass().getResource("/kolikot.jpg")).getImage());
            setIcon(raha1);
        } else if (noppa == 4){
            ImageIcon raha2 = new ImageIcon(new ImageIcon(getClass().getResource("/munneh.jpg")).getImage());
            setIcon(raha2);
        } else if (noppa == 5){
            ImageIcon vp = new ImageIcon(new ImageIcon(getClass().getResource("/vp.jpg")).getImage());
            setIcon(vp);
        } else if (noppa == 6){
            ImageIcon kortti = new ImageIcon(new ImageIcon(getClass().getResource("/kortti.jpg")).getImage());
            setIcon(kortti);
        }
    }

    public void paivitaKuva(String vaihe, int uusinoppa) {
        noppa = uusinoppa;
        asetaKuva(vaihe);
    }
    
    
}
