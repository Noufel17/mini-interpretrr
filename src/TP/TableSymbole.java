package TP;

import Exceptions.*;
import Symboles.*;
import java.util.ArrayList;

public class TableSymbole {
    private final ArrayList<Symbole> tableSymbole;
    private static TableSymbole instance;
    private TableSymbole() {
        this.tableSymbole = new ArrayList<>();
        tableSymbole.add(new Absolute());
        tableSymbole.add(new Cosinus());
        tableSymbole.add(new Sinus());
        tableSymbole.add(new Tangent());
        tableSymbole.add(new SquareRoot());
        tableSymbole.add(new Logarithm());
    }

    public void addVairable(Variable var){
        tableSymbole.add(var);
    }
    public boolean isAvailable(String variableName){
        boolean available = true;
       for (Symbole symbole : tableSymbole){
           if(symbole.getNom().equals(variableName)){
               available=false;
               break;
           }
       }
       return available;
    }
    public Function getFunction(String nom){
        for (Symbole symbole : tableSymbole){
            if(symbole.getNom().equals(nom)){
               return (Function)symbole;
            }
        }
        return null;
    }
    public void setVariable(String nom,double val){
        for (Symbole symbole : tableSymbole){
            if(symbole.getNom().equals(nom)){
                ((Variable)symbole).setValeur(val);
            }
        }
    }
    public Variable getVariable(String nom) throws SymboleVarNexistePas{
        for (Symbole symbole : tableSymbole){
            if(symbole.getNom().equals(nom)){
                return (Variable)symbole;
            }
        }
        throw new SymboleVarNexistePas();
    }
    public static TableSymbole getInstance() {
        if(instance == null){
            instance = new TableSymbole();
        }
        return instance;
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
