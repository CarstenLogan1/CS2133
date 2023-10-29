public class CosFunc extends Function {
	
	/**
	The CosFunc class extends our Function class and allows for us to find the 
	roots of the Cosine function between any desired values. The Evaluate method 
	will insert the function Math.cos() when findRoot from Function.java calls
	the abstract evaluate method. 
	*/
	
	public double evaluate(double x) {
		return Math.cos(x);
	}
	
}
