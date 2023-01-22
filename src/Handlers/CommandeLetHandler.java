package Handlers;

import Commandes.Commande;
import Commandes.CommandeLet;

public class CommandeLetHandler extends CommandeHandler{
    private final String motCle = "let";
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
        return new CommandeLet();
    }
}
