package obyvatelia;

import akcie.Akcia;
import akcie.AkciaMnozenie;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public class Magovia extends Tvory {
    private final int koeficientMagie;

    public Magovia(int populacia, int koeficientMagie) {
        super(populacia, TypObyvatela.MAGOVIA);

        this.koeficientMagie = koeficientMagie;
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        var akcie = super.dajAkcieNa(mojePolicko, druhePolicko);

        var obyvatelia = druhePolicko.getObyvatelia();

        if (obyvatelia.isPresent() && !(obyvatelia.get() instanceof Magovia)) {
            akcie.add(new AkciaMnozenie(druhePolicko, this.koeficientMagie));
        }

        return akcie;
    }

    @Override
    public Tvory vytvorTvory(int pocetTvorov) {
        return new Magovia(pocetTvorov, this.koeficientMagie);
    }
}
