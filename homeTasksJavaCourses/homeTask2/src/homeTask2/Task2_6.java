package homeTask2;

import java.util.Scanner;

public class Task2_6 {
	
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
		
		//changing elements

		
		for (int i = 0; i < size-1; i++) {
			
			int value = mas[i];
			
			mas[i] = mas[i+1];
			
			mas[i+1] = value;
							
		}
		
		for (int i = 0; i < size; i++) {
			
			
			System.out.print(mas[i] + " ");
							
		}
		
	
	}

}
