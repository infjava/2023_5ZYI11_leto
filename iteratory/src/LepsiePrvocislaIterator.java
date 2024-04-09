import java.util.Iterator;

public class LepsiePrvocislaIterator implements Iterator<Integer> {
    private final int max;
    private int aktualna;

    public LepsiePrvocislaIterator(int max) {
        this.max = max;
        this.aktualna = 2;
    }

    @Override
    public boolean hasNext() {
        return this.aktualna <= this.max;
    }

    @Override
    public Integer next() {
        var predosle = this.aktualna;
        do {
            this.aktualna++;
        } while (!this.jePrvocislo(this.aktualna));
        return predosle;
    }


    private boolean jePrvocislo(int hodnota) {
        for (int i = 2; i < hodnota - 1; i++) {
            if ((hodnota % i) == 0) {
                return false;
            }
        }

        return true;
    }
}
