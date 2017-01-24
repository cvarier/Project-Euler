package p3;

import java.util.*;

public class LargestPrimeFactors {


	private static Scanner s;

	public static void main(String[] args) {
		
		s = new Scanner(System.in);
		System.out.println("Enter a number to find its largest prime factor");
		long a = s.nextLong();
		long count = 0;
		long count2 = 0;
		long count3 = 0;
		long prime = 0;
		long prime2 = 0;
		long prime3 = 0;
		long primex = 0;
		
		for (long i = 2; i <= Math.sqrt(a); i++){
			if (a % i == 0) {                 //finds the factors of the square root of the given number
				for (long c = 2; c <= Math.sqrt(i); c++) {       
					if (i % c == 0) {         //checks to see how many factors a factor of the sq. root of the given number has
						count = count + 1;    //other than 1 and itself
					}
				}
				if (count == 0){  //if it doesn't have any factors other than 1 and itself, then it is prime
					prime = i;  //the factor is prime, and the loop keeps updating to 
					System.err.println("Prime factor: " + prime);
				}               //store the largest prime factor in the variable prime
				for (long d = 2; d <= Math.sqrt((a/i)); d++)
				{
					long i2 = (a/i);
					if (i2 % d == 0){
						count2 = count2 + 1;
					}
				}
				if (count2 == 0){
					prime2 = (a/i);
					System.err.println("Prime factor 2: " + prime2);
				}
			}
		}
		
		for (long f = 2; f <= Math.sqrt(a); f++) {
			if (a % f == 0) {
				count3 = count3 + 1;
			}
		}
		
		if (count3 == 0) {
			prime3 = a;
			System.err.println("Prime factor 3: " + prime3);
		}
		
		if (prime2 > prime && prime2 > prime3)
		{
			primex = prime2;
			
		} else if (prime > prime2 && prime > prime3) {
			
			primex = prime;
		}
		else {
			primex = prime3;
		}
		
		System.out.println("Answer is: " + primex);
		
	}
}
