package p83;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PathSumFourWays {
	
	// Function for getting entire text from file as string
	
	static String readFile() throws IOException {
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(PathSumFourWays.class
					.getResource("/p83/p083_matrix.txt").toURI()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(encoded, "UTF-8");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		String Matrix = "";
		
		// Get the matrix string from the text file

		try {
			Matrix = readFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Convert the matrix string to an array of strings holding each of the
		// cell values

		String[] Matrixnums = Matrix.split(",|\\r?\\n");

		int[][] numscopy = new int[80][80]; // ORDER IS (y,x)!!!

		int length = numscopy.length - 1;

		int counter = 0;
		
		// Fill an 80 by 80 two dimensional int array with the matrix cell values
		// (as ints)

		for (int a = 0; a <= length; a++) {

			for (int b = 0; b <= length; b++) {

				numscopy[a][b] = Integer.parseInt(Matrixnums[counter]);
				counter++;

			}

		}

		counter = 0;

		// -------------------Minimum Path Algorithm----------------------

		// heurisitc

		int minnum = numscopy[0][0];
		int[][] hscore = new int[length + 1][length + 1];
		int mult = 1;

		// find value of minnum

		for (int a = 0; a <= length; a++) {

			for (int b = 0; b <= length; b++) {

				if (numscopy[a][b] < minnum) {

					minnum = numscopy[a][b];

				}
			}
		}

		// calculate H-score values and store them in array hscore

		for (int a = 0; a <= length; a++) {

			for (int b = 0; b <= length; b++) {

				mult = length + 1 - b + length - a;

				hscore[a][b] = mult * minnum;

			}
		}

		// lists
		ArrayList<Integer> openListi = new ArrayList<Integer>();
		ArrayList<Integer> openListj = new ArrayList<Integer>();
		ArrayList<Integer> closedListi = new ArrayList<Integer>();
		ArrayList<Integer> closedListj = new ArrayList<Integer>();

		// G-score matrix

		int[][] gscore = new int[length + 1][length + 1];

		for (int a = 0; a <= length; a++) {

			for (int b = 0; b <= length; b++) {

				gscore[a][b] = Integer.MAX_VALUE;

			}
		}

		gscore[0][0] = numscopy[0][0];

		// F-score matrix

		int[][] fscore = new int[length + 1][length + 1];

		for (int a = 0; a <= length; a++) {

			for (int b = 0; b <= length; b++) {

				fscore[a][b] = 0;

			}
		}

		// Parent Square Matrix

		String[][] parentsquare = new String[length + 1][length + 1];

		for (int a = 0; a <= length; a++) {

			for (int b = 0; b <= length; b++) {

				parentsquare[a][b] = " ";

			}
		}

		String[][] minimalpath = new String[length + 1][length + 1];

		for (int a = 0; a <= length; a++) {

			for (int b = 0; b <= length; b++) {

				minimalpath[a][b] = " ";

			}
		}

		// ----------------------More Variables and
		// Initializations----------------

		openListi.add(0);
		openListj.add(0);

		int y = 0; // i refers to y and j refers to x coordinate wise
		int x = 0;
		int minfscore = 0;
		int openListIndex = 0;

		int numrx = 0;
		int numlx = 0;
		int numdy = 0;
		int numuy = 0;
		boolean numrclosed = false;
		boolean numlclosed = false;
		boolean numdclosed = false;
		boolean numuclosed = false;
		boolean numropen = false;
		boolean numlopen = false;
		boolean numdopen = false;
		boolean numuopen = false;
		boolean isfinished = false;
		boolean newminfscore = false;

		int numrbuffer = 0; // Force exception to be caught early if
		int numlbuffer = 0; // any adjacent square doesn't exist
		int numdbuffer = 0;
		int numubuffer = 0;

		// --------------------Main Loop----------------------

		while (!isfinished) {

			numrclosed = false;
			numlclosed = false;
			numdclosed = false;
			numuclosed = false;
			numropen = false;
			numlopen = false;
			numdopen = false;
			numuopen = false;
			newminfscore = false;

			// find square with minfscore in openList, remove it from openList
			// and add it to closedList

			minfscore = fscore[openListi.get(0)][openListj.get(0)];

			for (int i = 0; i < openListi.size(); i++) {

				if (fscore[openListi.get(i)][openListj.get(i)] < minfscore) {

					minfscore = fscore[openListi.get(i)][openListj.get(i)];
					y = openListi.get(i);
					x = openListj.get(i);
					openListIndex = i;
					newminfscore = true;

				}

			}

			if (newminfscore) {
				closedListi.add(openListi.get(openListIndex));
				closedListj.add(openListj.get(openListIndex));

				openListi.remove(openListIndex);
				openListj.remove(openListIndex);
			} else {

				y = openListi.get(0);
				x = openListj.get(0);
				closedListi.add(openListi.get(0));
				closedListj.add(openListj.get(0));

				openListi.remove(0);
				openListj.remove(0);

			}

			/*
			 * find the four adjacent squares (do nothing if it is
			 * non-existent), and see if they are on the closedList. If they are
			 * ignore them. Otherwise, see if they are on the openList. If a
			 * square isn't, add it, and update its F and G costs on the
			 * matrices. Otherwise if it is, recalculate the G and F cost
			 * leading to that square, and see if they are smaller in the end.
			 * Update the G and F score matrices.
			 */

			try {

				numrx = x + 1;
				numrbuffer = numscopy[y][numrx];

				for (int j = 0; j < closedListi.size(); j++) {
					if (closedListi.get(j) == y && closedListj.get(j) == numrx) {
						numrclosed = true;
						break;
					} else {
						numrclosed = false;
					}
				}
				if (numrclosed) {
				} else {
					for (int n = 0; n < openListi.size(); n++) {
						if (openListi.get(n) == y && openListj.get(n) == numrx) {
							numropen = true;
							break;
						} else {
							numropen = false;
						}
					}
					if (numropen) {
						if (numscopy[y][numrx] + gscore[y][x] < gscore[y][numrx]) {
							gscore[y][numrx] = numscopy[y][numrx]
									+ gscore[y][x];
							fscore[y][numrx] = gscore[y][numrx]
									+ hscore[y][numrx];
							parentsquare[y][numrx] = "←";
						}
					} else {
						openListi.add(y);
						openListj.add(numrx);
						gscore[y][numrx] = numscopy[y][numrx] + gscore[y][x];
						fscore[y][numrx] = gscore[y][numrx] + hscore[y][numrx];
						parentsquare[y][numrx] = "←";
					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {

				numlx = x - 1;
				numlbuffer = numscopy[y][numlx];

				for (int j = 0; j < closedListi.size(); j++) {
					if (closedListi.get(j) == y && closedListj.get(j) == numlx) {
						numlclosed = true;
						break;
					} else {
						numlclosed = false;
					}
				}
				if (numlclosed) {
				} else {
					for (int n = 0; n < openListi.size(); n++) {
						if (openListi.get(n) == y && openListj.get(n) == numlx) {
							numlopen = true;
							break;
						} else {
							numlopen = false;
						}
					}
					if (numlopen) {
						if (numscopy[y][numlx] + gscore[y][x] < gscore[y][numlx]) {
							gscore[y][numlx] = numscopy[y][numlx]
									+ gscore[y][x];
							fscore[y][numlx] = gscore[y][numlx]
									+ hscore[y][numlx];
							parentsquare[y][numlx] = "→";
						}
					} else {
						openListi.add(y);
						openListj.add(numlx);
						gscore[y][numlx] = numscopy[y][numlx] + gscore[y][x];
						fscore[y][numlx] = gscore[y][numlx] + hscore[y][numlx];
						parentsquare[y][numlx] = "→";
					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {

				numdy = y + 1;
				numubuffer = numscopy[numdy][x];

				for (int j = 0; j < closedListi.size(); j++) {
					if (closedListi.get(j) == numdy && closedListj.get(j) == x) {
						numdclosed = true;
						break;
					} else {
						numdclosed = false;
					}
				}
				if (numdclosed) {
				} else {
					for (int n = 0; n < openListi.size(); n++) {
						if (openListi.get(n) == numdy && openListj.get(n) == x) {
							numdopen = true;
							break;
						} else {
							numdopen = false;
						}
					}
					if (numdopen) {
						if (numscopy[numdy][x] + gscore[y][x] < gscore[numdy][x]) {
							gscore[numdy][x] = numscopy[numdy][x]
									+ gscore[y][x];
							fscore[numdy][x] = gscore[numdy][x]
									+ hscore[numdy][x];
							parentsquare[numdy][x] = "↑";
						}
					} else {
						openListi.add(numdy);
						openListj.add(x);
						gscore[numdy][x] = numscopy[numdy][x] + gscore[y][x];
						fscore[numdy][x] = gscore[numdy][x] + hscore[numdy][x];
						parentsquare[numdy][x] = "↑";
					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {

				numuy = y - 1;
				numubuffer = numscopy[numuy][x];

				for (int j = 0; j < closedListi.size(); j++) {
					if (closedListi.get(j) == numuy && closedListj.get(j) == x) {
						numuclosed = true;
						break;
					} else {
						numuclosed = false;
					}
				}
				if (numuclosed) {
				} else {
					for (int n = 0; n < openListi.size(); n++) {
						if (openListi.get(n) == numuy && openListj.get(n) == x) {
							numuopen = true;
							break;
						} else {
							numuopen = false;
						}
					}
					if (numuopen) {
						if (numscopy[numuy][x] + gscore[y][x] < gscore[numuy][x]) {
							gscore[numuy][x] = numscopy[numuy][x]
									+ gscore[y][x];
							fscore[numuy][x] = gscore[numuy][x]
									+ hscore[numuy][x];
							parentsquare[numuy][x] = "↓";
						}
					} else {
						openListi.add(numuy);
						openListj.add(x);
						gscore[numuy][x] = numscopy[numuy][x] + gscore[y][x];
						fscore[numuy][x] = gscore[numuy][x] + hscore[numuy][x];
						parentsquare[numuy][x] = "↓";
					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {

			}

			// stop when finish square is in closed list

			for (int m = 0; m < closedListi.size(); m++) {
				if (closedListi.get(m) == length
						&& closedListj.get(m) == length) {
					isfinished = true;
				}
			}

		}

		System.out.println("The answer is: " + gscore[length][length]);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Runtime: " + totalTime + " ms");
		System.out.println();
		System.out.println();
		System.out.println("The minimal path is: ");

		// Tracing minimal path

		y = length;
		x = length;

		while (y != 0 || x != 0) {

			if (parentsquare[y][x].equals("↑")) {

				minimalpath[y][x] = "↓";
				y--;

			} else if (parentsquare[y][x].equals("↓")) {

				minimalpath[y][x] = "↑";
				y++;

			} else if (parentsquare[y][x].equals("→")) {

				minimalpath[y][x] = "←";
				x++;

			} else {

				minimalpath[y][x] = "→";
				x--;

			}

		}

		minimalpath[0][0] = "◘";

		for (int q = 0; q <= length; q++) {

			for (int c = 0; c <= length; c++) {
				if (q != length | c != length) {
					System.out.print(minimalpath[q][c] + "");
				} else {
					System.out.print(minimalpath[q][c]);
				}

			}

			System.out.println("");

		}

	}

}
