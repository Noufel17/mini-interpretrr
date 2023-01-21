package TP;
import Commandes.*;
import Evaluation.*;
import Exceptions.*;
import Symboles.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Interpreteur i = new Interpreteur();
        boolean stop = false;
        while (!stop) {
            try {
                // ajout des fonctions standards au tableau des symboles
                Function f1 = new Function(NomFonction.cos);
                i.getTable().ajouter(f1);
                Function f2 = new Function(NomFonction.sin);
                i.getTable().ajouter(f2);
                Function f3 = new Function(NomFonction.tan);
                i.getTable().ajouter(f3);
                Function f4 = new Function(NomFonction.log);
                i.getTable().ajouter(f4);
                Function f5 = new Function(NomFonction.sqrt);
                i.getTable().ajouter(f5);
                Function f6 = new Function(NomFonction.abs);
                i.getTable().ajouter(f6);
                // examples jeux d'essai hadou li kunt njreb bihm
            /*i.setLigneCmd("let y=-5");
            i.interpreter();
            i.setLigneCmd("let x2=-2");
            i.interpreter();
            i.setLigneCmd("print abs(x2)+sin(y)");// juste
            i.interpreter();
            i.setLigneCmd("print sin(sqrt(abs(y)))");// juste
            i.interpreter();*/

                System.out.print(">>> ");
                Scanner scan= new Scanner(System.in);
                String ligneDeCmd=scan.nextLine();// lire la commande
                i.setLigneCmd(ligneDeCmd);
                i.interpreter();
            } catch (ParentheseManquanteException e1) {
                System.err.println(e1);
                stop=true;
            } catch (cmdFalseException e2) {
                System.err.println(e2);
                stop=true;
            } catch (ExpressionException e3) {
                System.err.println(e3);
                stop=true;
            }catch(Exception exp){
                stop=true;
            }
        }
    }
}
