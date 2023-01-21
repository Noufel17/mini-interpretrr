package TP;

import Symboles.*;
import Evaluation.*;
import Commandes.*;
import Exceptions.*;

import java.util.Locale;

public class Interpreteur {
    private TableSymbole table;
    private String ligneCmd;

    public Interpreteur() {
        this.table= new TableSymbole();
    }

    public TableSymbole getTable() {
        return table;
    }

    public String getLigneCmd() {
        return ligneCmd;
    }

    public void setLigneCmd(String ligneCmd) {
        this.ligneCmd = ligneCmd;
    }

    // la methode d'execution de la ligne de commande
    public void interpreter() throws cmdFalseException,ExpressionException{
        String[] TableCmd = new String[2];
        TableCmd=ligneCmd.split(" ",2);
        if((TableCmd[0].strip()).equals("let")){
            String[] TableLet = new String[2];
            if(!(TableCmd[1].contains("="))){ throw new ExpressionException();}
            TableLet=TableCmd[1].split("=",2);
            String stripedExpression= new String(TableLet[1].strip()); // enlever les espaces au debut et a la fin
            // make the expression lowerCase and replaceAll spaces with void
            Expression exp= new Expression((stripedExpression.replaceAll("\\s+", "")).toLowerCase());
            String StripedVarNom=TableLet[0].strip();
            Variable var = new Variable(StripedVarNom);// creation de la variable initialiser seuelement avec le nom
            CommandeLet cmd = new CommandeLet(var,exp);// creation de la commande let
            int ReturnValue = cmd.executer(this.table); // handle the exception or throw it
            if(ReturnValue==0){
                System.out.println("Ok");
            }
        }else{
            if ((TableCmd[0].strip()).equals("print")){
                String stripedExpression= new String(TableCmd[1].strip());
                Expression exp= new Expression((stripedExpression.replaceAll("\\s+", "")).toLowerCase());
                CommandePrint cmd= new CommandePrint(exp);// creation de la cmd print
                cmd.executer(this.table);
            }else{
                if((TableCmd[0].strip()).equals("end")){
                    CommandeEnd cmd = new CommandeEnd();
                    cmd.executer();
                }else{ throw new cmdFalseException();} // unhandled yet ,exception si la commande est fausse (n'existe pas)
            }
        }
    }
    // interpreter la ligne de commande et executer
    //en creant une instance de la classe commande qui convient et en appelant
    //sa methode executer

    // tester c'est la forme de la cmd est juste puis instancier la class qui convient puis




}
