package homeTask2;

import java.util.Scanner;

public class Task2_3 {
	
	public static void main (String[] args) {
		
		//input array size
		
		Scanner in = new Scanner(System.in);
						
		int size = in.nextInt();
						
		//define new array
						
		int [] mas = new int [size];
						
		//fill in array with random int's
								
		for (int i = 0; i < size; i++) {
							
			mas[i] = 1 + (int)(Math.random()*size);
							
		}
		
		//Option 1
		
		for (int i = 0; i < size; i++) {
			
			if (i % 3 == 0) {
				
				mas[i] = mas[i] * 2;
				
				System.out.println(mas[i]);
				
			}
							
		}
		
		//Option 2 (using new array)
		
		int [] mas2 = new int [size];
		
		for (int i = 0; i < size; i++) {
			
			mas[i] = 1 + (int)(Math.random()*size);
							
		}
		
		for (int i = 0; i < size; i++) {
			
			if (i % 3 == 0) {
				
				mas2[i] = mas[i] * 2;
				
				System.out.println(mas2[i]);
				
			}
							
		}
		
	}

}
