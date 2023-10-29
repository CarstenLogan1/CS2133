public class Fib {
	public static void main (String[] args){
		

        int number = Integer.parseInt(args[0]);
        int [] fibNumbers = new int [number+1];

        fibNumbers [0] = 0;
        fibNumbers [1] = 1;

        if (number == 0 || number == 1) {
            System.out.println(number);
        }
        else {
            for (int i = 2; i <= number; i++) {
                fibNumbers[i] = fibNumbers[i - 2] + fibNumbers[i - 1];

            }
        }

        System.out.println(fibNumbers[number]);

    }
}	