package p21;

import java.util.*;

public class AmicableNums_Success {

	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int sumDivisorsi = 1;
		int sumDivisorsOfi = 1;
		int sumAmicable = 0;
		
		List<Integer> ignoreList = new ArrayList<Integer>();
		boolean mustIgnore = false;
		
		for (int i = 2; i < 10000; i++) {
			
			//search for i on IgnoreList
			
			for (int a = 0; a < ignoreList.size(); a++) {
				
				if (i == ignoreList.get(a)) {
					mustIgnore = true;
					break;
				}
			}
			
			//If !mustIgnore, execute main algorithm. Else, don't.
			
			if (!mustIgnore) {
				
				//find the sum of the proper divisors of i
				
				for (int n = 2; n < i; n++){
					if(i % n == 0){
					sumDivisorsi+= n;
					}
				}	
				
				//find the sum of the proper divisors of the sum of the proper divisors of i
				
				for (int n = 2; n < sumDivisorsi; n++){
					if(sumDivisorsi % n == 0){
					sumDivisorsOfi+= n;
					}
				}
				
				//if i == sumDivisorsOfi and i != sumDivisorsi, sumAmicable+= i + sumDivisorsi , 
				//add i and sumDivisorsOfi to ignoreList
				
				if (i == sumDivisorsOfi && i != sumDivisorsi) {
					sumAmicable+= sumDivisorsi + sumDivisorsOfi;
					ignoreList.add(sumDivisorsi);
					ignoreList.add(sumDivisorsOfi);
				}
				
			}
			
			sumDivisorsi = 1;
			sumDivisorsOfi = 1;
			mustIgnore = false;
			
		}
		
		System.out.println(sumAmicable);
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		System.out.println("Runtime: " +totalTime + " ms");

	}

}
