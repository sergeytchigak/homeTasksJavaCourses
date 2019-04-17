package homeTask7;

import java.util.Scanner;

public class homeTask7_6 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = 10;
				
		String[] array = new String[n];
	
		for (int i = 0; i < n; i++) {
			
			array[i] = scan.nextLine();
					
		}
		
		scan.close();
				
}

	private static boolean hasChar(String str) {
				
		char chars[] = str.toCharArray();
				
		int count = 0;
				
		for (int i = 1; i < chars.length; i++) {
					
			if (chars[i - 1] < chars[i]) {
						
				count++;
						
			}
		
		}
				
		return (count == chars.length - 1);

	}

}
