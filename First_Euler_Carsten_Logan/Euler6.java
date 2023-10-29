public class Euler6 {
    public static void main (String [] args) {

        int sumSquare = 0;
        int squareSum = 0;
        int difference;

        for (int i = 1; i < 101; i++) {
            sumSquare += Math.pow(i,2);
        }

        for (int j = 1; j < 101; j++) {
            squareSum += j;

        }

        squareSum = (int) Math.pow(squareSum, 2);
        difference = squareSum - sumSquare;

        System.out.println(difference);
    }
}


