package homeTask2;

import java.util.Scanner;

public class Task2_9 {
	
	public static void main(String[] args) {
		
		//input array size
		
		Scanner in = new Scanner(System.in);
						
		int size = in.nextInt();
						
		//define new array
						
		int [] mas = new int [size];
						
		//fill in array with random int's
								
		for (int i = 0; i < size; i++) {
							
			mas[i] = 1 + (int)(Math.random()*size);
			
			System.out.print(mas[i] + " ");
							
		}
		
		//max and min element

		int max = mas[0];
		
		for (int i = 0; i < size; i++) {
			
				if (mas[i] > max) {
					
					max = mas[i];
					
					System.out.println("Max number is " + i);
				}
							
		}
		
		
		int min = mas[0];
		
		for (int i = 0; i < size; i++) {
			
			if (mas[i] < min) {
				
				min = mas[i];
				
				System.out.println("Min number is " + i);
				
			}
						
		}
							
	}

}
