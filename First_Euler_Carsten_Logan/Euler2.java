public class Euler2 {
	
	public static void main(String[] args) {

        int n = 33;
        int [] fibArr = new int [n+1];
        int evenSum = 0;

        for(int i = 0; i<= n; i++){
            fibArr[i] = fibRecur(i);
        }

        for (int i = 0; i<=n; i++){
            if(fibArr[i] % 2 == 0){
                evenSum += fibArr[i];
            }
        }

        System.out.println(evenSum);
    }

    public static int fibRecur(int n) {

        if(n <= 1){
            return n;
        } else {
            return fibRecur(n-1) + fibRecur(n-2);
        }

    }
}
