package primes;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
	
	//The following method in this class returns an ArrayList of Arraylists named primeFactorization 
	//with dimensions 2 * the number of distinct prime factors in the number x.
	//primeFactorization.get(0) contains the primes, and
	//primeFactorization.get(1) contains the quantity of each prime
	//where the values and the indeces of the two ArrayLists match up.
	
	public static List<ArrayList<Long>> primeFactorize (Long x) {
		
		ArrayList<Long> prime = new ArrayList<Long>();
		ArrayList<Long> primequant = new ArrayList<Long>();
		boolean added = false;
		long size = 0;
		long i = 0L;

			i = x;
			
			for (long j = 2L; j <= i/j; j++) {
				
				while (i % j == 0) {
					// search for factor in prime
					for (int k = 0; k < prime.size(); k++) {
						
						if (prime.get(k) == j) {
							
							size = primequant.get(k);
							primequant.remove(k);
							primequant.add(k, size+1);
							added = true;
							
						}
						
					}
					
					if (!added) {
						
						prime.add(j);
						primequant.add((long) 1);
						
					}
					
					i /= j;
					
					added = false;
					
				}
				
			}
			
			if (i > 1) {
				
				// search for factor in prime
				for (int k = 0; k < prime.size(); k++) {
					
					if (prime.get(k) == i) {
						
						size = primequant.get(k);
						primequant.remove(k);
						primequant.add(k, size+1);
						added = true;
						
					}
					
				}
				
				if (!added) {
					
					prime.add(i);
					primequant.add((long) 1);
					
				}
				
				added = false;
				
			}
			
			List<ArrayList<Long>> primeFactorization = new ArrayList<ArrayList<Long>>();
			
			primeFactorization.add(prime);
			primeFactorization.add(primequant);
			
		
		return primeFactorization;
		
	}

}
