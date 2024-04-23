import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OknoOtazky {
    private final JFrame okno;

    public OknoOtazky() {
        this.okno = new JFrame("Otazka");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.okno.setLayout(new BorderLayout());
        this.okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"), BorderLayout.NORTH);

        var tlacitka = new JPanel();
        tlacitka.setLayout(new GridLayout(1, 0, 20, 0));
        var tlacitkoAno = new JButton("Áno");
        var tlacitkoNie = new JButton("Nie");

        this.nastavUdalosti(tlacitkoAno, tlacitkoNie);
        this.nastavUdalosti(tlacitkoNie, tlacitkoAno);

        tlacitka.add(tlacitkoAno);
        tlacitka.add(tlacitkoNie);

        this.okno.add(tlacitka, BorderLayout.CENTER);

        this.okno.pack();
    }

    private void nastavUdalosti(JButton tlacitko, JButton tlacitkoDruhe) {
        tlacitko.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Tak sa snaž!");
            System.exit(0);
        });

        tlacitko.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                tlacitko.setText("Áno");
                tlacitkoDruhe.setText("Nie");
            }
        });
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
