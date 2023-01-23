package Evaluation;

import Exceptions.*;

import java.util.*;

public class Term implements Evaluable{
    private final String term;
    public Term(String term) {
        this.term = term;
    }

    public String [] extraire(String expression){
        return expression.split("(?=[\\*\\/](?![^\\(]*\\)))|(?<=[\\*\\/](?![^\\(]{0,99}\\)))");
    }

    // the new way
    @Override
    public double evaluer() throws Exception{
        double result = 1;
         String [] facteursEtOperateurs = extraire(this.term);
        Deque<Double> facteurs = new LinkedList<>();
        Deque<String> operateurs = new LinkedList<>();
        for (String str : facteursEtOperateurs) {
            if(str.trim().equals("*") || str.trim().equals("/")){
                operateurs.addLast(str.trim());
            }else{
                Facteur operandeDouble = new Facteur(str.trim());
                facteurs.addLast(operandeDouble.evaluer());
            }
        }
        if(!facteurs.isEmpty()){
            result = facteurs.pop();
        }
        while (!operateurs.isEmpty()){
            String operateur = operateurs.pop();
            double operande=1;
            try {
                operande = facteurs.pop();
            }catch (NoSuchElementException e){
                throw new ExpressionException();
            }

            if(operateur.equals("*")){
                result = result * operande;
            }else if (operateur.equals("/")){
                if(operande != 0)
                    result = result / operande;
                else
                    throw new ArithmeticException("Division par 0");
            }
        }

        return result;
    }
}
