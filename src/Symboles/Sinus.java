package Symboles;

import Exceptions.LogException;
import Exceptions.PasUneFonctionException;
import Exceptions.SqrtException;

public class Sinus extends Function{
    public Sinus() {
        this.nom = "sin";
    }

    @Override
    public double evaluer(double param) throws LogException, SqrtException, PasUneFonctionException {
        return Math.sin(param);
    }
}
