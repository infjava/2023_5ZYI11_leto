/**
 * @param <T> Typ zvierata v klietke
 */
public class Klietka<T extends Zviera> {
    private T obsahKlietky;

    public Klietka() {
        this.obsahKlietky = null;
    }

    public void vypisObsah() {
        if (this.obsahKlietky == null) {
            System.out.println("Klietka je prazdna");
        } else if (this.obsahKlietky instanceof Nazvany nazvaneZviera) {
            System.out.printf("V klietke je %s%n", nazvaneZviera.getMeno());
        } else {
            System.out.println("V klietke je zviera");
        }
    }

    public void vloz(T zviera) {
        this.obsahKlietky = zviera;
    }

    public void hodPotravu(Potrava potrava) {
        this.obsahKlietky.zozer(potrava);
    }
}
