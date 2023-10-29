public class SinFunc extends Function {

	/**
	The SinFunc class extends our Function class and allows for us to find the 
	roots of the Sine function between any desired values. The Evaluate method 
	will insert the function Math.Sin() when findRoot from Function.java calls
	the abstract evaluate method. 
	*/
	
	public double evaluate(double x) {
		return Math.sin(x);
	}	

}
