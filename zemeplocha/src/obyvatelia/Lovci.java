package obyvatelia;

import akcie.Akcia;
import akcie.AkciaLov;
import hlavnyBalik.Policko;

import java.util.ArrayList;
import java.util.Optional;

public class Lovci extends Tvory {
    public Lovci(int pocetObyvatelov) {
        super(pocetObyvatelov, TypObyvatela.LOVCI);
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        var akcie = super.dajAkcieNa(mojePolicko, druhePolicko);

        var obyvatelia = druhePolicko.getObyvatelia();
        if (obyvatelia.isPresent() && obyvatelia.get() instanceof Zver) {
            akcie.add(new AkciaLov(this.getPopulacia(), druhePolicko));
        }

        return akcie;
    }

    @Override
    public Tvory vytvorTvory(int pocetTvorov) {
        return new Lovci(pocetTvorov);
    }
}
