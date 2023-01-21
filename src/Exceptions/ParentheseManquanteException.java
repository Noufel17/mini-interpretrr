package Exceptions;

public class ParentheseManquanteException extends ExpressionException{
    @Override
    public String toString() {
        return "Il y a une parenthése manquante dans l'expression";
    }
}
