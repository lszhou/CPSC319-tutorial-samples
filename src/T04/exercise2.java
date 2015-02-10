package T04;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class exercise2 {
	public static void main(String[] args) throws FileNotFoundException {

		int[] arr = new int[Integer.parseInt(args[0])];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}

		long startConsole = System.nanoTime();
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}
		long endConsole = System.nanoTime();
		System.out.println("Console Printing running time is "
				+ (endConsole - startConsole) + " nanoseconds.");

		long startTxt = System.nanoTime();
		PrintWriter out = new PrintWriter("myFile.txt");
		for (int j = 0; j < arr.length; j++) {
			out.println(arr[j]);
		}	
		long endTxt = System.nanoTime();
		out.println(".txt Printing Running Time: " + (endTxt - startTxt) + " nanoseconds.");
		out.close();
		
	}

}
