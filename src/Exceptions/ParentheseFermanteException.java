package Exceptions;

public class ParentheseFermanteException extends ExpressionException {
    @Override
    public String toString() {
        return "parenthese fermante manquante";
    }
}
