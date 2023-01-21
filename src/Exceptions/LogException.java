package Exceptions;

public class LogException extends ExpressionException{
    @Override
    public String toString() {
        return "la variable ou la constante dans le logarithme est de signe négatif";
    }
}
