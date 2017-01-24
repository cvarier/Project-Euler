package p1;

import java.util.*;

public class MultipleSum {


	private static Scanner s;

	public static void main(String[] args) {
		
		int a;
		int b;
		int sum = 0;
		int i;
		
	    System.out.println("Enter the maximum value to check for multiples of 3 and 5");
	    s = new Scanner(System.in);
	    int c = s.nextInt();
		
			for (i = 1; i < c; i++) {
				a = i % 3;
				b = i % 5;
				
					if (a == 0 || b == 0) {
						sum = sum + i;
					}
			}
			
		System.out.println("The sum for " + c + " is: " + sum);
	}

}
