package Commandes;
import Evaluation.*;
import Exceptions.ExpressionException;
import TP.TableSymbole;

public class CommandePrint implements Commande {

    public int executer(String lignCmd) throws Exception{
            Expression expression = new Expression(lignCmd.split(" ")[1]);
            double result = expression.evaluer();
            System.out.println("Le resultat est: "+result);
            return 0;
    } // executer la commande (evaluer) l'expression et afficher le resultat
}
