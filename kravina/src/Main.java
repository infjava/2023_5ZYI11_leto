import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Otazka");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        okno.setLayout(new BorderLayout());
        okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"), BorderLayout.NORTH);

        var tlacitka = new JPanel();
        tlacitka.setLayout(new GridLayout(1, 0, 20, 0));
        tlacitka.add(new JButton("Áno"));
        tlacitka.add(new JButton("Nie"));

        okno.add(tlacitka, BorderLayout.CENTER);

        okno.pack();
        okno.setVisible(true);

    }
}
