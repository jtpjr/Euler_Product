import java.io.IOException;
import java.util.ArrayList;

public class Artin_Constant_test {
    public static void main(String[] args) throws IOException {
        Prime_Calculator primeCalc = new Prime_Calculator();
        ArrayList<Integer> primes = primeCalc.getPrimes();

        double parenthetical;
        double answer = 1;

        for (int i = 0; i < primes.size(); i++) {
            double p = primes.get(i);
            parenthetical = 1 - (1/(p*(p-1)));
            answer = answer*parenthetical;
            System.out.println(i);
        }

        System.out.println(answer);
    }
}
