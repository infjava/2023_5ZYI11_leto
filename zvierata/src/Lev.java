public class Lev extends Zviera implements Nazvany {
    private final String meno;

    public Lev(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(Potrava potrava) {
        if (potrava instanceof SurovySteak) {
            System.out.println("Lev zozral surovy steak");
        } else {
            System.out.println("Lev len cumi, ci to myslite vazne");
        }
    }
}
