import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class Test_Formula_2_10k_BigDecimal {
    public static void main(String[] args) throws IOException {
        Prime_Calculator primeCalc = new Prime_Calculator();
        ArrayList<Integer> primes = primeCalc.get10kPrimes();

        MathContext m = new MathContext(10000);


        // inital test of formula, increasing primes

        BigDecimal parenthetical;
        BigDecimal numerator = BigDecimal.valueOf(1);
        BigDecimal denominator;
        BigDecimal answer = BigDecimal.valueOf(1);

        for (int i = 0; i < primes.size(); i++) {
            double p = primes.get(i);
            BigDecimal primeBD = BigDecimal.valueOf(p);
            //parenthetical = 1+(1/Math.pow(p, 3));;

            denominator = primeBD.pow(3, m);
            parenthetical = (BigDecimal.valueOf(1)).add(numerator.divide(denominator, m), m);

            answer = answer.multiply(parenthetical, m);
            System.out.println(i + " | " + answer.toString());
        }

        System.out.println("\nAnswer: " + answer.toString());

    }
}
