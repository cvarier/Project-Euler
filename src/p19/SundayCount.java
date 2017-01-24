package p19;
import java.util.*;

public class SundayCount {


	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		int years = 100;     //100 years in a century
		int months = 12;     //12 months in a year
		
		int sundays = 0;
		ArrayList<Integer> dayslist = new ArrayList<Integer>();
		
		int[][][] days = new int [100][12][];
		
		for (int i = 1901; i < years+1901; i++) {
			
			if (i % 4 == 0 && i % 100 != 0) {         //If the year is a leap year and not a 
													  //century	
				for (int j = 0; j < months; j++) {
					
					if (j == 3 || j == 5 || j == 8|| j == 10) {
						
						days[i-1901][j] = new int[30];
						
						for (int k = 1; k <= 30; k++) {
						
							days[i-1901][j][k-1] = k;
						
						}
					
					} else if (j == 1) {
						
						days[i-1901][j] = new int[29];
						
						for (int k = 1; k <= 29; k++) {
							
							days[i-1901][j][k-1] = k;
						
						}
						
					} else {
						
						days[i-1901][j] = new int[31];
						
						for (int k = 1; k <= 31; k++) {
						
							days[i-1901][j][k-1] = k;
						
						}
						
					}
					
				}
				
			} else if (i % 400 == 0 && i % 100 == 0) {	//If the year is a leap year and a 
				  										//century
				for (int j = 0; j < months; j++) {
					
					if (j == 3 || j == 5 || j == 8|| j == 10) {
						
						days[i-1901][j] = new int[30];
						
						for (int k = 1; k <= 30; k++) {
						
							days[i-1901][j][k-1] = k;
						
						}
					
					} else if (j == 1) {
						
						days[i-1901][j] = new int[29];
						
						for (int k = 1; k <= 29; k++) {
							
							days[i-1901][j][k-1] = k;
						
						}
						
					} else {
						
						days[i-1901][j] = new int[31];
						
						for (int k = 1; k <= 31; k++) {
						
							days[i-1901][j][k-1] = k;
						
						}
						
					}
					
				}
				
				
			} else if (i % 400 != 0 && i % 100 == 0) { 	//If the year is a century but not a
														//leap year
				for (int j = 0; j < months; j++) {
					
					if (j == 3 || j == 5 || j == 8|| j == 10) {
						
						days[i-1901][j] = new int[30];
						
						for (int k = 1; k <= 30; k++) {
						
							days[i-1901][j][k-1] = k;
						
						}
					
					} else if (j == 1) {
						
						days[i-1901][j] = new int[28];
						
						for (int k = 1; k <= 28; k++) {
							
							days[i-1901][j][k-1] = k;
						
						}
						
					} else {
						
						days[i-1901][j] = new int[31];
						
						for (int k = 1; k <= 31; k++) {
						
							days[i-1901][j][k-1] = k;
						
						}
						
					}
					
				}
				
			} else {									//If the year is neither a leap year nor a 
														//century
				for (int j = 0; j < months; j++) {
					
					if (j == 3 || j == 5 || j == 8|| j == 10) {
						
						days[i-1901][j] = new int[30];
						
						for (int k = 1; k <= 30; k++) {
						
							days[i-1901][j][k-1] = k;
						
						}
					
					} else if (j == 1) {
						
						days[i-1901][j] = new int[28];
						
						for (int k = 1; k <= 28; k++) {
							
							days[i-1901][j][k-1] = k;
						
						}
						
					} else {
						
						days[i-1901][j] = new int[31];
						
						for (int k = 1; k <= 31; k++) {
						
							days[i-1901][j][k-1] = k;
						
						}
						
					}
					
				}
				
			}
			
		}
		
		for (int a = 0; a < years; a ++) {
			
			for (int b = 0; b < months; b ++) {
				
				for (int c = 0; c < days[a][b].length; c++) {
					
					dayslist.add(days[a][b][c]);
					
				}
				
			}
			
		}
		
		for (int n = 5; n < dayslist.size(); n += 7) {
			
			if (dayslist.get(n) == 1) {
				
				sundays++;
				
			}
			
		}
		
		System.out.println(dayslist);
		System.out.println("The answer is: "+ sundays + " sundays");
		System.out.println("Runtime is: " + totalTime);

	}

}
