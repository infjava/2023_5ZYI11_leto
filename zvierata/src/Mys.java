public class Mys extends Zviera {
    @Override
    public void zozer(Potrava potrava) {
        if (potrava instanceof Syr) {
            System.out.println("Mys sa pustila do syra");
        } else {
            System.out.println("Tato mys je prilis prieberciva, daj syr");
        }
    }
}
