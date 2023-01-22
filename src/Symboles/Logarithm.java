package Symboles;

import Exceptions.LogException;
import Exceptions.PasUneFonctionException;
import Exceptions.SqrtException;

public class Logarithm extends Function{
    @Override
    public double evaluer(double param) throws LogException, SqrtException, PasUneFonctionException {
        double res = Math.log(param);
        if(Double.isNaN(res)){
            throw new LogException();
        }else{return res;}
    }
}
