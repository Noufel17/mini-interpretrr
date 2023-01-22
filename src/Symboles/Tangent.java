package Symboles;

import Exceptions.LogException;
import Exceptions.PasUneFonctionException;
import Exceptions.SqrtException;

public class Tangent extends Function{
    public Tangent() {
        this.nom = "tan";
    }

    @Override
    public double evaluer(double param) throws LogException, SqrtException, PasUneFonctionException {
        return Math.tan(param);
    }
}
