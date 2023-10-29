import java.util.Scanner;

public class Average {
    private static final Scanner keyboard = new Scanner(System.in);
    public static void main (String[] args) {

        double userNumber;
        int totalNumbers = 0;
        double average= 0;

        System.out.println("Enter a series of numbers. Enter a negative number to quit.");
        userNumber = keyboard.nextDouble();

        while(userNumber >= 0) {
            totalNumbers++;
            average += userNumber;
            userNumber = keyboard.nextDouble();
        }
        
        average = average / totalNumbers;
        System.out.println("You entered " + totalNumbers + " numbers averaging " + average);
    }

}






