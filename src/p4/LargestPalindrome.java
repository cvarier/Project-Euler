package p4;

import java.util.*;

public class LargestPalindrome {

	private static Scanner s;
	
	public static void main(String[] args) {
		
		s = new Scanner(System.in);
		System.out.println("Enter a 4 digit number to find out whether it is a palindrome or not");
		Integer a = s.nextInt();
		
		Integer D_ONES = a % 10;
		Integer D_TENS = (a % 100)/10;
		Integer D_HUNDREDS = (a % 1000)/100;
		Integer D_THOUSANDS = (a % 10000)/1000;
		
		if (D_ONES == D_THOUSANDS && D_TENS == D_HUNDREDS) {
			System.out.println("Yes it is.");
		} else {
			System.out.println("No it isn't.");
		}

	}
}