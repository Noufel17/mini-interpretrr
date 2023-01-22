package Handlers;

import Commandes.Commande;
import Commandes.CommandePrint;

public class CommandePrintHandler extends CommandeHandler {
    public CommandePrintHandler() {
        this.motCle = "print";
    }

    @Override
    public void setNext(CommandeHandler handler) {
        this.next = handler;
    }

    @Override
    public boolean isMatched(String lignCmd) {
        String cmd = lignCmd.split(" ")[0];
        return this.motCle.equals(cmd);
    }

    @Override
    public Commande creerInstance(String lignCmd) {
        if (isMatched(lignCmd)){
            return new CommandePrint();
        }else{
            return next.creerInstance(lignCmd);
        }
    }
}
