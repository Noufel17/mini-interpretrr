package Commandes;
import Evaluation.*;
import Exceptions.ExpressionException;
import TP.TableSymbole;

public class CommandePrint implements Commande {

    public int executer(String lignCmd) throws ExpressionException{
            Expression expression = new Expression(lignCmd.split(" ")[1]); // I think
            double result = expression.evaluer(TableSymbole.getInstance());
            System.out.println("Le resultat est: "+result);
            return 0;
    } // executer la commande (evaluer) l'expression et afficher le resultat
}
