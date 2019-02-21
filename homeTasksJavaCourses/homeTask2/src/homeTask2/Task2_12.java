package homeTask2;

import java.util.Scanner;

public class Task2_12 {
	
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
		
		System.out.println(" ");
		
		//define another array
		
		int [] mas2 = new int [size - 2];
		
		//changing elements

		
		for (int i = 0; i < size-2; i++) {
			
			mas2[i] = mas[i];
							
		}
		
		for (int i = 0; i < size - 2; i++) {
			
			System.out.print(mas2[i] + " ");
							
		}
		
	}

}
