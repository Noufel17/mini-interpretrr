package Exceptions;

public class SymboleVarNexistePas extends SymboleException{
    @Override
    public String toString() {
        return "Variable non declarée";
    }
}
