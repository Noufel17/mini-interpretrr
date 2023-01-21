package Evaluation;

import Exceptions.*;
import TP.TableSymbole;

import java.util.ArrayList;
import java.util.List;

public class Term {
    private String term;
    private String buffer;
    private List<Facteur> facteurList= new ArrayList<>();
    private List<Character> operateurList= new ArrayList<>();
    public Term(String term) {
        this.term = term;
    }

    public double evaluer(TableSymbole table) throws ExpressionException{

        this.formerFacteurs(term);

        double valeur =0;
        if (operateurList.size()>facteurList.size()) {
            throw new ExpressionException();
        }
        for(int i=0,j=(operateurList.size()==facteurList.size())?0:-1;i<facteurList.size()&&j<operateurList.size();i++,j++)
        {
            if (j>-1 && j==0) {
                valeur=(operateurList.get(j)=='*')?(valeur*facteurList.get(i).evaluer(table)):valeur/facteurList.get(i).evaluer(table);
            }
            else
            {
                valeur=facteurList.get(i).evaluer(table);// pour lui faire multiplier apres , c'est le premier
            }
        }

        return valeur;

    }

    public void formerFacteurs(String expr) throws ParentheseManquanteException {
        buffer=new String();

        for(int i=0;i<expr.length();i++) {
            if(expr.charAt(i)=='(') { // verifier les parentheses
                while(!(expr.charAt(i)==')'||i==expr.length()-1)) { // this how to fix infinit loop
                    if (i== expr.length()-1){throw new ParentheseManquanteException();} // may not be able to catch it since i throw ExpressionException too
                    buffer+=expr.charAt(i);
                    i++;
                }
                buffer+=expr.charAt(i);
                facteurList.add(new Facteur(buffer));
                buffer=new String();
            }
            if (expr.charAt(i)=='*' ||expr.charAt(i)=='/') {
                operateurList.add(expr.charAt(i));
                if (buffer.length()!=0) {
                    facteurList.add(new Facteur(buffer));
                    buffer=new String();
                }

            }
            else
                buffer+=expr.charAt(i);
        }
        if (buffer.length()!=0)
            facteurList.add(new Facteur(buffer));
    }
}
