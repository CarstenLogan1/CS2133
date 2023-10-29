/**
Function.java is our abstract parent class. It implements three methods: abstract
method evaluate, the refactored findRoot method, and our driver/main method.Function
allows for the root of any function to be calculated hence its general/abstract form.
One must extend it and implement it to their necessary function. 
*/


public abstract class Function {
	
	/**
	The abstract evaluate method within the Function class serves as a placeholder.
	It allows for the subclasses to call this method in the fashion deemed necessary
	within that class. This method is what allows for the generalization of our 
	findRoot method as it enables subclasses to call any function/ function type.
	*/

    public abstract double evaluate(double x);
    
    
    
    /** 
    findRoot is the computational method to find the root of any function. It works
    by taking in two boundary values and an epsilon/error value. The method takes 
    two inputs a and b and divides it to give the midway point. That point is then
    subtracted from the leftmost boundary and if the difference is less than epsilon
    the root has been calculated and is returned. If greater than, the method 
    recursively calls itself however this time changing the bounds and using x
    as a new bound value until the difference between x and the bound is below 
    epsilon(ie the root is found)
    */

    public double findRoot(double a, double b, double epsilon) {
        double x;
        x = (a + b) / 2;

        if (Math.abs(a - x) < epsilon) {
            //System.out.println("The root of the function is: " + x);
            return x;
        } else {
            if ((evaluate(x) > 0 && evaluate(a) > 0) || (evaluate(x) < 0 && evaluate(a) < 0)) {
                findRoot(x, b, epsilon);

            } else {
                findRoot(a, x, epsilon);

            }
        } return x;
    }

    /**
    Our main method/ driver class serves to instantiate functions, create objects,
    and tests our code. It creates and evaluates our SinFunc, CosFunc, and PolyFunc
    objects and returns the value of each functions root between the specified
    values
    */

    public static void main(String[] args) {

        Function cosFunc = new CosFunc();
        if(Math.abs(cosFunc.findRoot(1, 3, .000001) - (0.5 * Math.PI)) > 0.0001){
        	System.out.println("Cos(x) root Passed!");
        } else {
        	System.out.println("Cos(x) root FAILED!!");
        }
    


        Function sinFunc = new SinFunc();
        if(Math.abs(sinFunc.findRoot(3, 4, .000001) - Math.PI) > 0.0001){
        	System.out.println("Sin(x) root Passed!");
        } else {
        	System.out.println("Sin(x) root FAILED!!!");
        }
        
        
        int [] coefficients_1 = {-3, 0, 1};
        Function polyFunc1 = new PolyFunc(coefficients_1);
        if(Math.abs(polyFunc1.findRoot(0, 1000000000, .000001) - Math.sqrt(3)) > 0.0001){
        	System.out.println("Poly1 root Passed!");
        } else {
        	System.out.println("Poly1 root FAILED!!!");
        }
        
        int [] coefficients_2 = {-2, -1, 1};
        Function polyFunc2 = new PolyFunc(coefficients_2);
        if(Math.abs(polyFunc2.findRoot(0, 1000000000, .000001) - 2) > 0.0001){
        	System.out.println("Poly2 root Passed!");
        } else {
        	System.out.println("Poly2 root FAILED!!!");
        }
        


    }

}
