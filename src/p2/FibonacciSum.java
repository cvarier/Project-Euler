package p2;

import java.util.*;

public class FibonacciSum {


	private static Scanner s;

	public static void main(String[] args) {
		
		int a = 1;
	    int b = 2;
	    int fib;
	    int sum = 2;
	    
	    System.out.println("Enter the maximum value for the fibonacci number");
	    s = new Scanner(System.in);
	    int c = s.nextInt();
	    
	    	for (fib = 0; fib <= c; fib++){
	    		fib = a + b;
	    			if (fib % 2 == 0){
	    			sum += fib;
	    			}
	    		a = b;
	    		b = fib;
	    	}
	    	System.out.println("The sum of all even terms in the fibonacci series up to " + c + " is: " + sum);
	}
}
