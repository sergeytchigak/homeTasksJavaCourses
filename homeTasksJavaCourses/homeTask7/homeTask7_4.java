package homeTask7;

import java.util.Arrays;
import java.util.Scanner;

public class homeTask7_4 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = 8;
		
		String[] array = new String[n];
		
		for (int i = 0; i < n; i++) {
			
			array[i] = scan.nextLine();
			
		}
		
		scan.close();
		
		int[] anylementsArray = countDistinct(array);
		
		int min = anylementsArray[0];
		
		int minIndex = 0;
		
		for (int i = 0; i < array.length; i++) {
			
			if (anylementsArray[i] < min) {
				
				min = anylementsArray[i];
				
				minIndex = i;
			}
		}

		System.out.println(array[minIndex]);

	}

	private static int[] countDistinct(String[] array) {
		
		return null;
	}

	public static String[] sortAsc(String[] array) {
		
		char[] chars = null;
		
		String[] sorted = new String[array.length];
		
		for (int i = 0; i < array.length; i++) {
			
		}
		return sorted;
	}


}
