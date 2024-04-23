import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class OknoOtazky {
    private final JFrame okno;

    public OknoOtazky() {
        this.okno = new JFrame("Otazka");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.okno.setLayout(new BorderLayout());
        this.okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"), BorderLayout.NORTH);

        var tlacitka = new JPanel();
        tlacitka.setLayout(new GridLayout(1, 0, 20, 0));
        tlacitka.add(new JButton("Áno"));
        tlacitka.add(new JButton("Nie"));

        this.okno.add(tlacitka, BorderLayout.CENTER);

        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
