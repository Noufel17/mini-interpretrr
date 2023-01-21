package Exceptions;

public class SqrtException extends ExpressionException{
    @Override
    public String toString() {
        return "la variable ou le nombre dans la fonction racine carée est négatif";
    }
}
