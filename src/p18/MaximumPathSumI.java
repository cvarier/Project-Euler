package p18;

public class MaximumPathSumI {

	
	public static void main(String[] args) {
		
//---------------------------STRING TO INT CONVERSION------------------------------------------     
		
		long startTime = System.currentTimeMillis();
		
		String Tri = ("75 " +
				      "95 64 " +
				      "17 47 82 " +
				      "18 35 87 10 " +
				      "20 04 82 47 65 " +
				      "19 01 23 75 03 34 " +
				      "88 02 77 73 07 63 67 " +
				      "99 65 04 28 06 16 70 92 " +
				      "41 41 26 56 83 40 80 70 33 " +
				      "41 48 72 33 47 32 37 16 94 29 " +
	       			  "53 71 44 65 25 43 91 52 97 51 14 " +
				      "70 11 33 28 77 73 17 78 39 68 17 57 " +
				      "91 71 52 38 17 14 91 43 58 50 27 29 48 " +
				      "63 66 04 68 89 53 67 30 73 16 69 87 40 31 " +
				      "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23 ");
		
		String[] Trinums = Tri.split(" ");
		
		int[] tri = new int[Trinums.length];
		
		for (int i = 0; i < Trinums.length; i++) {
			
			tri[i] = Integer.parseInt(Trinums[i]);
			
		}
		
//------------------------------ALGORITHM FOR CALCULATING MAXIMUM PATH SUM---------------------
		
//-------------sum is the array of maximum sums obtained by comparing suml and sumr------------
//------------------maxi is the maximum index value for the current row of the triangle--------
		
		int [] sum;
		int numl = 0;
		int numr = 0;
		int counter = 0;
		int maxi = Trinums.length -16;
		
		for (int a = 14; a > 0; a--){
			
			sum = new int[a];
			
			for (int i = maxi; i > maxi - a; i --){				
				
				numl = tri[i + a];
				
				numr = tri[i + a +1];
				
					if (numl > numr) {
						sum[counter] = tri[i] + tri[i + a];
					}
					if (numr > numl) {
						sum[counter] = tri[i] + tri[i + a +1];
					}
				
				counter ++;
				
				numl = 0;
				numr = 0;
			}
			
			counter = 0;
			
//------Replace bottom (always current) row in tri with sum values and all sum values with 0-------		
			
			if (a <= 1) {
			System.out.println(sum[0]);
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Runtime: " + totalTime + " ms");
			}


			for (int b = 0; b < sum.length; b ++) {
				
				tri[maxi - b] = sum[b];
				sum[b] = 0;
				
			}
				
			maxi = maxi - a;
				
			
		}
			
	
	}

}
