package p14;

public class P14 {


	public static void main(String[] args) {
		
		int counter = 0;
		long n = 0;
		long coll = 0;
		long collc = 0;
		
		for (long a = 500000; a < 1000000; a++) {
			n = a;
			while (n != 1) {
				if (n % 2 == 0) {
					n = n/2;
					counter = counter + 1;
				}
				if (n % 2 != 0 && n != 1) {
					n = 3*n +1;
					counter = counter + 1;
				}
			}		
			if (counter > collc) {
				collc = counter;
				coll = a;
			}
			counter = 0;
		}
		
		System.out.println("number: " + coll + " terms: " + collc);
	}
}
