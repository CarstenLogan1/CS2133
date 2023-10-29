import java.math.BigInteger;

public class Euler20 {
    public static void main(String[] args) {
        long sum = 0;
        BigInteger bi = new BigInteger("1");
        for(int i = 100; i > 0; i--){
            bi = bi.multiply(BigInteger.valueOf(i));
        }


        String s = bi.toString();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            int v = Character.getNumericValue(c);
            sum+=v;

        }

        System.out.println(sum);
    }
}
