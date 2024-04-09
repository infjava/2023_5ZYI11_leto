public class Zajac extends Zviera<Zajac> implements Nazvany {
    private final String meno;

    public Zajac(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(Potrava<Zajac> potrava) {
        System.out.println("Zajac schrumkal mrkvu");
    }
}
