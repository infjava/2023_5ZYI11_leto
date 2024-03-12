package obyvatelia;

import akcie.Akcia;
import akcie.AkciaMnozenie;
import akcie.AkciaPresidlenie;
import hlavnyBalik.Policko;

import java.util.ArrayList;
import java.util.Optional;

public class Magovia extends Tvory {
    public Magovia(int populacia, int koeficientMagie) {
        super(populacia, TypObyvatela.MAGOVIA);
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        var akcie = super.dajAkcieNa(mojePolicko, druhePolicko);

        var obyvatelia = druhePolicko.getObyvatelia();

        if (obyvatelia.isPresent() && !(obyvatelia.get() instanceof Magovia)) {
            akcie.add(new AkciaMnozenie(mojePolicko, druhePolicko));
        }

        return akcie;
    }
}
