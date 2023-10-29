public class Euler4{
	public static void main(String[] args) {

        int palindrome = palindromeFind();
        System.out.println(palindrome);
    }

    static int palindromeFind(){
        int maxP = 0;
        for(int i = 100; i<1000; i++){
            for(int j = 100; j<1000; j++){
                int n = i*j;
                if(palindromeCheck(n) && n>maxP){
                    maxP = n;
                }
            }
        }
        return maxP;
    }

    private static boolean palindromeCheck(int n) {
        String str = Integer.toString(n);
        int i = 0;
        int j = str.length()-1;

        while(i<j){
            if(str.charAt(i)!= str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
