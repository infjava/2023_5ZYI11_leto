package sk.uniza.fri.wof.prostredie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObycajnyPredmet implements Predmet {
    private final String nazov;
    private boolean obute;

    public ObycajnyPredmet(String nazov) {
        this.nazov = nazov;
        this.obute = false;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouzi() {
        switch (this.nazov) {
            case "hodinky":
                var dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                var now = LocalDateTime.now();

                System.out.println(dtf.format(now));
                break;
            case "navleky":
                this.obute = !this.obute;

                // System.out.println(this.obute ? "Obul si si navleky" : "Vyzul si si navleky");
                if (this.obute) {
                    System.out.println("Obul si si navleky");
                } else {
                    System.out.println("Vyzul si si navleky");
                }
                break;
            default:
                System.out.format("Predmet %s sa neda pouzit%n", this.nazov);
        }
    }
}
