import java.math.BigInteger;
public class Euler15{
	public static void main(String[] args) {
        int n = 20;
        BigInteger fact;
        fact = factorial(2*n).divide(factorial(n).multiply(factorial(n)));
        System.out.println(fact);
    }

    public static BigInteger factorial(int n){
        BigInteger b = BigInteger.ONE;
        for(int i = 1; i <= n; i++){
            b = b.multiply(BigInteger.valueOf(i));
        }
        return b;
    }
}
