package Evaluation;

import Exceptions.ExpressionException;
import TP.TableSymbole;

public interface Evaluable {
    String [] extraire(String expression);
    double evaluer() throws ExpressionException;
}
