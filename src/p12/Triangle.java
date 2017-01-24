package p12;

public class Triangle {

	public static void main(String[] args) {
		
		double tri = 0;
		int counter = 0;
		int factor = 0;
		
		for (double i = 0; ;i++) {
			tri = (i*(i+1))/2; //triangle number formula

			for (double a = 1; a <= Math.sqrt(tri); a++) { 
				if (tri % a == 0) {          //check for divisors of i-th triangle number
					counter = counter +1;    //up to its square root
				}
			}
			if (tri % Math.sqrt(tri) != 0) { //if square root of said number is not whole
				factor = counter *2; //the number of its factors will be twice the number of
									 //factors found up to its square root
			}
			if (tri % Math.sqrt(tri) == 0) { //if it is whole, number of factors will be twice
				factor = counter *2 - 1;     //the amount up to its square root minus one
			}
			if (factor > 500) {          //check for the first triangle number with more than
				System.out.println(tri); //500 factors
				break;
			}
			counter = 0;
		}
	}
}
