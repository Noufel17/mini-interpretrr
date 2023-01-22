package Handlers;

import Commandes.Commande;

public abstract class CommandeHandler {
    CommandeHandler next;
    String motCle;

    public abstract void setNext(CommandeHandler handler);
    public abstract boolean isMatched(String lignCmd);
    public abstract Commande creerInstance();
}
