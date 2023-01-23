package Evaluation;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression implements Evaluable {
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public String [] extraire(String expression){
        return expression.split("(?=[\\+\\-](?![^\\(]*\\)))|(?<=[\\+\\-](?![^\\(]{0,99}\\)))");}

// the new way

    @Override
    public double evaluer() throws Exception{

        Pattern pattern = Pattern.compile("((?<=^\\().*(?=\\)$))");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            Expression exp = new Expression(matcher.group());
            return exp.evaluer();
        }else {

            int multipler = 1;
            double result = 0;

            String[] termesEtOperandes = extraire(expression);
            Deque<Double> operandes = new LinkedList<>();
            for (String operande : termesEtOperandes) {
                if (operande.trim().equals("+") || operande.trim().equals("-")) {
                    if (operande.trim().equals("-"))
                        multipler = multipler * -1;
                } else {
                    Term term = new Term(operande.trim());
                    double operandeDouble = term.evaluer();
                    operandes.addLast(multipler * operandeDouble);
                    multipler = 1;
                }
            }

            while (!operandes.isEmpty()) {
                result = result + operandes.pop();
            }

            return result;
        }
    }
}
