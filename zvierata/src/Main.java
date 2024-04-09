public class Main {
    public static void main(String[] args) {
        var lev = new Lev("Alex");
        var klietkaNaLeva = new Klietka<Lev>();

        klietkaNaLeva.vypisObsah();
        klietkaNaLeva.vloz(lev);
        klietkaNaLeva.vypisObsah();

        var mys = new Mys();
        var klietkaNaMys = new Klietka<Mys>();

        klietkaNaMys.vypisObsah();
        klietkaNaMys.vloz(mys);
        klietkaNaMys.vypisObsah();
        // klietkaNaMys.vloz(new Lev("Simba"));
        klietkaNaMys.vypisObsah();

        var zajac = new Zajac("Bugs");
        var klietkaNaZajaca = new Klietka<Zajac>();

        klietkaNaZajaca.vypisObsah();
        klietkaNaZajaca.vloz(zajac);
        klietkaNaZajaca.vypisObsah();

        var klietkaNaCisla = new Klietka<Integer>();
        klietkaNaCisla.vloz(5);
        klietkaNaCisla.vypisObsah();
    }
}
