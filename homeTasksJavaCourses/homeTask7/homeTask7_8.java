package homeTask7;

import java.util.Scanner;

public class homeTask7_8 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = 10;
		
		String[] array = new String[n];
		
		System.out.println("Enter " + n + " strings");
		
		for (int i = 0; i < n; i++) {
			
			array[i] = scan.nextLine();
			
		}
		
		scan.close();
		
	}

	public static boolean isPalindrome(String str) {
		
		for (int i = 0; i < str.length() / 2; i++) {
			
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				
				return false;
				
			}

		}
		
		return true;
	}

}
