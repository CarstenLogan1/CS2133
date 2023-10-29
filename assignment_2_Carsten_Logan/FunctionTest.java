public class FunctionTest {

    public static void main(String[] args) {

        findRoot(3.0, 4.0, .00000001);
    }

    public static double findRoot(double a, double b, double epsilon) {
        double x;
        x = (a + b) / 2;

        if (Math.abs(a - x) < epsilon) {
            System.out.println("The root of sin(x) between 3 and 4 is: " + x);
            System.exit(0);
            return x;
        } else {
            if ((Math.sin(x) > 0 && Math.sin(a) > 0) || (Math.sin(x) < 0 && Math.sin(a) < 0)) {
                findRoot(x, b, epsilon);
                
            } else {
                findRoot(a, x, epsilon);
                
            }
        } return x;
    }
}
