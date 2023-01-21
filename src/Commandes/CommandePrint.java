package Commandes;
import Evaluation.*;
import Exceptions.ExpressionException;
import TP.TableSymbole;

public class CommandePrint {
    private Expression expression;// contien l'expression a afficher extraite de la ligne de commande

    public CommandePrint(Expression expression) {
        this.expression = expression;
    }

    public int executer(TableSymbole Table){
        try{
            double result = this.expression.evaluer(Table);
            System.out.println("La valeur est:"+result);

        }catch(ExpressionException e){ //derevatives of ExpressionException then ExpressionException done
            System.out.println(e);
        }
        return 0;
    } // executer la commande (evaluer) l'expression et afficher le resultat
}
