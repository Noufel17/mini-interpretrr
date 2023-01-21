package Evaluation;

import Exceptions.ExpressionException;
import TP.TableSymbole;

public interface Evaluable {
    double evaluer(TableSymbole table) throws ExpressionException;// evaluer une expression selon son type en utilisant la table de symboles
}
