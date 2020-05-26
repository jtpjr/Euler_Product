import java.io.IOException;
import java.util.ArrayList;

public class Test_Formula_2_10k {
    public static void main(String[] args) throws IOException {
        Prime_Calculator primeCalc = new Prime_Calculator();
        ArrayList<Integer> primes = primeCalc.get10kPrimes();


        // inital test of formula, increasing primes

        double parenthetical;
        double answer = 1;

        for (int i = 0; i < primes.size(); i++) {
            double p = primes.get(i);
            parenthetical = 1+(1/Math.pow(p, 3));;
            answer = answer * parenthetical;
            System.out.println(i + " | " + answer);
        }

        System.out.println("\nAnswer: " + answer);

    }
}
