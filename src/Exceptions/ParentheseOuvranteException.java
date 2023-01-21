package Exceptions;

public class ParentheseOuvranteException extends ExpressionException {
    @Override
    public String toString() {
        return "Parethese ouvrante manquante";
    }
}
