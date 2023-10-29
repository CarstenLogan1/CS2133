
public class Euler36{

    public static void main(String[] args) {
        long sum = 0;
        for(int i=0; i<1000001; i++){
            if(palindromeCheck(Integer.toString(i)) && palindromeCheck(Integer.toBinaryString(i))){
                sum+= i;
            }
        }
        System.out.println(sum);

    }

    private static boolean palindromeCheck(String s) {
        String str = s;
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