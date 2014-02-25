
package lautapeli.lautapeli.domain;

import java.util.ArrayList;
import java.util.Random;
import lautapeli.lautapeli.domain.kortti.*;


public class Korttipakka {
    private ArrayList<Kortti> pakka;
    private Random random;

    public Korttipakka() {
        random = new Random();
        pakka = new ArrayList<>();
        lisaaKortit();
    }

    private void lisaaKortit() {
//        30 korttia
        pakka.add(new Alkemisti());
        pakka.add(new Alkemisti());
        pakka.add(new Alkemisti());
        pakka.add(new Haaste());
        pakka.add(new Haaste());
        pakka.add(new Haaste());
        pakka.add(new LaadukasAse());
        pakka.add(new LaadukasAse());
        pakka.add(new LaadukasAse());
        pakka.add(new LohikaarmeenMetsastaja());
        pakka.add(new LohikaarmeenMetsastaja());
        pakka.add(new MekaaninenAugmentaatio());
        pakka.add(new MekaaninenAugmentaatio());
        pakka.add(new MekaaninenAugmentaatio());
        pakka.add(new MekaaninenAugmentaatio());
        pakka.add(new Orkkibane());
        pakka.add(new Orkkibane());
        pakka.add(new Orkkibane());
        pakka.add(new PalkkionmetsastajanLisenssi());
        pakka.add(new PalkkionmetsastajanLisenssi());
        pakka.add(new PalkkionmetsastajanLisenssi());
        pakka.add(new Rohkeus());
        pakka.add(new Rohkeus());
        pakka.add(new Rohkeus());
        pakka.add(new Siunaus());
        pakka.add(new Siunaus());
        pakka.add(new Siunaus());
        pakka.add(new Taistelukokemus());
        pakka.add(new Taistelukokemus());
        pakka.add(new Taistelukokemus());
    }
    
    public Kortti otaKortti(){
        if (pakka.isEmpty()){
            return new TyhjaKortti();
        }
        int i = random.nextInt(pakka.size());
        Kortti k = pakka.get(i);
        pakka.remove(i);
        return k;
    }
    
    
}
