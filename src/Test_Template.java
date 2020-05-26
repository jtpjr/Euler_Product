import com.udojava.evalex.Expression;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Test_Template {
    public static void main(String[] args) throws IOException {
        Prime_Calculator primeCalc = new Prime_Calculator();
        ArrayList<Integer> primes = primeCalc.getFirst10MilPrimes();
        Export_to_Text exporter = new Export_to_Text();

        Expression_Builder expressionBuilder = new Expression_Builder();

        Convergence_Tester convergenceTester = new Convergence_Tester();

        final int PRECISION = 500;

        // final int NUM_EXPRESSIONS_TO_TEST = 5;


        // inital test of formula, increasing primes

        MathContext m = new MathContext(PRECISION);

        while (true) {
            String expressionString = expressionBuilder.getExpression();
            Expression expression = new Expression(expressionString, m);

            BigDecimal answer = BigDecimal.valueOf(1);

            double secondaryTest1 = 0, secondaryTest2;
            DecimalFormat decimalFormat = new DecimalFormat("#.#");


            System.out.println("-----------------------");
            System.out.println(expressionString);

            if (convergenceTester.isConvergent(expressionString, m)) {

                for (int i = 0; i < primes.size(); i++) {
                    BigDecimal p = BigDecimal.valueOf(primes.get(i));
                    //parenthetical = 1+(1/Math.pow(p, 3));;
                    expression.with("p", p);

                    try {
                        answer = answer.multiply(expression.eval(), m);
                    } catch (ArithmeticException | Expression.ExpressionException arithmeticException) {
                        System.out.println(arithmeticException);

                        System.out.println("-----------------------");
                        break;
                    }


                    if (i == 100000) {
                        secondaryTest1 = Double.parseDouble(decimalFormat.format(answer.doubleValue()));
                        
                    }
                    
                    if (i == 9000000) {
                        secondaryTest2 = Double.parseDouble(decimalFormat.format(answer.doubleValue()));
                        
                        if (Math.abs(secondaryTest1 - secondaryTest2) > 0.1) {
                            break;
                        }
                    }
                    
                    
                    if (i % 100000 == 0) {
                        System.out.println(i + " | " + answer);
                    }
                }

                System.out.println("\nAnswer: " + answer.toString());
                System.out.println(expressionString + "\n");

                exporter.Export_to_Text(expressionString, answer);

                System.out.println("-----------------------");
            }
        }
    }
}
