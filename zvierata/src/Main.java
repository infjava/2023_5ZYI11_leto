public class Main {
    public static void main(String[] args) {
        var lev = new Lev("Alex");
        var klietka = new Klietka();

        klietka.vypisObsah();
        klietka.vloz(lev);
        klietka.vypisObsah();
    }
}
