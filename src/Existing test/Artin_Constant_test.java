import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Artin_Constant_test {
    public static void main(String[] args) throws IOException {
        Prime_Calculator primeCalc = new Prime_Calculator();
        ArrayList<Integer> primes = primeCalc.getPrimes();


        // inital test of formula, increasing primes

        double parenthetical;
        double answer = 1;

        for (int i = 0; i < primes.size(); i++) {
            double p = primes.get(i);
            parenthetical = 1 - (1/(p*(p-1)));
            answer = answer*parenthetical;
            //System.out.println(i);
        }

        System.out.println("Answer (before round): " + answer);


        // Complete convergence test via opposite list, decreasing primes

        double oppositeParenthetical;
        double oppositeAnswer = 1;

        for (int i = primes.size()-1; i >= 0; i--) {
            double p = primes.get(i);
            oppositeParenthetical = 1 - (1/(p*(p-1)));
            oppositeAnswer = oppositeAnswer*oppositeParenthetical;
            //System.out.println(i + " | " + oppositeAnswer);
        }

        System.out.println("Opposite answer (before round): " + oppositeAnswer);

        // Random primes order, further test convergence

        double randomParenthetical;
        double randomAnswer = 1;

        // List from 0 - 999 (1000 distance)
        ArrayList<Integer> iList = new ArrayList<>(primes.size());

        for (int i = 0; i < primes.size(); i++) {
            iList.add(i);
        }

        Random random = new Random();

        while (iList.size() > 0) {
            int randomInteger = random.nextInt(iList.size());
            double p = primes.get(iList.get(randomInteger));
            randomParenthetical = 1 - (1/(p*(p-1)));
            randomAnswer = randomAnswer*randomParenthetical;
            iList.remove(randomInteger);
            //System.out.println(randomInteger + " | " + p + " | " + randomAnswer);
        }

        System.out.println("Random Answer (before round): " + randomAnswer);


        // output w/ rounding

        DecimalFormat df = new DecimalFormat("#.############");

        answer = Double.parseDouble(df.format(answer));
        oppositeAnswer = Double.parseDouble(df.format(oppositeAnswer));
        randomAnswer = Double.parseDouble(df.format(randomAnswer));


        System.out.println("\nAnswer (after round): " + answer);
        System.out.println("Opposite answer (after round): " + oppositeAnswer);
        System.out.println("Random Answer (after round): " + randomAnswer);


        boolean isConvergent = ((answer == oppositeAnswer) && (oppositeAnswer == randomAnswer));

        System.out.println("\n" + isConvergent);



    }
}
