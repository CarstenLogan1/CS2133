public class Gregory {
	public static void main (String [] args) {
		
		int nthNum = Integer.parseInt(args[0]);
		double gregory = 0;
		double series;
		double error;
		
		for(int i = 1; i <= nthNum; i++) {
			
			series = (Math.pow(-1, i+1))/(2*i -1);
			gregory += series;
		
		}
		
	gregory *= 4.0;
	error = ((Math.abs(gregory-Math.PI))/Math.PI) * 100;
	
	System.out.println("Pi according to Gregory series: " + gregory);
	System.out.println("This differs from Java's value by " + error+ 
" percent.");
	
	
	}
}	
