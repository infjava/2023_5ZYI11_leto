import javax.swing.*;

public class ZoznamStudentov {
    private final JFrame okno;
    private JPanel obsahOkna;
    private JList zoznamStudentov;
    private JButton pridaj;
    private JButton vymaz;
    private JButton uprav;

    public ZoznamStudentov() {
        this.okno = new JFrame("Zoznam študentov");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(this.obsahOkna);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
