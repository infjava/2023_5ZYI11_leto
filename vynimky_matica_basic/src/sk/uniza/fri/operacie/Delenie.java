package sk.uniza.fri.operacie;

public class Delenie implements Operacia {
    @Override
    public double vypocitaj(double operand1, double operand2) {
        return operand1 / operand2;
    }
}
