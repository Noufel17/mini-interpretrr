package Handlers;

import Commandes.Commande;
import Commandes.CommandeEnd;

public class CommandeEndHandler extends CommandeHandler {
    public CommandeEndHandler() {
        this.motCle = "end";
    }

    @Override
    public void setNext(CommandeHandler handler) {
        this.next = handler;
    }

    @Override
    public boolean isMatched(String lignCmd) {
        return this.motCle.equals(lignCmd.split(" ")[0]);
    }

    @Override
    public Commande creerInstance(String lignCmd) {
        if (isMatched(lignCmd)){
            return new CommandeEnd();
        }else{
            return next.creerInstance(lignCmd);
        }
    }

}
