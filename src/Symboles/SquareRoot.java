package Symboles;

import Exceptions.LogException;
import Exceptions.PasUneFonctionException;
import Exceptions.SqrtException;

public class SquareRoot extends Function{
    public SquareRoot() {
        this.nom = "sqrt";
    }

    @Override
    public double evaluer(double param) throws LogException, SqrtException, PasUneFonctionException {
        double res = Math.sqrt(param);
        if(Double.isNaN(res)){
            throw new SqrtException();
        }else{return res;}
    }
}
