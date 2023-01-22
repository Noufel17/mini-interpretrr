package Evaluation;

import TP.TableSymbole;

public class Element implements Evaluable{
    private final String element;

    public Element(String element) {
        this.element = element;
    }

    @Override
    public String [] extraire(String expression){
        return null;
    }

    public double evaluer() {
        String elem=element.replaceAll("\\(|\\)","");
        return Double.parseDouble(elem);
    }
}
