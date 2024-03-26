package sk.uniza.fri.operacie;

import sk.uniza.fri.vynimky.DelenieNulouException;

public interface Operacia {
    double vypocitaj(double operand1, double operand2) throws DelenieNulouException;
}
