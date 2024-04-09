import java.util.ArrayList;
import java.util.Iterator;

public class Prvocisla implements Iterable<Integer> {


    private final ArrayList<Integer> prvocisla;

    public Prvocisla(int max) {
        this.prvocisla = new ArrayList<Integer>();
        for (int i = 0; i <= max; i++) {
            if (this.jePrvocislo(i)) {
                this.prvocisla.add(i);
            }
        }
    }

    private boolean jePrvocislo(int hodnota) {
        for (int i = 2; i < hodnota - 1; i++) {
            if ((hodnota % i) == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.prvocisla.iterator();
    }
}
