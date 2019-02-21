package homeTask2;

import java.util.Scanner;

public class Task2_4 {
	
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
				
				counter++;
				
			} 
			
		}
		
		if (counter > 0) {
		
			System.out.print(counter);
		
		} else {
		
			System.out.println("No zero values");
		
		} 
		
	}

}
