import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkupinaTest {
    @Test
    public void pridajJednehoStudenta() {
        var skupina = new Skupina("aaa");
        skupina.pridaj(new Student("Jozko", "Mrkvicka", "123"));
    }
}
