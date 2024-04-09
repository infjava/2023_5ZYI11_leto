public class Mys extends Zviera {
    @Override
    public void zozer(Potrava potrava) {
        if (!(potrava instanceof Syr)) {
            throw new NespravnaPotravaException();
        }

        System.out.println("Mys sa pustila do syra");
    }
}
