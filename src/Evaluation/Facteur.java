package Evaluation;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Facteur implements Evaluable {
    private final String facteur;

    public String [] extraire(String expression){
        return expression.split("\\^(?![^\\(]*\\))");
    }

    public Facteur(String facteur) {
        this.facteur = facteur;
    }

    // the new way
    @Override
    public double evaluer() throws Exception {
        double result = 1;
        String [] elementList = extraire(this.facteur);
        Deque<Double> operandes = new LinkedList<Double>();
        for (String element : elementList) {
            Element elem = new Element(element);
            double operandeDouble = elem.evaluer();
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
}

