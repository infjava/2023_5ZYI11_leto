package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.prostredie.predmety.*;
import sk.uniza.fri.wof.prostredie.vybavenie.Automat;
import sk.uniza.fri.wof.prostredie.vybavenie.OvladacVytahu;
import sk.uniza.fri.wof.prostredie.vybavenie.Vybavenie;
import sk.uniza.fri.wof.prostredie.vychody.VstupDoLabaku;
import sk.uniza.fri.wof.prostredie.vychody.Vychod;
import sk.uniza.fri.wof.prostredie.vychody.VychodZVytahu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class HernySvet {
    private final Miestnost startovaciaMiestnost;


    /**
     * Vytvorí herný svet s mapou definovanou v zdrojovom kóde
     */
    public HernySvet() {
        this.startovaciaMiestnost = this.vytvorMapu();
    }

    /**
     * Vytvori mapu definovanú pomocou zdrojového kódu
     */
    private Miestnost vytvorMapu() {
        try (var mapa = new Scanner(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("mapa.txt")))) {
            return null;
        }
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
