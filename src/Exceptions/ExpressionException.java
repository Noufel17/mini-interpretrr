package Exceptions;

public class ExpressionException extends Exception{
    @Override
    public String toString() {
        return "Expression erronée";
    }
}
