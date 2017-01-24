package p7;

public class Prime_Optimized {


	public static void main(String[] args) {

		long prime = 0;
		boolean isPrime = true;
		long primecount = 1;
		
		for (long a = 3; ; a += 2) {
			for (long b = 2; b <= Math.sqrt(a); b++) {
				if (a % b == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				prime = a;
				primecount += 1;
			}
			isPrime = true;
			if (primecount == 10001) {
				System.out.println(prime);
				return;
			}
		}
	}

}
