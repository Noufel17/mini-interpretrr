package Handlers;

import Commandes.Commande;
import Commandes.CommandeLet;

public class CommandeLetHandler extends CommandeHandler{
    public CommandeLetHandler() {
        this.motCle = "let";
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
            return new CommandeLet();
        }else{
         return next.creerInstance(lignCmd);
        }
    }
}
