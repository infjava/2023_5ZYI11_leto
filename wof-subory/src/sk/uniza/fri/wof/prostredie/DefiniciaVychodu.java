package sk.uniza.fri.wof.prostredie;

public class DefiniciaVychodu {
    private final String miestnost;
    private final String nazovVychodu;
    private final String typVychodu;
    private final Iterable<String> cieloveMiestnosti;

    public DefiniciaVychodu(String miestnost, String nazovVychodu, String typVychodu, Iterable<String> cieloveMiestnosti) {
        this.miestnost = miestnost;
        this.nazovVychodu = nazovVychodu;
        this.typVychodu = typVychodu;
        this.cieloveMiestnosti = cieloveMiestnosti;
    }

    public String getMiestnost() {
        return this.miestnost;
    }

    public String getNazovVychodu() {
        return this.nazovVychodu;
    }

    public String getTypVychodu() {
        return this.typVychodu;
    }

    public Iterable<String> getCieloveMiestnosti() {
        return this.cieloveMiestnosti;
    }
}
