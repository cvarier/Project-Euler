package p15;

import java.util.Scanner;

public class P15 {

	private static Scanner as;
	
	public static void main(String[] args) {
		as = new Scanner(System.in);
		System.out.println("Enter the number of R's");
		int r = as.nextInt();
		System.out.println("Enter the number of D's");
		int d = as.nextInt();
		System.out.println("The total number of paths in the grid to the bottom-right corner is: " + path(r, d));
		
	}
	
	public static double path(int a, int b) {
		
			double num = 1;
			double den1 = 1;
			double den2 = 1;
			
			for (double i = 1; i <= a + b; i++) {
				num = num * i;
			}
			
			for (double i = 1; i <= a; i++) {
				den1 = den1 * i;
			}
			
			for (double i = 1; i <= b ; i++) {
				den2 = den2 * i;
			}
			
			double paths = num/(den1*den2);
			
		return paths;
	}
}
