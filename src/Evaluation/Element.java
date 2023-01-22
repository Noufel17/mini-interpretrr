package Evaluation;

import Exceptions.*;
import Symboles.Function;
import Symboles.Variable;
import TP.TableSymbole;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Element implements Evaluable{
    private final String element;

    public Element(String element) {
        this.element = element;
    }


    @Override
    public double evaluer() throws Exception {

        try{
            double number = Double.parseDouble(element);
            return number;
        }catch(NumberFormatException e){
            //fonction standanrd
            Pattern pattern = Pattern.compile("^([A-Za-z ]+\\(.*?\\))");
            Matcher matcher = pattern.matcher(element);
            if (matcher.find()) {
                //verify function name is lowercase
                pattern = Pattern.compile("^([a-z ]+)(?=\\(.*?\\))");
                matcher = pattern.matcher(element);
                if(matcher.find()){
                    String functionName = matcher.group().trim();
                    Function function = (Function) TableSymbole.getInstance().getFunction(functionName);
                    pattern = Pattern.compile("((?<=\\().*(?=\\)))");
                    matcher = pattern.matcher(element);
                    if(matcher.find()){
                        if(function==null) {throw new SymboleFunNexistePas();}
                        Expression exp = new Expression(matcher.group());
                        return function.evaluer(exp.evaluer());
                    }else {
                        throw new ExpressionException();
                    }
                }else{
                    pattern = Pattern.compile("^([A-Za-z ]+)(?=\\(.*?\\))");
                    matcher = pattern.matcher(element);
                    if(matcher.find())
                        throw new SymboleFunNexistePas();
                    else
                        throw new ExpressionException();
                }

            }else{
                //variable name
                pattern = Pattern.compile("^(\\b[A-Za-z0-9_]*\\b)$");
                matcher = pattern.matcher(element);
                if (matcher.find()) {
                    pattern = Pattern.compile("^(\\b[a-z][A-Za-z0-9_]*\\b)");
                    matcher = pattern.matcher(element);
                    if (!matcher.find()) {
                        throw new SymboleVarNexistePas();
                    }else {
                        try{
                            Double variable = TableSymbole.getInstance().getVariable(matcher.group().trim()).getValeur();
                            return variable;
                        }
                        catch(Exception e2) {
                            throw new VarException();
                        }
                    }
                }
                else{
                    //expression
                    pattern = Pattern.compile("((?<=\\().*(?=\\)))");
                    matcher = pattern.matcher(element);
                    if (matcher.find()) {
                        Expression exp = new Expression(matcher.group());
                        return exp.evaluer();
                    }else{
                        //general errors
                        pattern = Pattern.compile("(?=\\()[^\\)]*$");
                        matcher = pattern.matcher(element);
                        if(matcher.find())
                            throw new ParentheseFermanteException();
                        pattern = Pattern.compile("^[^\\(]+(?=\\))");
                        matcher = pattern.matcher(element);
                        if(matcher.find())
                            throw new ParentheseOuvranteException();
                        else
                            throw new ExpressionException();
                    }
                }
            }
        }
    }
}
