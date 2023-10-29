import java.util.ArrayList;
import java.lang.Math;

public class Euler10 {
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        primes.add(2);
        primes.add(3);
        primeList();
        System.out.print(primeSummer());
    }

    static void primeList() {
        int i = 1;
        while (6 * i - 1 < 2000000) {
            int prime1 = 6 * i - 1;
            int prime2 = 6 * i + 1;
            if (isPrime(prime1)) {
                primes.add(prime1);
            }
            if (prime2 < 2000000 && isPrime(prime2)) {
                primes.add(prime2);
            }
            i++;
        }
    }

    static boolean isPrime(Integer n) {
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    static long primeSummer(){
        long sum = 0;
        for(int i = 0; i<primes.size();i++){
            sum+=primes.get(i);
        }
        return sum;
    }
}
