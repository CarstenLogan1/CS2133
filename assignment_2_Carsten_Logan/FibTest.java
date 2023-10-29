public class FibTest {

    public static void main(String [] args){

        long start1,start2,stop1,stop2, nanostart1, nanostart2, nanostop1, nanostop2;
        long time1,time2, nanotime1, nanotime2 = 0;


        if(fibIter(5) == 5) {
            System.out.println("fibIter(5) passed.");
        } else System.out.println("fibIter(5) fauled.");

        if(fibRecur(5) == 5) {
            System.out.println("fibRecur(5) passed.");
        } else System.out.println("fibRecur(5) failed.");

        if(fibIter(12) == 144) {
            System.out.println("fibIter(12) passed.");
        } else {
            System.out.println("fibIter(12) fauled.");
        }

        if(fibRecur(12) == 144) {
            System.out.println("fibRecur(12) passed.");
        } else {
            System.out.println("fibRecur(12) failed.");
        }
        
        /* TimeMillis for fibIter(40) will only produce time of 0. However in 
        debugger it produces correct value but only prints 0. Have supplementary 
        included nanoTime which works just fine.*/

        start1 = System.currentTimeMillis();
        nanostart1 = System.nanoTime();
        fibIter(40);
        stop1 = System.currentTimeMillis();
        nanostop1 = System.nanoTime();
        time1= stop1 - start1;
        nanotime1 = nanostop1 - nanostart1;
        
        System.out.println("fibIter(40) time in millis: " + time1);
        System.out.println("fibIter(40) time in nano: " + nanotime1);

        start2 = System.currentTimeMillis();
        nanostart1 = System.nanoTime();
        fibRecur(40);
        stop2 = System.currentTimeMillis();
        nanostop2 = System.nanoTime();
        time2 = stop2 - start2;
        nanotime2 = nanostop2 - nanostart1;
        
        System.out.println("fibRecur(40) time in millis: " + time2);
        System.out.println("fibRecur(40) time in nano: " + nanotime2);

    }


    public static int fibIter(int n) {


        int [] fibNumbers = new int [n+1];

        fibNumbers [0] = 0;
        fibNumbers [1] = 1;

        if (n == 0 || n == 1) {
            System.out.println(n);
        }
        else {
            for (int i = 2; i <= n; i++) {
                fibNumbers[i] = fibNumbers[i - 2] + fibNumbers[i - 1];

            }
        }

        return (fibNumbers[n]);
    }

    public static int fibRecur(int n) {

        if(n <= 1){
            return n;
        } else {
            return fibRecur(n-1) + fibRecur(n-2);
        }

    }
}
