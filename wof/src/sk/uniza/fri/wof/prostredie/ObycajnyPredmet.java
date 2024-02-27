package sk.uniza.fri.wof.prostredie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObycajnyPredmet implements Predmet {
    private final String nazov;

    public ObycajnyPredmet(String nazov) {
        this.nazov = nazov;
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
            default:
                System.out.format("Predmet %s sa neda pouzit%n", this.nazov);
        }
    }
}
