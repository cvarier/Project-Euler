package p5;


public class SmallestMultiple {


	public static void main(String[] args) {

		long multiple = 0;
		int counter = 0;
		
		for (long a = 2520; ; a+= 20) {
			
/*			if (a % 11 == 0 && a % 13 == 0 && a % 14 == 0 && a % 16 == 0 && a % 17 == 0 && a % 18 == 0 && a % 19 == 0 && a % 20 == 0) {
				multiple = a;
				System.out.println(multiple);
			} */
				
			
			for (long b = 1; b <= 20; b++) {
				
				if (a % b != 0) {
				counter = counter + 1;
				}								
				
			}
			
			if (counter == 0) {
				multiple = a;
				System.out.println(multiple);
				break;
			}
			
			counter = 0; 
		}
		
		
	}
}

