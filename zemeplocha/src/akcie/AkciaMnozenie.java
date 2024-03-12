package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

public class AkciaMnozenie implements Akcia {
    private final Policko druhePolicko;
    private final int koeficientMagie;

    public AkciaMnozenie(Policko druhePolicko, int koeficientMagie) {
        this.druhePolicko = druhePolicko;
        this.koeficientMagie = koeficientMagie;
    }

    @Override
    public String getNazov() {
        return "Rozmnož";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        var mnozeneTvory = this.druhePolicko.getObyvatelia().orElseThrow();
        mnozeneTvory.rozmnoz(this.koeficientMagie);
    }
}
