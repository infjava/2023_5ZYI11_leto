public class Zajac extends Zviera implements Nazvany {
    private final String meno;

    public Zajac(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(Potrava potrava) {
        if (!(potrava instanceof Mrkva)) {
            throw new NespravnaPotravaException();
        }

        System.out.println("Zajac schrumkal mrkvu");
    }
}
