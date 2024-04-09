import java.util.Iterator;

public class RangeIterator implements Iterator<Integer> {
    private final int pocet;
    private int aktualne;

    public RangeIterator(int pocet) {
        this.pocet = pocet;
        this.aktualne = 0;
    }

    @Override
    public boolean hasNext() {
        return this.aktualne < this.pocet;
    }

    @Override
    public Integer next() {
        this.aktualne++;
        return this.aktualne;
    }
}
