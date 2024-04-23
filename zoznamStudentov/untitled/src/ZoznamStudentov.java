import javax.swing.*;

public class ZoznamStudentov {
    private final JFrame okno;
    private final DefaultListModel<Student> studenti;
    private JPanel obsahOkna;
    private JList<Student> zoznamStudentov;
    private JButton pridaj;
    private JButton vymaz;
    private JButton uprav;

    public ZoznamStudentov() {
        this.studenti = new DefaultListModel<Student>();

        this.studenti.addElement(new Student("Jozko", "Mrkvicka"));
        this.studenti.addElement(new Student("Ferko", "Mrkvicka"));
        this.studenti.addElement(new Student("Martin", "Mrkvicka"));

        this.zoznamStudentov.setModel(this.studenti);

        this.okno = new JFrame("Zoznam študentov");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(this.obsahOkna);
        this.okno.pack();

        this.pridaj.addActionListener(e -> this.pridajStudenta());
    }

    private void pridajStudenta() {
        var dialog = new PridajStudenta(this.studenti);
        dialog.setVisible(true);
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
