import java.math.BigInteger;

public class Euler16 {
    public static void main(String[] args) {
        BigInteger N = BigInteger.valueOf(2);
        BigInteger Sum = N.pow(1000);

        String str = Sum.toString();
        int sum1 = 0;

        for(int i = 0; i<str.length(); i++){
            sum1+= Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        System.out.println(sum1);
    }
}
