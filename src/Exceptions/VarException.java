package Exceptions;

public class VarException extends Exception{
    @Override
    public String toString() {
        return "Variable non déclarée";
    }
}
