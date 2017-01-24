package p40;

import java.util.ArrayList;
import java.util.List;

public class ChampernowneConstant {

	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		String constant = "";
		int prod = 1;
		int digsize = 0;
		int constsize = 0;
		int curi = 0;
		int i = 0;
		
		
		while (constsize < 1000000)	{
			
			curi = i;
			
			while(i > 0) {
				
				i/=10;
				digsize++;
				
			}
			
			i = curi;
			i++;
			constsize += digsize;
			digsize = 0;
			
			constant = constant.concat(String.valueOf(i));
			
		}
		
		prod *= Character.getNumericValue(constant.charAt(0)) * Character.getNumericValue(constant.charAt(9))
				*Character.getNumericValue(constant.charAt(99)) * Character.getNumericValue(constant.charAt(999))
				*Character.getNumericValue(constant.charAt(9999)) * Character.getNumericValue(constant.charAt(99999))
				*Character.getNumericValue(constant.charAt(999999));
		
		System.out.println(prod);
		System.out.println("d_1 = " + Character.getNumericValue(constant.charAt(0)) + " d_10 = " + Character.getNumericValue(constant.charAt(9))
				+ " d_100 = " + Character.getNumericValue(constant.charAt(99))+ " d_1000 = " + Character.getNumericValue(constant.charAt(999))  
				+ " d_10000 = " + Character.getNumericValue(constant.charAt(9999)) + " d_100000 = " + Character.getNumericValue(constant.charAt(99999))
				+ " d_1000000 = " + Character.getNumericValue(constant.charAt(999999)));
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Runtime: " + totalTime + " ms");

	}

}
