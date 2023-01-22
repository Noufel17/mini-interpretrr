package Symboles;
import Exceptions.*;
public class Absolute extends Function{
    @Override
    public double evaluer(double param) throws LogException, SqrtException, PasUneFonctionException {
        return Math.abs(param);
    }
}
