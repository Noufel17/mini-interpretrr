package Commandes;
import Evaluation.*;
import Exceptions.*;
import Symboles.*;
import TP.*;
public class CommandeLet  implements Commande{

    public int executer(String lignCmd) throws Exception {
        String str = lignCmd.trim().split(" ")[1];
        String nom = str.trim().split("=")[0];
        Variable variable = new Variable(nom);
        Expression expression = new Expression(str.trim().split("=")[1]);
        try{
            boolean NomAccepted = variable.verifierNom();
            if(NomAccepted){
                double val = expression.evaluer();
                if(TableSymbole.getInstance().isAvailable(variable.getNom())){
                    variable.setValeur(val);
                    TableSymbole.getInstance().addVairable(variable);
                    System.out.println("OK");
                    return 0;
                }else{
                    TableSymbole.getInstance().setVariable(nom,val);
                    System.out.println("OK");
                    return 0;
                }
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
