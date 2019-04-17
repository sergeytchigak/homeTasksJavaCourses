package homeTask7;

import java.util.Arrays;
import java.util.Scanner;

public class homeTask7_7 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = 9;
		
		String[] array = new String[n];
		
		
		for (int i = 0; i < n; i++) {
			
			array[i] = scan.nextLine();
			
		}
		
		scan.close();
		
		int[] countDistinct = countDistinct(array);

	}

	private static int[] countDistinct(String[] array) {
		
		return null;
	}

	public static String[] sortAsc(String[] array) {
		
		char[] chars = null;
		
		String[] newArrayL = new String[array.length];
		
		for (int i = 0; i < array.length; i++) {
			
			chars = array[i].toCharArray();
			
			Arrays.sort(chars);
			
			newArrayL[i] = String.valueOf(chars);
			
		}
		
		return newArrayL;
	}

}
