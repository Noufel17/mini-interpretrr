package Symboles;
import java.lang.Math;
import Exceptions.*;

public abstract class Function extends Symbole {

    public String getNom(){
        return this.nom;
    }
    public abstract double evaluer(double param) throws LogException, SqrtException, PasUneFonctionException;
    // nice try catch for executing functions might be needed later
//        try {
//
//        }catch(LogException exp1){
//            System.out.println(exp1);
//        }catch(SqrtException exp2){
//            System.out.println(exp2);
//        }catch(PasUneFonctionException exp3){
//            System.out.println(exp3);
//        }
//
//        return 0;
}