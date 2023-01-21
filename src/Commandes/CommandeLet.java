package Commandes;
import Evaluation.*;
import Exceptions.*;
import Symboles.*;
import TP.*;
public class CommandeLet {
    private Variable var; // contenir la variable dans la commande let // why final? didnt do main tho
    private Expression expression; // contenir l'expression a affecter a la variable // why final?

    public CommandeLet(Variable var, Expression expression) {
        this.var = var;
        this.expression = expression;
    }
     // faire la methode executer en mettant la variable et ca valeur dans la table avec les testes et les exceptions
    public int executer(TableSymbole Table) throws ExpressionException{ // return value nit used yet
        try{
            boolean NomAccepte = this.var.verifierNom();
            if(NomAccepte){
                double val = this.expression.evaluer(Table);// this methode throws exceptions that are undefined yet dont forget to handle them
                this.var.setValeur(val); // affectation de la valeur a la variable
                Table.ajouter((this.var)); // may need type casting to Symbole
                return 0;
            }
        }catch(VarNomfauxException exp1){
            System.err.println(exp1);
            return 1;
        }catch(VarNomCmdException exp2){
            System.err.println(exp2); // yes its same catch field but toString methode will be different
            return 2;
        }catch(VarNomFctException exp3){
            System.err.println(exp3);
        }
        return 0; // how to get rid of this
    }
}
