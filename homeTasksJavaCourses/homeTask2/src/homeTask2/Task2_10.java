package homeTask2;

import java.util.Scanner;

public class Task2_10 {
	
	public static void main (String[] args) {
		
		//input array size
		
		Scanner in = new Scanner(System.in);
								
		int size = in.nextInt();
								
		//define new array
								
		int [] mas = new int [size];
	
		for (int i = 0; i < size; i++) {
			
			mas[i] = in.nextInt();
			
		}
		
		int counter = 0;
		
		for (int i = 0; i < size - 1; i++) {
			
			if (mas[i] < mas[i + 1]) {
				
				counter++;
				
			} 
			
		}
		if (counter == (size - 1)) {
			
			System.out.print("Array growing");
			
		} else {
			
			System.out.print("Array non-growing");
			
		}
			
	}

}
