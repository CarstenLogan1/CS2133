import java.util.ArrayList;
import java.lang.Math;

public class Euler7 {
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        primes.add(2);
        primes.add(3);
        primeAdder();
        System.out.print(primes.get(10000));
    }

    static void primeAdder() {
        int i = 1;
        while (primes.size() < 10001) {
            int prime1 = 6 * i - 1;
            int prime2 = 6 * i + 1;
            if (isPrime(prime1)) {
                primes.add(prime1);
            }
            if (isPrime(prime2)) {
                primes.add(prime2);
            }
            i++;
        }
    }

    static boolean isPrime(Integer n) {

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            if (prime > Math.sqrt(n)) {
                break;
            }
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }
}
