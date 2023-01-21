package Evaluation;

import TP.TableSymbole;

public class Element implements Evaluable{
    private String element;

    public Element(String element) {
        this.element = element;
    }

    public double evaluer(TableSymbole Table) {
        String elem=element.replaceAll("\\(|\\)",""); //  chouf kifch tregliha mn la boucle li traiter les parentheses
        return Double.parseDouble(elem); // on est sure que c'est un nombre
        // voir si il est necessaire de metter des exceptions ici
    }
}
