package Exceptions;

public class VarNomfauxException extends VarException{
    @Override
    public String toString() {
        return "le nom de la variable n'est pas acceptable (doit commancer par une lettre)";
    }
}
