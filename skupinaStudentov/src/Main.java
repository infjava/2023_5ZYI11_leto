public class Main {
    public static void main(String[] args) {
        var jozkoMrkvicka = new Student("Jozko", "Mrkvicka", "123456");
        var skupina = new Skupina("5ZYI11");
        skupina.pridaj(jozkoMrkvicka);
        skupina.vypis();
    }
}