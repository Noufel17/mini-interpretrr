package Commandes;

import Exceptions.ExpressionException;

public interface Commande {
    int executer(String ligneCmd) throws Exception;// executer la commande selon son type
}

