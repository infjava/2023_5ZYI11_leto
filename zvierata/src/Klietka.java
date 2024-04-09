public class Klietka {
    private Lev lev;

    public Klietka() {
        this.lev = null;
    }

    public void vypisObsah() {
        if (this.lev == null) {
            System.out.println("Klietka je prazdna");
        } else {
            System.out.printf("V klietke je lev %s%n", this.lev.getMeno());
        }
    }

    public void vloz(Lev lev) {
        this.lev = lev;
    }
}
