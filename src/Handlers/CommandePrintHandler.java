package Handlers;

import Commandes.Commande;
import Commandes.CommandeEnd;
import Commandes.CommandePrint;

public class CommandePrintHandler extends CommandeHandler {
    @Override
    public void setNext(CommandeHandler handler) {
        this.next = handler;
    }

    @Override
    public boolean isMatched(String lignCmd) {
        return this.motCle.equals(lignCmd.split(" ")[0]);
    }

    @Override
    public Commande creerInstance() {
        return new CommandePrint();
    }
}
