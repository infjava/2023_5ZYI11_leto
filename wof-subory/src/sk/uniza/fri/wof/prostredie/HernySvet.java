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
        var typSekcie = TypSekcie.CHYBNA;
        var miestnosti = new HashMap<String, Miestnost>();
        var vychody = new ArrayList<DefiniciaVychodu>();
        String aktualnaMiestnost = null;
        String startovnaMiestnost = null;

        try (var mapa = new Scanner(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("mapa.txt")))) {
            while (mapa.hasNextLine()) {
                var riadok = mapa.nextLine();

                if (riadok.isBlank()) {
                    continue;
                }

                var citacRiadku = new Scanner(riadok);
                var prikaz = citacRiadku.next();

                switch (prikaz) {
                    case "miestnost" -> {
                        var nazov = citacRiadku.next();
                        String popis;
                        if (citacRiadku.hasNext()) {
                            popis = citacRiadku.nextLine().strip();
                        } else {
                            popis = nazov;
                        }

                        var novaMiestnost = new Miestnost(popis);
                        miestnosti.put(nazov, novaMiestnost);
                        aktualnaMiestnost = nazov;
                        typSekcie = TypSekcie.CHYBNA;
                    }
                    case "vychody" -> {
                        if (aktualnaMiestnost == null) {
                            throw new ChybnaMapaException("Nie je definovana miestnost");
                        }
                        typSekcie = TypSekcie.VYCHODY;
                    }
                    case "predmety" -> {
                        if (aktualnaMiestnost == null) {
                            throw new ChybnaMapaException("Nie je definovana miestnost");
                        }
                        typSekcie = TypSekcie.PREDMETY;
                    }
                    case "vybavenie" -> {
                        if (aktualnaMiestnost == null) {
                            throw new ChybnaMapaException("Nie je definovana miestnost");
                        }
                        typSekcie = TypSekcie.VYBAVENIE;
                    }
                    case "start" -> {
                        if (startovnaMiestnost != null) {
                            throw new ChybnaMapaException("Prikaz start je definovany viac krat");
                        }
                        typSekcie = TypSekcie.CHYBNA;
                        startovnaMiestnost = citacRiadku.next();
                    }
                    default -> {
                        if (aktualnaMiestnost == null) {
                            throw new ChybnaMapaException("Nie je definovana miestnost");
                        }
                        switch (typSekcie) {
                            case VYCHODY -> {
                                if (!prikaz.endsWith(":")) {
                                    throw new ChybnaMapaException("Nespravna definicia vychodu");
                                }
                                var nazovVychodu = prikaz.substring(0, prikaz.length() - 1);
                                var cielAleboTypVychodu = citacRiadku.next();
                                String typVychodu;
                                ArrayList<String> ciele = new ArrayList<>();
                                if (citacRiadku.hasNext()) {
                                    typVychodu = cielAleboTypVychodu;

                                    while (citacRiadku.hasNext()) {
                                        ciele.add(citacRiadku.next());
                                    }
                                } else {
                                    typVychodu = null;
                                    ciele.add(cielAleboTypVychodu);
                                }
                                vychody.add(new DefiniciaVychodu(aktualnaMiestnost, nazovVychodu, typVychodu, ciele));
                            }
                            case PREDMETY -> {
                                miestnosti.get(aktualnaMiestnost).polozPredmet(this.vytvorPredmet(prikaz, citacRiadku));
                            }
                            case VYBAVENIE -> {
                                miestnosti.get(aktualnaMiestnost).pridajVybavenie(this.vytvorVybavenie(prikaz));
                            }
                            default -> {
                                throw new ChybnaMapaException("Neocakavany prikaz " + prikaz);
                            }
                        }
                    }
                }

                if (citacRiadku.hasNext()) {
                    throw new ChybnaMapaException("Prikaz " + prikaz + " obsahuje nespracovane data");
                }
            }

            for (var definiciaVychodu : vychody) {
                var miestnostZ = miestnosti.get(definiciaVychodu.getMiestnost());
                var miestnostiDo = new ArrayList<Miestnost>();
                for (String nazovCielovejMiestnosti : definiciaVychodu.getCieloveMiestnosti()) {
                    miestnostiDo.add(miestnosti.get(nazovCielovejMiestnosti));
                }
                var smer = definiciaVychodu.getNazovVychodu();
                var typ = definiciaVychodu.getTypVychodu();

                if (typ == null) {
                    miestnostZ.nastavVychod(smer, this.zoberJednuMiestnost(miestnostiDo));
                } else {
                    miestnostZ.nastavVychod(smer, this.vytvorVychod(typ, miestnostiDo));
                }
            }
        }

        return miestnosti.get(startovnaMiestnost);
    }

    private Predmet vytvorPredmet(String typPredmetu, Scanner citacRiadku) {
        return switch (typPredmetu) {
            case "ObycajnyPredmet" -> new ObycajnyPredmet(citacRiadku.next());
            case "Hodinky" -> new Hodinky();
            case "Navleky" -> new Navleky();
            case "Radio" -> new Radio();
            case "Isic" -> new Isic(citacRiadku.nextInt());
            case "Baterky" -> new Baterky();
            default -> throw new ChybnaMapaException("Neznamy predmet " + typPredmetu);
        };
    }

    private Vybavenie vytvorVybavenie(String typVybavenia) {
        return switch (typVybavenia) {
            case "Automat" -> new Automat();
            case "OvladacVytahu" -> new OvladacVytahu();
            default -> throw new ChybnaMapaException("Nezname vybavenie " + typVybavenia);
        };
    }

    private Vychod vytvorVychod(String typ, ArrayList<Miestnost> miestnostDo) {
        return switch (typ) {
            case "VychodZVytahu" -> new VychodZVytahu(miestnostDo.toArray(new Miestnost[0]));
            case "VstupDoLabaku" -> new VstupDoLabaku(this.zoberJednuMiestnost(miestnostDo));
            default -> throw new ChybnaMapaException("Neznamy typ vychodu " + typ);
        };
    }

    private Miestnost zoberJednuMiestnost(ArrayList<Miestnost> miestnosti) {
        if (miestnosti.size() != 1) {
            throw new ChybnaMapaException("Nespravny pocet miestnosti vo vychode");
        }

        return miestnosti.get(0);
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
