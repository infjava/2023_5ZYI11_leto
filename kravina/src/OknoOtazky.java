import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoOtazky {
    private final JFrame okno;

    public OknoOtazky() {
        this.okno = new JFrame("Otazka");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.okno.setLayout(new BorderLayout());
        this.okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"), BorderLayout.NORTH);

        var tlacitka = new JPanel();
        tlacitka.setLayout(new GridLayout(1, 0, 20, 0));
        JButton tlacitkoAno = new JButton("Áno");

        tlacitkoAno.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Tak sa snaž!");
            System.exit(0);
        });

        tlacitka.add(tlacitkoAno);
        tlacitka.add(new JButton("Nie"));

        this.okno.add(tlacitka, BorderLayout.CENTER);

        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
