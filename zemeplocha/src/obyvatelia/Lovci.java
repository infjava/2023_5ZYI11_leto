package obyvatelia;

public class Lovci extends Tvory {
    public Lovci(int pocetObyvatelov) {
        super(pocetObyvatelov, TypObyvatela.LOVCI);
    }

    @Override
    public Tvory vytvorTvory(int pocetTvorov) {
        return new Lovci(pocetTvorov);
    }
}
