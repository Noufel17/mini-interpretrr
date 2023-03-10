package Symboles;

import Exceptions.LogException;
import Exceptions.PasUneFonctionException;
import Exceptions.SqrtException;

public class Cosinus extends Function{
    public Cosinus() {
        this.nom = "cos";
    }

    @Override
    public double evaluer(double param) throws LogException, SqrtException, PasUneFonctionException {
        return Math.cos(param);
    }
}
