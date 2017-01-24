package p9;

import java.util.*;

public class SpecialPythagoreanTriplet {


	public static void main(String[] args) {
		int asq = 0;
		int bsq = 0;
		int a = 0;
		int b = 0;
		List<Integer> alist = new ArrayList<Integer>();
		List<Integer> blist = new ArrayList<Integer>();
		List<Integer> clist = new ArrayList<Integer>();
		int aval = 0;
		int bval = 0;
		int cval = 0;
		int product = 0;
		
		for (a = 3; a < 300 ;a++) {
			asq = a * a;
			for (b = 4; b < 400; b++) {
				bsq = b * b;
				double csq = asq +bsq;
				double c = Math.sqrt(csq);
				if (c == (int) c) {
//					System.out.println(a + " " + b + " " + (int) c);
					alist.add(a);
					blist.add(b);
					clist.add((int)c);
				}
			}
		}
		
		for (int i = 0; i < alist.size(); i++) {
			aval = alist.get(i);
			bval = blist.get(i);
			cval = clist.get(i);
				if (aval + bval + cval == 1000) {
					product = aval * bval * cval;
					System.out.println("The product is: " + product);
				}
		}
		

	}

}
