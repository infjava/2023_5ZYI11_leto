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
    }
}
