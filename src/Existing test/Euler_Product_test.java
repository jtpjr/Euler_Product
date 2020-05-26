import java.io.IOException;
import java.util.ArrayList;

public class Euler_Product_test {
    public static void main(String[] args) throws IOException {
        Prime_Calculator primeCalc = new Prime_Calculator();
        ArrayList<Integer> primes = primeCalc.getPrimes();

        double answer;
        double numerator = 1;
        double denominator = 1;

        for (int i = 0; i < primes.size(); i++) {
            double p = primes.get(i);
            denominator = denominator*(1-(1/(Math.pow(p, 2))));
        }

        answer = numerator/denominator;

        System.out.println(answer);

        //      1
        // ----------------
        //   (1-(1/(p)^2)...
    }
}
