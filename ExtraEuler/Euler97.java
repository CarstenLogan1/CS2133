
import java.math.BigInteger;

public class Euler97{

    public static void main(String[] args) {

        BigInteger b = new BigInteger("28433");
        BigInteger a = new BigInteger("1");
        BigInteger d = new BigInteger("2");
        BigInteger c = d.pow(7830457);
        BigInteger sum = (b.multiply(c)).add(a);

        String str = sum.toString();
        String sum2 = "";
        for(int i = str.length()-10; i<str.length();i++ ){
            char ch = str.charAt(i);
            sum2+=ch;
        }

        System.out.println(sum2);

    }

}