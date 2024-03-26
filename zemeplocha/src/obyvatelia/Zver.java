package obyvatelia;

public class Zver extends Tvory {
    public Zver(int populacia, TypObyvatela typ) {
        super(populacia, typ);
    }

    @Override
    public Tvory vytvorTvory(int pocetTvorov) {
        return new Zver(pocetTvorov, this.getTypObyvatela());
    }
}
