package TP;

import Commandes.Commande;
import Exceptions.*;
import Handlers.CommandeEndHandler;
import Handlers.CommandeHandler;
import Handlers.CommandeLetHandler;
import Handlers.CommandePrintHandler;

public class Interpreteur {

private final CommandeHandler firstHandler;

    public Interpreteur() {
        CommandeHandler letHandler  = new CommandeLetHandler();
        CommandeHandler printHandler  = new CommandePrintHandler();
        CommandeHandler endHandler  = new CommandeEndHandler();
        letHandler.setNext(printHandler);
        printHandler.setNext(endHandler);
        this.firstHandler = letHandler;
    }

    // la methode d'execution de la ligne de commande
    public void interpreter(String ligneCmd) throws Exception {
        Commande cmd = firstHandler.creerInstance(ligneCmd);
        if(cmd == null){
            throw new cmdFalseException();
        }
        cmd.executer(ligneCmd);
    }
}
