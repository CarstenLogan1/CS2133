public class Factorial {

    public static void main(String [] args) {

        /*long input = Long.parseLong(args[0]);
        long factorial = calculate(input);*/

        long factorial1 = calculate(0);
        long factorial2 = calculate(5);

        if(factorial1 == 1) {
            System.out.println("Factorial.calculate(0) returned 1. Test passed!");
        } else System.out.println("TEST FAILED");

        if(factorial2 == 120) {
            System.out.println("Factorial.calculate(5) returned 120. Test passed!");
        } else System.out.println("TEST FAILED");


    }


    public static long calculate (long n) {
        long factorial = 0;
        
        if ((n < 0) || (n > 20)) {
            System.out.println("ERROR: Invalid input: Input must be 0<x<20");
            System.exit(0);
        } else {
        		if(n == 0) {
            factorial = 1;
        }	else {
            factorial = n * calculate(n-1);
        }
        }
        return factorial;
    } 
}
