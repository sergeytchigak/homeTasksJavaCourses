package homeTask7;

import java.util.Scanner;

public class homeTask7_5 {

	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
		
		int n = 18;
				
		String[] array = new String[n];
		
			for (int i = 0; i < n; i++) {
				
					array[i] = scan.nextLine();
					
				}
			
			scan.close();
			
				int counterNew = 0;
				
				int contEq = 0;
				
				for (int i = 0; i < n; i++) {
					
					if (array[i].matches("[a-zA-Z]+")) {
						
						counterNew++;
						
						if (isConsonantsEqualVowels(array[i])) {
							
							contEq++;
							
						}
						
					}
					
				}
				
			}


			public static boolean isConsonantsEqualVowels(String str) {
				int numVowel = contEq(str);
				return str.length() - numVowel == numVowel;

	}


			private static int contEq(String str) {
				
				return 0;
			}

}
