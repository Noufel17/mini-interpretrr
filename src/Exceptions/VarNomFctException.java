package Exceptions;

public class VarNomFctException extends VarException{
    @Override
    public String toString() {
        return "le nom de la variable correspand a une fonction ";
    }
}
