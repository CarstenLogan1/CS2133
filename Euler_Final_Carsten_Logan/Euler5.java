public class Euler5{
	
	public static void main(String[] args) {
        int n = 2520;
        boolean check = false;

        while(check == false){
            for(int i = 1; i<21; i++){
                if(n%i != 0){
                    check = false;
                    break;
                } else{
                    check = true;
                }
            }
            if(check == true){
                System.out.print(n);
            }
            n+=2520;

        }
    }
	
}
