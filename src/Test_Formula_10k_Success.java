import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class Test_Formula_10k_Success {
    public static void main(String[] args) throws IOException {
        Prime_Calculator primeCalc = new Prime_Calculator();
        ArrayList<Integer> primes = primeCalc.getFirst10MilPrimes();

        MathContext m = new MathContext(1000);


        // inital test of formula, increasing primes

        BigDecimal parenthetical;
        BigDecimal numerator = BigDecimal.valueOf(1);
        BigDecimal denominator;
        BigDecimal answer = BigDecimal.valueOf(1);

        for (int i = 0; i < primes.size(); i++) {
            double p = primes.get(i);
            BigDecimal primeBD = BigDecimal.valueOf(p);
            //parenthetical = 1+(1/Math.pow(p, 3));;

            denominator = primeBD.pow(2, m);

            parenthetical = BigDecimal.valueOf(1).add(numerator.divide(denominator, m), m);

            answer = answer.multiply(parenthetical, m);
            if (i%10000 == 0) {
                System.out.println(i + " | " + answer);
            }
        }

        System.out.println("\nAnswer: " + answer.toString());

    }
}
