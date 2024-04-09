public class Klietka {
    private Object obsahKlietky;

    public Klietka() {
        this.obsahKlietky = null;
    }

    public void vypisObsah() {
        if (this.obsahKlietky == null) {
            System.out.println("Klietka je prazdna");
        } else if (this.obsahKlietky instanceof Lev lev) {
            System.out.printf("V klietke je lev %s%n", lev.getMeno());
        } else {
            System.out.println("V klietke je zviera");
        }
    }

    public void vloz(Object lev) {
        this.obsahKlietky = lev;
    }
}
