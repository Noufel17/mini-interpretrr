package TP;

import Exceptions.*;
import Symboles.*;
import java.util.ArrayList;

public class TableSymbole {
    private final ArrayList<Symbole> tableSymbole;
    private static TableSymbole instance;
    private TableSymbole() {
        this.tableSymbole = new ArrayList<>();
    }

    public void addVairable(Variable var){

    }
    public boolean isAvailable(String variableName){
       // implement
       return false;
    }
    public Symbole getFunction(String nom){
        return new Sinus();
    }
    public Symbole getVariable(String nom){
        return new Variable();
    }
    public static TableSymbole getInstance(){
        if(TableSymbole.instance != null){
            return TableSymbole.instance;
        }
        return new TableSymbole();
    }
    public void supprimerSymbole(Symbole s){
        tableSymbole.remove(s);
    }
    public double getFunctionValue (String nom, double param) throws SymboleFunNexistePas, LogException,SqrtException, PasUneFonctionException{
//        for(Symbole sym : tableSymbole){
//            if(sym.getNom().equalsIgnoreCase(nom)){
//                return ((Function)sym).evaluer(param);
//            }
//        }
//        throw new SymboleFunNexistePas();
        // cahnges completelly
        return 0.0; // awaits implementation
    }
    public double getVariableValue(String nom) throws SymboleVarNexistePas{
        for (Symbole symVar : tableSymbole) {
            if (symVar.getNom().equalsIgnoreCase(nom)) {
                if(symVar instanceof Variable) {
                    return ((Variable) symVar).getValeur();
                    // get valeurs et get function et evaluer dans la fonction
                }
            }
        }
        throw new SymboleVarNexistePas(); // unhandled
    }
}
