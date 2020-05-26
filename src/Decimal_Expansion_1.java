import com.udojava.evalex.Expression;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class Decimal_Expansion_1 {
    public static void main(String[] args) throws IOException {
        Prime_Calculator primeCalc = new Prime_Calculator();
        ArrayList<Integer> primes = primeCalc.getFirst50MilPrimes();

        System.out.println(primes.size());

        MathContext m = new MathContext(1000);

        String expressionString = "1+(6/p^2)";
        Expression expression = new Expression(expressionString, m);


        BigDecimal answer = BigDecimal.valueOf(1);

        for (int i = 0; i < primes.size(); i++) {
            BigDecimal p = BigDecimal.valueOf(primes.get(i));

            expression.with("p", p);


            answer = answer.multiply(expression.eval(), m);
            if (i%10000 == 0) {
                System.out.println(i + " | " + answer);
            }
        }

        System.out.println("\nAnswer: " + answer.toString());

    }
}
