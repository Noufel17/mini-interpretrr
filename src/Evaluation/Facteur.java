package Evaluation;

import Exceptions.ExpressionException;
import Exceptions.ParentheseManquanteException;
import TP.TableSymbole;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.pow;

public class Facteur {
    private String facteur;
    private List<Element> elementList= new ArrayList<>();
    private List<Character> operateurList= new ArrayList<>();
    private String buffer;

    public Facteur(String facteur) {
        this.facteur = facteur;
    }

    public double evaluer(TableSymbole table) throws ExpressionException{

        this.formerElements(facteur);

        double valeur =0;
        if (operateurList.size()>elementList.size()) {
            throw new ExpressionException();
        }
        for(int i=0,j=(operateurList.size()==elementList.size())?0:-1;i<elementList.size()&&j<operateurList.size();i++,j++)
        {
            if(j>-1 && j==0) {
                valeur = pow(valeur, elementList.get(i).evaluer(table));
            }
            else
                valeur= elementList.get(i).evaluer(table);
        }

        return valeur;

    }

    public void formerElements(String expr) throws ParentheseManquanteException {
        buffer=new String();

        for(int i=0;i<expr.length();i++) {
            if(expr.charAt(i)=='(') { // verifier les parentheses
                while(!(expr.charAt(i)==')'||i==expr.length()-1)) { // this how to fix infinit loop
                    if (i== expr.length()-1){throw new ParentheseManquanteException();} // may not be able to catch it since i throw ExpressionException too
                    buffer+=expr.charAt(i);
                    i++;
                }
                buffer+=expr.charAt(i);
                elementList.add(new Element(buffer));
                buffer=new String();
            }
            if (expr.charAt(i)=='^') {
                operateurList.add(expr.charAt(i));
                if (buffer.length()!=0) {
                    elementList.add(new Element(buffer));
                    buffer=new String();
                }

            }
            else
                buffer+=expr.charAt(i);
        }
        if (buffer.length()!=0)
            elementList.add(new Element(buffer));
    }
}

