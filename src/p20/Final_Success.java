package p20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Final_Success {

	private static Scanner a;

	public static void main(String[] args) {

		// -----Find Prime Factorization of 100!-------

		// In a loop i = 2 to i <= x, find the prime factorization for i. Search
		// for
		// each prime factor in an Integer ArrayList called prime. If it is
		// there, then in another
		// Integer ArrayList describing the amount of times
		// that factor appears called primequant (the indices match
		// , meaning that the index ind of the prime array corresponds to the
		// same index in the
		// primequant array) add 1. If it isn't there, put the prime factor in
		// prime, and
		// initialize the quantity of that prime to 1 in primequant.

		ArrayList<Integer> prime = new ArrayList<Integer>();
		ArrayList<Integer> primequant = new ArrayList<Integer>();
		boolean added = false;
		int size = 0;
		int i = 0;

		a = new Scanner(System.in);
		System.out.println("Enter an integer x between 0 - 100");
		System.out.println();
		int x = a.nextInt();
		System.out.println();
		
		long startTime = System.currentTimeMillis();

		// --- PRIME FACTORIZATION ALGORITHM---

		// loop from 2 to x to find the prime factorization of each of the
		// numbers
		// from 2 to x
		for (int n = 2; n <= x; n++) {

			i = n;

			//
			for (int j = 2; j <= i / j; j++) {

				while (i % j == 0) {
					// search for factor in prime
					for (int k = 0; k < prime.size(); k++) {

						if (prime.get(k) == j) {

							size = primequant.get(k);
							primequant.remove(k);
							primequant.add(k, size + 1);
							added = true;
							break;

						}

					}

					if (!added) {

						prime.add(j);
						primequant.add(1);

					}

					i /= j;

					added = false;

				}

			}

			// if i is decomposed into a prime factor, add it to the list of
			// primes

			if (i > 1) {

				// search for factor in prime
				for (int k = 0; k < prime.size(); k++) {

					if (prime.get(k) == i) {

						size = primequant.get(k);
						primequant.remove(k);
						primequant.add(k, size + 1);
						added = true;
						break;

					}

				}

				if (!added) {

					prime.add(i);
					primequant.add(1);

				}

				added = false;

			}

		}

		// Calculate the # of trailing zeros and subtract factors of five from
		// factors of two
		// Update ArrayList prime

		int twocount = 0;
		int fivecount = 0;
		int trailzeros = 0;

		for (int k = 0; k < prime.size(); k++) {

			if (prime.get(k) == 5) {

				fivecount = primequant.get(k);
				prime.remove(k);
				primequant.remove(k);
				break;

			}

		}

		for (int k = 0; k < prime.size(); k++) {

			if (prime.get(k) == 2) {

				twocount = primequant.get(k);

				primequant.remove(k);
				primequant.add(k, twocount - fivecount);
				break;

			}

		}

		trailzeros = fivecount;

		// -----Multiply each of the primes together in the ArrayList prime and
		// store
		// in a new ArrayList called finalprod. (Reuse
		// the power digit algorithm in P16)-------

		int[] finalprod = new int[1000];
		finalprod[finalprod.length - 1] = 1;
		int digprod = 0;
		int carryover = 0;
		int zerocount = 0;
		i = finalprod.length - 1;

		int curprime = 0; // cuprime to the power of curpow will be calculated
		int curpow = 0;

		int digits = 0;
		List<Integer> digarray = new ArrayList<Integer>();

		int[] temparray = new int[finalprod.length];

		// For Adding Lines in Multi-Digit Multiplication
		int sumcarry = 0;
		int digsum = 0;

		for (int pri = 0; pri < prime.size(); pri++) {

			curprime = prime.get(pri);
			curpow = primequant.get(pri);

			// Getting number of digits in curprime

			while (curprime > 0) {

				digarray.add(curprime % 10);
				curprime /= 10;
				digits++;

			}

			Collections.reverse(digarray);
			curprime = prime.get(pri);

			for (int pow = 0; pow < curpow; pow++) {

				if (digits > 1) {

					// An ArrayList for each line in the multiplication.
					// once these are filled, they will be added together.

					int[][] lines = new int[digits][finalprod.length];

					for (int init = 0; init < finalprod.length; init++) {

						for (int lineind = 0; lineind < digits; lineind++) {

							// initalize lines with value of finalprod

							lines[lineind][init] = finalprod[init];

							lines[1][init] = finalprod[init];
						}

					}

					// fill lines

					for (int z = 0; z < digits; z++) {

						{
							while (zerocount < 100 && i >= 0) {

								digprod = lines[z][i] * digarray.get(z);

								lines[z][i] = (digprod % 10 + carryover) % 10;
								carryover = (digprod + carryover) / 10;

								if (i > 2 && lines[z][i] == 0
										&& lines[z][i - 1] == 0
										&& lines[z][i - 2] == 0
										&& lines[z][i - 3] == 0) {

									zerocount++;

								}

								i--;
							}

							carryover = 0;
							zerocount = 0;
							i = finalprod.length - 1;

						}

					}

					// Store value of lines[0] in temparray

					for (int init = 0; init < finalprod.length; init++) {

						temparray[init] = lines[0][init];

					}

					// add necessary zeroes to each line array in lines at
					// beginning

					for (int q = 0; q < digits - 1; q++) {

						lines[q][finalprod.length - 1] = 0;

						for (int index = finalprod.length - 2; index >= 0; index--) {

							lines[q][index] = temparray[index + 1];

						}

					}

					// clear finalprod

					for (int init = 0; init < finalprod.length; init++) {

						finalprod[init] = 0;

					}

					// add lines together after multiplying and store in
					// finalprod

					for (int q = 0; q < digits - 1; q++) {

						while (zerocount < 100 && i >= 0) {

							digsum = lines[0][i] + lines[1][i];

							finalprod[i] = (digsum % 10 + sumcarry) % 10;
							sumcarry = (digsum + sumcarry) / 10;

							if (i > 2 && lines[q][i] == 0
									&& lines[q][i - 1] == 0
									&& lines[q][i - 2] == 0
									&& lines[q][i - 3] == 0) {

								zerocount++;

							}

							i--;
						}

						sumcarry = 0;
						zerocount = 0;
						i = finalprod.length - 1;

					}

				} else {

					while (zerocount < 100 && i >= 0) {

						digprod = finalprod[i] * curprime;

						finalprod[i] = (digprod % 10 + carryover) % 10;
						carryover = (digprod + carryover) / 10;

						if (i > 2 && finalprod[i] == 0 && finalprod[i - 1] == 0
								&& finalprod[i - 2] == 0
								&& finalprod[i - 3] == 0) {

							zerocount++;

						}

						i--;
					}

					carryover = 0;
					zerocount = 0;
					i = finalprod.length - 1;

				}

			}

			digits = 0;
			digarray.clear();

		}

		// ------Find the sum of the digits in the new product.-------

		int finalsum = 0;
		List<Integer> finalprodarray = new ArrayList<Integer>();

		System.out.println(x + "! = ");

		// Print x! in an array

		for (int a = finalprod.length - 1; a >= 0; a--) {

			finalsum += finalprod[a];
			finalprodarray.add(finalprod[a]);

		}

		Collections.reverse(finalprodarray);

		while (finalprodarray.get(0) == 0 && finalprodarray.get(0 + 1) == 0) {

			finalprodarray.remove(0);

		}

		finalprodarray.remove(0);

		// Put trailing zeros at the end of the finalprodarray

		for (int b = 0; b < trailzeros; b++) {

			finalprodarray.add(finalprodarray.size(), 0);

		}

		// Print x!

		for (int a = 0; a < finalprodarray.size(); a++) {

			System.out.print(finalprodarray.get(a));

		}
		
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;

		// Print the answer

		System.out.println();

		System.out.println("The sum of the digits in " + x + "! = " + finalsum);
		
		System.out.println(runTime);
		

	}

}
