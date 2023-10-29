public class Euler9 {

public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;

        for(int i = 1; i < 1000; i++ ){
            for(int j = i +1; j < 1000; j++){
                int k = 1000 - i - j;
                if(Math.pow(i,2) + Math.pow(j,2) == Math.pow(k,2)) {
                    a = i;
                    b = j;
                    c = k;
                    break;
                }
            }
        }

        int product = a*b*c;
        System.out.println(product);

    }
	
}
