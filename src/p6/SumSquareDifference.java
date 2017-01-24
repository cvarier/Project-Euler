package p6;

public class SumSquareDifference {


	public static void main(String[] args) {

		long sqofsum = 0;
		long sumofsq = 0;
		long sum1 = 0;
		long sum2 = 0;
		long diff = 0;
		
			for (int a = 1; a <= 100; a++) {
				sum1 = sum1 + (a*a);
			}
			
			sumofsq = sum1;
			
			for (int b = 1; b <= 100; b++) {
				sum2 = sum2 + b;
			}
			
			sqofsum = sum2 *sum2;
			
			if (sqofsum > sumofsq) {
				diff = sqofsum - sumofsq;
			} else {
				diff = sumofsq - sqofsum;
			}
			
			System.out.println(diff);
	}

}
