import java.math.BigInteger;
public class Euler48 {import java.math.BigInteger;

	public static void main(String[] args) {
        BigInteger b = new BigInteger("0");
        String sum = "";
        for(int i = 1; i<1001; i++){
            b = b.add(BigInteger.valueOf(i).pow(i));
        }
        String s = b.toString();
        for(int i = (s.length())-10; i < s.length(); i++ ){
            char c = s.charAt(i);
            sum+= c;
        }
        System.out.println(sum);
    }

}
