package Exceptions;

public class PasUneFonctionException extends ExpressionException{
    @Override
    public String toString() {
        return "Le nom d'une fonction est erroné";
    }
}
