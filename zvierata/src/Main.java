public class Main {
    public static void main(String[] args) {
        var lev = new Lev("Alex");
        var klietkaNaLeva = new Klietka();

        klietkaNaLeva.vypisObsah();
        klietkaNaLeva.vloz(lev);
        klietkaNaLeva.vypisObsah();

        var mys = new Mys();
        var klietkaNaMys = new Klietka();

        klietkaNaMys.vypisObsah();
        klietkaNaMys.vloz(mys);
        klietkaNaMys.vypisObsah();
        klietkaNaMys.vloz(new Lev("Simba"));
        klietkaNaMys.vypisObsah();

        var zajac = new Zajac("Bugs");
        var klietkaNaZajaca = new Klietka();

        klietkaNaZajaca.vypisObsah();
        klietkaNaZajaca.vloz(zajac);
        klietkaNaZajaca.vypisObsah();
//
//        var klietkaNaKraviny = new Klietka();
//        klietkaNaKraviny.vloz(5);
//        klietkaNaKraviny.vypisObsah();
    }
}
