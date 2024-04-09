public class Zajac extends Zviera<Mrkva> implements Nazvany {
    private final String meno;

    public Zajac(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(Mrkva potrava) {
        System.out.println("Zajac schrumkal mrkvu");
    }
}
