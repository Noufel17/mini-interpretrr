package TP;
import Commandes.*;
import Evaluation.*;
import Exceptions.*;
import Symboles.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Interpreteur i = new Interpreteur();
        while (true) {
            try{
                System.out.print(">>> ");
                Scanner scan= new Scanner(System.in);
                String ligneDeCmd=scan.nextLine();// lire la commande
                i.interpreter(ligneDeCmd);
            } catch (ParentheseManquanteException e1) {
                System.err.println(e1);
            } catch (cmdFalseException e2) {
                System.err.println(e2);
            } catch (ExpressionException e3) {
                System.err.println(e3);
            }catch(Exception exp){
                System.err.println(exp);
            }
        }
    }
}
