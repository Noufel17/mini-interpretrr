package TP;

import Exceptions.*;
import Symboles.*;
import java.util.ArrayList;

public class TableSymbole {
    private ArrayList<Symbole> tableSymbole;

    public TableSymbole() {
        this.tableSymbole = new ArrayList<>();
    }

    public void ajouter(Symbole s){
        tableSymbole.add(s);
    }
    public void supprimer(Symbole s){
        tableSymbole.remove(s);
    }
    public double getFunctionValue (String nom, double param) throws SymboleFunNexistePas, LogException,SqrtException, PasUneFonctionException{
        for(Symbole sym : tableSymbole){
            if(sym.getNom().equalsIgnoreCase(nom)){
                return ((Function)sym).evaluer(param);
            }
        }
        throw new SymboleFunNexistePas(); // unhandled
    }
    public double getVariableValue(String nom) throws SymboleVarNexistePas{
        for (Symbole symVar : tableSymbole) {
            if (symVar.getNom().equalsIgnoreCase(nom)) {
                if(symVar instanceof Variable) {
                    return ((Variable) symVar).getValeur(); // get valeurs et get function et evaluer dans la fonction
                }
            }
        }
        throw new SymboleVarNexistePas(); // unhandled
    }
}
