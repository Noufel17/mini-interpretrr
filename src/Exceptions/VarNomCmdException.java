package Exceptions;

public class VarNomCmdException extends VarException {
    @Override
    public String toString() {
        return "le nom de variable corrispand a une commande";
    }
}
