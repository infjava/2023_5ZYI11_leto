package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

public class AkciaLov implements Akcia {
    private final int maxPocetLovcov;
    private final Policko druhePolicko;

    public AkciaLov(int maxPocetLovcov, Policko druhePolicko) {
        this.maxPocetLovcov = maxPocetLovcov;
        this.druhePolicko = druhePolicko;
    }

    @Override
    public String getNazov() {
        return "Lov";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {

    }
}
