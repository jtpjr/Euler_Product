import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Prime_Calculator {
    public ArrayList<Integer> getPrimes() throws IOException {
        ArrayList<Integer> primes = new ArrayList<>();
        Path primesPath = Paths.get("primes1k.txt");
        Scanner fileScanner = new Scanner(primesPath);

        while (fileScanner.hasNext()) {
            if (fileScanner.hasNextInt()) {
                primes.add(fileScanner.nextInt());
            } else {
                fileScanner.next();
            }
        }

        return primes;
    }

    public ArrayList<Integer> get10kPrimes() throws IOException {
        ArrayList<Integer> primes = new ArrayList<>();
        Path primesPath = Paths.get("primes10k.txt");
        Scanner fileScanner = new Scanner(primesPath);

        while (fileScanner.hasNext()) {
            if (fileScanner.hasNextInt()) {
                primes.add(fileScanner.nextInt());
            } else {
                fileScanner.next();
            }
        }

        return primes;
    }

    public ArrayList<Integer> get100kPrimes() throws IOException {
        ArrayList<Integer> primes = new ArrayList<>();
        Path primesPath = Paths.get("primes100k.txt");
        Scanner fileScanner = new Scanner(primesPath);

        while (fileScanner.hasNext()) {
            if (fileScanner.hasNextInt()) {
                primes.add(fileScanner.nextInt());
            } else {
                fileScanner.next();
            }
        }

        return primes;
    }

    public ArrayList<Integer> getFirst10MilPrimes() throws IOException {
        ArrayList<Integer> primes = new ArrayList<>();
        Path primesPath = Paths.get("2T_part1.txt");
        Scanner fileScanner = new Scanner(primesPath);

        while (fileScanner.hasNext()) {
            if (fileScanner.hasNextInt()) {
                primes.add(fileScanner.nextInt());
            } else {
                fileScanner.next();
            }
        }

        return primes;
    }
}
