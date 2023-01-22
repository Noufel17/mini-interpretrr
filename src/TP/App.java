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
            try{
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
