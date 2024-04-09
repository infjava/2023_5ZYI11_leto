import java.util.Iterator;

public class Range implements Iterable<Integer> {
    private final int pocet;

    public Range(int pocet) {
        this.pocet = pocet;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(this.pocet);
    }
}
