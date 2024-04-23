import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class OknoOtazky {
    private final JFrame okno;

    public OknoOtazky() {
        this.okno = new JFrame("Otazka");
        this.okno.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        this.okno.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Ha, také ľahké to nebude, drahý.");
            }
        });

        this.okno.setLayout(new BorderLayout());
        this.okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"), BorderLayout.NORTH);

        var tlacitka = new JPanel();
        tlacitka.setLayout(new GridLayout(1, 0, 20, 0));
        var tlacitkoAno = new JButton("Áno");
        var tlacitkoNie = new JButton("Nie");

        tlacitkoNie.setFocusable(false);

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
                tlacitko.setFocusable(true);
                tlacitkoDruhe.setText("Nie");
                tlacitkoDruhe.setFocusable(false);
            }
        });
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
