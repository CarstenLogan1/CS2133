public class Euler3 {

    public static void main(String[] args) {

        long n = 600851475143L;
        long largestPrimeFactor = 2;


        while (n > 1){
            if(n % largestPrimeFactor ==0){
                n/= largestPrimeFactor;
            } else {
                largestPrimeFactor++;
            }
        }

        System.out.println(largestPrimeFactor);

    }
}
