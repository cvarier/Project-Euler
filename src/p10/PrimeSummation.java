package p10;

public class PrimeSummation {


	public static void main(String[] args) {
		
		long a;
		boolean isPrime = true;
		long sum = 2;
		
		for (int i = 3; i < 2000000;  i += 2) {
			for (a = 2; a <= Math.sqrt(i); a++) {
				if (i % a == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				sum += i;
			}
			
			isPrime = true;
		}
		
		System.out.println(sum);

	}

}
