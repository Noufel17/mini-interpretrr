package Commandes;

public class CommandeEnd implements Commande{
    public int executer(String lignCmd){
        System.out.println("Fin du programme");
        System.exit(0);
        return 0;
    }// finaliser l'execution
}
