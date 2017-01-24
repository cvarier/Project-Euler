package p17;

import java.util.*;

public class NumLetterCounts {


	public static void main(String[] args) {
		
		Hashtable<Integer, Integer> words = new Hashtable<Integer, Integer>();
		words.put(1, 3);
		words.put(2, 3);
		words.put(3, 5);
		words.put(4, 4);
		words.put(5, 4);
		words.put(6, 3);
		words.put(7, 5);
		words.put(8, 5);
		words.put(9, 4);
		words.put(10, 3);
		words.put(11, 6);
		words.put(12, 6);
		words.put(13, 8);
		words.put(14, 8);
		words.put(15, 7);
		words.put(16, 7);
		words.put(17, 9);
		words.put(18, 8);
		words.put(19, 8);
		words.put(20, 6);
		words.put(30, 6);
		words.put(40, 5);
		words.put(50, 5);
		words.put(60, 5);
		words.put(70, 7);
		words.put(80, 6);
		words.put(90, 6);
		words.put(100, 7);
		words.put(1000, 11);
		
		int sum99 = 0;
		int sumfin = 0;
		
		for (int i = 1; i < 100; i++) {
			if (i <= 20) {
				sum99 = sum99 + words.get(i);
			}
			if (i > 20  && i < 30) {						
				sum99 = sum99 + words.get(i - 20) + words.get(20);						
			}
			if (i > 30  && i < 40) {						
				sum99 = sum99 + words.get(i - 30) + words.get(30);						
			}
			if (i > 40  && i < 50) {						
				sum99 = sum99 + words.get(i - 40) + words.get(40);						
			}
			if (i > 50  && i < 60) {						
				sum99 = sum99 + words.get(i - 50) + words.get(50);						
			}
			if (i > 60  && i < 70) {						
				sum99 = sum99 + words.get(i - 60) + words.get(60);						
			}
			if (i > 70  && i < 80) {						
				sum99 = sum99 + words.get(i - 70) + words.get(70);						
			}
			if (i > 80  && i < 90) {						
				sum99 = sum99 + words.get(i - 80) + words.get(80);						
			}
			if (i > 90  && i < 100) {						
				sum99 = sum99 + words.get(i - 90) + words.get(90);						
			}
			if (i % 10 == 0 && i > 20) {
				sum99 = sum99 + words.get(i);
			}
		}
		
		for (int i = 101; i < 1000; i++) {
			
			if (i % 100 == 0) {			
				sumfin = sumfin + words.get(100) + words.get((i/100));
			} else {			
				sumfin = sumfin + 3 + words.get(100) + words.get((i/100));
			}
			
		}
		
		sumfin = sumfin + sum99*10 + words.get(100) + 3 + words.get(1000);
		
		System.out.println(sumfin);
	}
}
