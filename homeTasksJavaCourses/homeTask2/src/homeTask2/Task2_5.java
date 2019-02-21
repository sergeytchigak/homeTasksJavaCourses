package homeTask2;

import java.util.Scanner;

public class Task2_5 {
	
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
		
		for (int i = 0; i < size; i++) {
			
			if (mas[i] == 0) {
				
				System.out.println("Number of zero element is " + i);
				
				counter++;
				
			} 
			
		}
		
		if (counter == 0) {
		
			System.out.print("No zero values");
		
		}
		
	}

}
