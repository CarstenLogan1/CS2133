public class Ramanujan {

    public static void main (String [] args) {

        int k = Integer.parseInt(args[0]);
        double approximate;

        approximate = ((2 * Math.sqrt(2))/(9801));
        double raman = 1/((approximate) * (series(k)));
        double error = (((raman)-(Math.PI))/(Math.PI)) * 100;


        System.out.println("Pi according to Ramanujan's series: " + raman);
        System.out.println("Percent error: " + error);
    }


    public static double series(int n){
        double sum = 0;
        double series;
        for(int i =0; i<= n; i++) {
            series = ((calculate(4*i))*(1103 + (26390*i)))/((Math.pow(calculate(i),4))*(Math.pow(396, (4*i))));
            sum += series;
        }
        return sum;
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
