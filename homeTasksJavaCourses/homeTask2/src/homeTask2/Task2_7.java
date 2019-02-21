package homeTask2;

import java.util.Scanner;

public class Task2_7 {
	
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
		
		//changing elements

		
		for (int i = 0; i < size/2; i++) {
			
			int value = mas[i];
			
			mas[i] = mas[size - i - 1];
			
			mas[size - i - 1] = value;
							
		}
		
		for (int i = 0; i < size; i++) {
			
			System.out.print(mas[i] + " ");
							
		}
		
	}

}
