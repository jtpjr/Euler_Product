import com.udojava.evalex.Expression;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Convergence_Tester {
    public boolean isConvergent(String inputExpression, MathContext m) throws IOException {
        Expression expression = new Expression(inputExpression, m);
        Prime_Calculator primeCalculator = new Prime_Calculator();
        ArrayList<Integer> primes = primeCalculator.getPrimes();

        double testpoint1 = 0, testpoint2;

        BigDecimal answer = BigDecimal.valueOf(1);

        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        for (int i = 0; i < primes.size(); i++) {
            BigDecimal p = BigDecimal.valueOf(primes.get(i));
            expression.with("p", p);

            try {
                answer = answer.multiply(expression.eval(), m);
            } catch (ArithmeticException | Expression.ExpressionException arithmeticException) {
                System.out.println(arithmeticException);
                return false;
            }

            if (i == 100) {
                try {
                    testpoint1 = Double.parseDouble(decimalFormat.format(answer.doubleValue()));
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException);
                    return false;
                }
            }
        }

        try {
            testpoint2 = Double.parseDouble(decimalFormat.format(answer.doubleValue()));
        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException);
            return false;
        }

        if (Math.abs(testpoint1 - testpoint2) > 0.1 || testpoint2 == 1 || testpoint2 <= 0) {
            System.out.println(testpoint1 + " != " + testpoint2);
            System.out.println("NOT CONVERGENT");
            return false;
        } else return true;
    }
}