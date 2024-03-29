package sk.uniza.fri.wof.zaklad;

import sk.uniza.fri.wof.prostredie.Miestnost;
import sk.uniza.fri.wof.prostredie.Predmet;

import java.util.HashMap;

public class Hrac {
    private Miestnost aktualnaMiestnost;
    private final HashMap<String, Predmet> inventar;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new HashMap<>();
    }

    public void posunVSmere(String smer) {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getVychodVSmere(smer).getMiestnost();
        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            this.aktualnaMiestnost.vypisInfoOMiestnosti();
        }
    }

    public void zoberPredmet(String predmet) {
        Predmet zdvihnutyPredmet = this.aktualnaMiestnost.zoberPredmet(predmet);
        this.inventar.put(zdvihnutyPredmet.getNazov(), zdvihnutyPredmet);
    }

    public void polozPredmet(String predmet) {
        Predmet pokladanyPredmet = this.inventar.get(predmet);
        if (pokladanyPredmet.mozemPolozit()) {
            this.inventar.remove(predmet);
            this.aktualnaMiestnost.polozPredmet(pokladanyPredmet);
        } else {
            System.out.format("Predmet %s sa neda polozit%n", predmet);
        }
    }

    /**
     * vypise inventar do terminalu
     *
     */
    public void vypisInventar() {
        if (this.inventar.isEmpty()) {
            System.out.println("Zbytocne pozeras, ved tu nic nie je");
        } else {
            System.out.println("Tvoj inventar obsahuje:");
            for (var predmet : this.inventar.keySet()) {
                System.out.printf("- %s%n", predmet);
            }
        }
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public void pouziPredmet(String predmet) {
        var pouzivanyPredmet = this.inventar.get(predmet);

        if (pouzivanyPredmet != null) {
            pouzivanyPredmet.pouzi();
        } else {
            System.out.format("Predmet %s sa nenasiel v inventari%n", predmet);
        }
    }
}
