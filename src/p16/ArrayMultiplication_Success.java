package p16;

import java.util.Scanner;

public class ArrayMultiplication_Success {

	private static Scanner in;

	// ---CALCULATE SUM OF DIGITS---

	public static int sum(int[] a) {
		int summation = 0;

		for (int q = 0; q < a.length; q++) {
			summation += a[q];
		}

		return summation;
	}

	public static void main(String[] args) {

		// ---GET BASE AND EXPONENT FROM SCANNER INPUT---

		System.out
				.println("Enter a positive integer base of an exponent to calculate (from one to ten)");
		System.out.println();
		in = new Scanner(System.in);
		int x = in.nextInt();
		System.out.println();
		System.out.println("Enter a positive power of " + x + " to calculate");
		System.out.println();
		double n = in.nextDouble();
		double digits;

		// ---CALCULATION FOR NUMBER OF DIGITS---

		digits = Math.floor(n * Math.log10(x) + 1);

		// ---VARIABLE DECLARATION FOR EXPONENTIATION ALGORITHM---

		int[] pow = new int[(int) digits];
		pow[(int) digits - 1] = 1;
		int digprod = 0;
		int carryover = 0;
		int zerocount = 0;
		int i = (int) digits - 1;

		// ---EXPONENTIATION ALGORITHM FOR CALCULATING X^N---

		for (int a = 0; a < n; a++) {

			// Check if 100 leading zeroes have been counted and if the
			// index variable has reached the
			// beginning of the array. If both are true, perform the next
			// multiplication

			while (zerocount < 100 && i >= 0) {

				// Get the product of the base and the digit
				// stored in the current index.

				digprod = pow[i] * x;

				// Get the mod 10 of the product and add it to carryover.
				// Take the mod 10 of the whole expression.
				// This will ensure that no matter how large the product is
				// (it will always be between 0 - 81), only a single digit
				// will be stored in each cell.

				pow[i] = (digprod % 10 + carryover) % 10;

				// The carryover will simply be the tens digit of the product
				// plus the previous carryover.

				carryover = (digprod + carryover) / 10;

				// Check if all that remains in the array are leading zeroes.
				// Zerocount will increment by 1 every time 4 consecutive
				// zeroes are found. This only applies if the base is not equal
				// to ten.

				if (i > 2 && pow[i] == 0 && pow[i - 1] == 0 && pow[i - 2] == 0
						&& pow[i - 3] == 0 && x != 10) {

					zerocount++;

				}

				// Shift the array index down by one for the next iteration.

				i--;
			}

			// Reset the values of the carryover, zerocount and the index
			// variable
			// for the subsequent multiplication.

			carryover = 0;
			zerocount = 0;
			i = (int) digits - 1;

		}

		// ---PRINT OUTPUT - THE EXPONENTIATION RESULT, THE SUM OF THE DIGITS,
		// THE NUMBER OF DIGITS AND THE OCCURRENCES OF EACH DIGIT---

		System.out.println();
		System.out.println(x + " to the power of " + (int) n + " is: ");
		System.out.println();

		int charcount = 0;
		int dignums[] = new int[10];

		for (int c = 0; c < pow.length; c++) {
			System.out.print(pow[c]);
			charcount++;
			if (charcount == 180) {
				System.out.println();
				charcount = 0;
			}

			if (pow[c] >= 0 && pow[c] <= 9)
				dignums[pow[c]]++;

		}

		System.out.println();
		System.out.println();
		System.out.println("The number of digits in the result is: "
				+ pow.length);
		System.out.println();
		System.out.println("The sum of the digits of the result is: "
				+ sum(pow));
		System.out.println();
		System.out.println("# Zeroes: " + dignums[0]);
		System.out.println("# Ones: " + dignums[1]);
		System.out.println("# Twos: " + dignums[2]);
		System.out.println("# Threes: " + dignums[3]);
		System.out.println("# Fours: " + dignums[4]);
		System.out.println("# Fives: " + dignums[5]);
		System.out.println("# Sixes: " + dignums[6]);
		System.out.println("# Sevens: " + dignums[7]);
		System.out.println("# Eights: " + dignums[8]);
		System.out.println("# Nines: " + dignums[9]);

	}

}