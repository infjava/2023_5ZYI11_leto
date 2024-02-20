package fri.wof.prostredie;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Trieda fri.wof.prostredie.Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private final String popisMiestnosti;
    private final HashMap<String, Miestnost> vychody;
    private final ArrayList<Predmet> predmety;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.predmety = new ArrayList<>();
        this.vychody = new HashMap<>();
    }

    /**
     * Nastavi vychody z miestnosti. Kazdy vychod je urceny bud odkazom 
     * na miestnost alebo hodnotou null, ak vychod tym smerom neexistuje.
     * 
     * @param sever miestnost smerom na sever.
     * @param vychod miestnost smerom na vychod.
     * @param juh miestnost smerom na juh.
     * @param zapad miestnost smerom na zapad.
     */
    public void nastavVychody(Miestnost sever, Miestnost vychod, Miestnost juh, Miestnost zapad) {
        if (sever != null) {
            this.vychody.put("sever", sever);
        }
        if (vychod != null) {
            this.vychody.put("vychod", vychod);
        }
        if (juh != null) {
            this.vychody.put("juh", juh);
        }
        if (zapad != null) {
            this.vychody.put("zapad", zapad);
        }
    }

    /**
     * polozi predmet do miestnosti
     * @param predmet pokladany predmet
     */
    public void polozPredmet(Predmet predmet) {
        this.predmety.add(predmet);
    }

    /**
     * zoberie predmet z miestnosti
     * @param nazov nazov zdvihaneho predmetu
     * @return zdvihnuty predmet
     */
    public Predmet zoberPredmet(String nazov) {
        for (Predmet kontrolovanyPredmet : this.predmety) {
            if (kontrolovanyPredmet.getNazov().equals(nazov)) {
                this.predmety.remove(kontrolovanyPredmet);
                return kontrolovanyPredmet;
            }
        }

        return null;
    }

    public void vypisStavMiestnosti() {
        System.out.println("Teraz si v miestnosti " + this.popisMiestnosti);
        System.out.print("Vychody: ");
        for (String smer : this.vychody.keySet()) {
            System.out.format("%s ", smer);
        }

        System.out.println();

        if (!this.predmety.isEmpty()) {
            System.out.print("Predmety v miestnosti: ");
            for (Predmet predmet : this.predmety) {
                System.out.printf("%s ", predmet.getNazov());
            }
            System.out.println();
        }
    }

    public Miestnost getMiestnostVSmere(String smer) {
        return this.vychody.get(smer);
    }
}
