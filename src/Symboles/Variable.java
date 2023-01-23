package Symboles;

import Exceptions.VarNomCmdException;
import Exceptions.VarNomFctException;
import Exceptions.VarNomfauxException;

public class Variable extends Symbole {
    private double valeur;

    public Variable(String nom) {
        this.nom=nom;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public boolean verifierNom() throws VarNomCmdException, VarNomfauxException, VarNomFctException {
        // dont forget si le nom de la var existe deja dans la table on l'ecrase
        boolean NomJuste = false;
        if (this.nom.equals("let") || this.nom.equals("print") || this.nom.equals("end")) {
            throw new VarNomCmdException();
        } else {
                char ch = this.nom.charAt(0);
                if (Character.isDigit(ch)) { // test de la forme du nom du variable
                    throw new VarNomfauxException();
                } else {
                    NomJuste = true;
                }
            return NomJuste;
        }// pour verifier si
        // le nom est valable(ecrit sous la forme alphanumerique, commance avec
        // une lettre et different des noms du commandes et du fonctions)
    }
}
