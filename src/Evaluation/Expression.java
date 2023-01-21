package Evaluation;

import Evaluation.*;
import Exceptions.*;
import Symboles.NomFonction;
import TP.*;

import java.util.ArrayList;
import java.util.List;

public class Expression implements Evaluable {
    private String expression;
    private List<Term> termList= new ArrayList<>();
    private List<Character> OperateurList= new ArrayList<>();
    private String buffer;

    public Expression(String expression) {
        this.expression = expression;
    }

    public double evaluer(TableSymbole table) throws ExpressionException{
        // verification des parentheses
        /*int ouvr=0,ferm=0;
        for (int k = 0; k < expression.length(); k++) {
             expression.charAt(k);
            if (expression.charAt(k)=='(')
                ouvr++;
        }
        for (int k = 0; k < expression.length(); k++) {
            expression.charAt(k);
            if (expression.charAt(k)==')')
                ferm++;
        }
        if(ferm>ouvr){
            throw new ParentheseOuvranteException();
        }else{ if(ouvr>ferm){throw new ParentheseFermanteException();}}*/
        // replace variables and functions by their values
        String[] SplittedExpression = this.expression.split("((?<=\\+|-|\\*|\\^|/|sqrt|cos|sin|tan|abs|log|\\(|\\))|(?=\\+|-|\\*|\\^|/|sqrt|cos|sin|tan|abs|log|\\(|\\)))");
        /*(for(String str: SplittedExpression){
            System.out.println(str);
        }*/
        StringBuilder stringBuilder = new StringBuilder(100);
        for(int i=0;i<SplittedExpression.length;i++){
            String str= SplittedExpression[i];
            if((str.matches("\\+|-|\\*|/|\\^|\\)|\\(")) || (Character.isDigit(str.charAt(0)))){ //un operateur ou un nombre
                stringBuilder.append(str);
            }
            else{
                if(str.matches("sqrt|cos|sin|tan|abs|log")){ // une fonction
                    i+=1;
                    if(!(SplittedExpression[i].equals("("))){ throw new ParentheseManquanteException();} // parethese ouvrante de la fonction
                    stringBuilder.append(SplittedExpression[i]);
                    String str2= new String("");
                    i++;
                    if(SplittedExpression[i].matches("sqrt|cos|sin|tan|abs|log")){ // c'est une autre fonction
                        str2+=SplittedExpression[i];// le nom de la fonction
                        i++;
                        if(!(SplittedExpression[i].equals("("))){ throw new ParentheseManquanteException();} // parethese ouvrante de la fonction
                        while(!(SplittedExpression[i].equals(")")||i==SplittedExpression.length-1)){
                            if(i==SplittedExpression.length-1){throw new ParentheseManquanteException();}
                            str2+=SplittedExpression[i];// l'expression en arguement
                            i++;
                        }
                        str2+=SplittedExpression[i];// la parethese fermante est essentielle ici
                        Expression exp= new Expression(str2);
                        double result= exp.evaluer(table);// evaluer le parametre de la fonction

                    }else{ // expression normale
                        while(!(SplittedExpression[i].equals(")")||i==SplittedExpression.length-1)){
                            if(i==SplittedExpression.length-1){throw new ParentheseManquanteException();}
                            str2+=SplittedExpression[i];
                            i++;
                        }
                    }
                    Expression s_expr= new Expression(str2);
                    try {
                        // expression erronee
                        stringBuilder.append(table.getFunctionValue(str, s_expr.evaluer(table))); // evaluer l'expression de la fonction puis la metter dans la nouvelle chaine
                    }catch(LogException e1){
                        System.out.println(e1);
                    }
                    catch(SqrtException e2){
                        System.out.println(e2);
                    }
                    catch(PasUneFonctionException e3){
                        System.out.println(e3);
                    }
                    catch(ParentheseManquanteException e4){
                        System.out.println(e4);
                    }catch(SymboleFunNexistePas e5){
                        System.out.println(e5);
                    }
                    stringBuilder.append(SplittedExpression[i]);// la parethese fermante de la fonction
                }else{ // c'est une variable hopefully
                    try{
                        stringBuilder.append(table.getVariableValue(str));// remplacer la variable par sa valeur
                    }catch(SymboleVarNexistePas e){
                        System.out.println(e);
                    }
                }
            }

        }
        String theNewExpression= stringBuilder.toString();// contien la nouvelle chaine avec soulement des nombres nchlh donc on va l'evaluer

        // partie evaluation
        this.formerTermes(theNewExpression);
        double valeur =0;

        if (OperateurList.size()>termList.size()) {
            throw new ExpressionException();
        }

        for(int i=0,j=(OperateurList.size()==termList.size())?0:-1;i<termList.size()&&j<OperateurList.size();i++,j++)
        {
            //termList.get(i).verifier(); // definir verifier dans term
            if (j>-1 && j==0) { // donc il'ya un mois au debut ou expression erronee
                valeur=(OperateurList.get(j)=='-')?(valeur-termList.get(i).evaluer(table)):valeur+termList.get(i).evaluer(table);
            }
            else // sinon on ajoute le premier terme
            {
                valeur=valeur+termList.get(i).evaluer(table);
            }
        }
        return valeur;
    }

    public void formerTermes(String expr) throws ParentheseManquanteException{
        buffer=new String();

        for(int i=0;i<expr.length();i++) {// ya ne7i les parentheses direct ya traitihm hna
            if(expr.charAt(i)=='(') {

                while(!((expr.charAt(i)==')') || (i==(expr.length()-1)))) {
                    if (i== expr.length()-1){throw new ParentheseManquanteException();}
                    buffer+=expr.charAt(i);
                    i++;
                }

                buffer+=expr.charAt(i);
                termList.add(new Term(buffer));
                buffer=new String();
                i++;
            }
            else{
                if (expr.charAt(i)=='-' ||expr.charAt(i)=='+') {
                     OperateurList.add(expr.charAt(i));
                     if (buffer.length() != 0) {
                         termList.add(new Term(buffer));
                         buffer = new String();
                    }
                }else{ buffer += expr.charAt(i);}
            }
        }
        if (buffer.length()!=0)
            termList.add(new Term(buffer));
    }

}
