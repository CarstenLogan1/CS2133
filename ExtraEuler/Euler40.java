
public class Euler40{

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        for(int i = 1; i<=1000000; i++){
            s.append(i);
        }

        int product = Character.getNumericValue(s.charAt(0)) * Character.getNumericValue(s.charAt(9))*Character.getNumericValue(s.charAt(99))*
                Character.getNumericValue(s.charAt(999)) * Character.getNumericValue(s.charAt(9999))
                *Character.getNumericValue(s.charAt(99999))*Character.getNumericValue(s.charAt(999999));

        System.out.println(product);
    }

}