/**
 * @param <T> typ zvierata
 */
public abstract class Zviera<T extends Zviera<T>> {

    public abstract void zozer(Potrava<T> potrava);
}
