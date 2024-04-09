public class Lev extends Zviera<SurovySteak> implements Nazvany {
    private final String meno;

    public Lev(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(SurovySteak potrava) {
        System.out.println("Lev zozral surovy steak");
    }
}
