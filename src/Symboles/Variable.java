package Symboles;

import Exceptions.VarNomCmdException;
import Exceptions.VarNomFctException;
import Exceptions.VarNomfauxException;
import Symboles.Symbole;

public class Variable extends Symbole {
    // instance variables - replace the example below with your own
    private String nom;
    private double valeur;

    public Variable(String nom) {
        this.nom = nom;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public String getNom() {
        return nom;
    }

    public boolean verifierNom() throws VarNomCmdException, VarNomfauxException, VarNomFctException {
        // dont forget si le nom de la var existe deja dans la table on l'ecrase
        boolean NomJuste = false;
        if (this.nom.equals("let") || this.nom.equals("print") || this.nom.equals("end")) {
            throw new VarNomCmdException();
        } else {
            if (this.nom.matches("cos|sin|tan|log|sqrt|abs")) {
                throw new VarNomFctException();
            } else {
                char ch = this.nom.charAt(0);
                if (Character.isDigit(ch)) { // test de la forme du nom du variable
                    throw new VarNomfauxException();
                } else {
                    NomJuste = true;
                }
            }
            return NomJuste;
        }// pour verifier si
        // le nom est valable(ecrit sous la forme alphanumerique, commance avec
        // une lettre et different des noms du commandes et du fonctions)
    }
}
