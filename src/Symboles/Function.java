package Symboles;
import java.lang.Math;
import Exceptions.*;
import Symboles.NomFonction;

public class Function extends Symbole{
    private NomFonction nom;

    public Function(NomFonction nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom.name();
    }

    public double evaluer(double param) throws LogException, SqrtException, PasUneFonctionException{
        try {
            switch (this.nom) {
                case abs:
                    return Math.abs(param);// defined on R

                case sin:
                    return Math.sin(param);// defined on R

                case cos:
                    return Math.cos(param);// defined on R

                case tan:
                    return Math.tan(param);// defined on R

                case log:
                    Double res = Math.log(param);
                    if(res.isNaN()){
                        throw new LogException();
                    }else{return res;}

                case sqrt:
                    res = Math.sqrt(param);
                    if(res.isNaN()){
                        throw new SqrtException();
                    }else{return res;}

                default:
                    throw new PasUneFonctionException();

            }
        }catch(LogException exp1){
            System.out.println(exp1);
        }catch(SqrtException exp2){
            System.out.println(exp2);
        }catch(PasUneFonctionException exp3){
            System.out.println(exp3);
        }

        return 0;
    }// role: retourne l'image du parametre par la focntion spécifiée par son nom


}
