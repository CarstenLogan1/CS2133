
/**
The class PolyFunc extends our Function.java class and allows for us to evaluate 
the roots of any polynomial function. To evaluate the root, boundaries and the 
epsilon value are passed to findRoot. An x value is calculated by findRoot and 
passed to evaluate where the polynomial is evaluated at that x value. This x value 
is returned to findRoot and if not within the epsilon value, the boundaries are 
changed are the methods are recursively called until the polynomial is evaluated 
to the sufficient epsilon value. 
*/

import java.util.Arrays;
public class PolyFunc extends Function {

    public int[] coefficients;

    public static void main (String [] args) {
        int [] coefficients_1 = {4, 0, -8, 0, 3, 2};
        int [] coefficients_2 = {0, -2, 4, 1, 0, 0};
        int [] coefficients_3 = {4, -2, -4, 1, 3, 2};

        PolyFunc poly_1 = new PolyFunc(coefficients_1);
        PolyFunc poly_2 = new PolyFunc(coefficients_2);
        PolyFunc poly_3 = poly_1.add(poly_2);

        if (poly_1.degree() == 5) {
            System.out.println("degree() Passed!");
        } else System.out.println("degree() FAILED!");
        if (poly_1.evaluate(2.0) == 84) {
            System.out.println("evaluate(2.0) Passed!");
        } else System.out.println("evaluate(2.0) FAILED!!!");

        System.out.println("Polynomial toString: " + poly_1);

        if (Arrays.equals(coefficients_3, poly_3.coefficients)){
            System.out.println("Poly add() Passed!");
        } else {
            System.out.println("Poly add() FAILED!!!!");
        }




    }


    public PolyFunc (int[] coefficients) {
        this.coefficients = coefficients;
    }

    public int degree(){
        int degree = 0;
        for(int i =0; i< coefficients.length ; i++){
            if(coefficients[i] != 0) {
                degree = i;
            }
        }

        return degree;
    }

    public String toString() {

        String poly_string = "";

        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (i == 0 && coefficients[0] != 0) {
                poly_string += coefficients[0];
            } else if(i == 1 && coefficients[1] != 0) {
                poly_string += coefficients[1] + "x+";
            } else if (coefficients[i] > 0) {
                poly_string += coefficients[i] + "x^" + i + "+";
            } else if (coefficients[i] < 0){
                poly_string += coefficients[i] + "x^" + i + "+";
            }
            else poly_string += "";

        } return poly_string;
    }

    public PolyFunc add(PolyFunc a){
        int [] coefficient_sum;

        if(this.coefficients.length >= a.coefficients.length) {
            coefficient_sum = new int [this.coefficients.length];

            for(int i = 0; i< coefficient_sum.length; i++){
                if (i < a.coefficients.length) {
                    coefficient_sum[i] = this.coefficients[i] + a.coefficients[i];
                } else {
                    coefficient_sum[i] = this.coefficients[i];
                }
            }
        } else {
            coefficient_sum = new int [a.coefficients.length];

            for(int i = 0; i< coefficient_sum.length; i++){
                if (i < this.coefficients.length){
                    coefficient_sum[i] = this.coefficients[i] + a.coefficients[i];
                } else {
                    coefficient_sum[i] = a.coefficients[i];
                }
            }
        }

        return new PolyFunc(coefficient_sum);

    }
    
    public double evaluate (double x) {
        double value = 0;
        for (int i = 0; i < coefficients.length; i++ ) {
            value += coefficients[i] * Math.pow(x,i);
        }

        return value;

    }


}


