package Commandes;

import Exceptions.ExpressionException;

public interface Commande {
    int executer(String ligneCmd) throws ExpressionException;// executer la commande selon son type
}

