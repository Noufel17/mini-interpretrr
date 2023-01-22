package Evaluation;

import Exceptions.ExpressionException;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import static java.lang.Math.pow;

public class Facteur implements Evaluable {
    private final String facteur;
    private List<Element> elementList= new ArrayList<>();

    public List<Element> extraire(String expression){
        // extraire must return elements and not strings
        String[] elements = expression.split("\\^(?![^\\(]*\\))");
        List<Element> elems = new ArrayList<>();
        for(String str : elements){
            elems.add(new Element(str));
        }
        return elems;
    }

    public Facteur(String facteur) {
        this.facteur = facteur;
    }

    // the new way
    @Override
    public double evaluer() throws Exception {
        double result = 1;
        this.elementList = extraire(this.facteur);
        Deque<Double> operandes = new LinkedList<Double>();
        for (Element element : elementList) {
            double operandeDouble = element.evaluer();
            operandes.push(operandeDouble);
        }
        if(!operandes.isEmpty()){
            result = operandes.pop();
        }
        while (!operandes.isEmpty()){
            result = Math.pow(operandes.pop(),result);
        }

        return result;
    }

//    @Override
//    public double evaluer() throws ExpressionException{
//
//        this.formerElements(facteur);
//
//        double valeur =0;
//        if (operateurList.size()>elementList.size()) {
//            throw new ExpressionException();
//        }
//        for(int i=0,j=(operateurList.size()==elementList.size())?0:-1;i<elementList.size()&&j<operateurList.size();i++,j++)
//        {
//            if(j>-1 && j==0) {
//                valeur = pow(valeur, elementList.get(i).evaluer());
//            }
//            else
//                valeur= elementList.get(i).evaluer();
//        }
//
//        return valeur;
//
//    }
//
//    public void formerElements(String expr) throws ParentheseManquanteException {
//        buffer=new String();
//
//        for(int i=0;i<expr.length();i++) {
//            if(expr.charAt(i)=='(') { // verifier les parentheses
//                while(!(expr.charAt(i)==')'||i==expr.length()-1)) { // this how to fix infinit loop
//                    if (i== expr.length()-1){throw new ParentheseManquanteException();} // may not be able to catch it since i throw ExpressionException too
//                    buffer+=expr.charAt(i);
//                    i++;
//                }
//                buffer+=expr.charAt(i);
//                elementList.add(new Element(buffer));
//                buffer=new String();
//            }
//            if (expr.charAt(i)=='^') {
//                operateurList.add(expr.charAt(i));
//                if (buffer.length()!=0) {
//                    elementList.add(new Element(buffer));
//                    buffer=new String();
//                }
//
//            }
//            else
//                buffer+=expr.charAt(i);
//        }
//        if (buffer.length()!=0)
//            elementList.add(new Element(buffer));
//    }
}

