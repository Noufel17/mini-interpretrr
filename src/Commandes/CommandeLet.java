package Commandes;
import Evaluation.*;
import Exceptions.*;
import Symboles.*;
import TP.*;
public class CommandeLet  implements Commande{
    public int executer(String lignCmd) throws ExpressionException{
        Variable variable = new Variable(lignCmd.split(" ")[0]);
        Expression expression = new Expression(lignCmd.split(" ")[1]);
        try{
            boolean NomAccepted = variable.verifierNom();
            if(NomAccepted){
                double val = expression.evaluer(TableSymbole.getInstance());
                variable.setValeur(val);
                TableSymbole.getInstance().addVairable(variable);
                return 0;
            }
        }catch(VarNomfauxException exp1){
            System.err.println(exp1);
            return 1;
        }catch(VarNomCmdException exp2){
            System.err.println(exp2);
            return 2;
        }catch(VarNomFctException exp3){
            System.err.println(exp3);
            return 3;
        }
        return 0;
    }
}
