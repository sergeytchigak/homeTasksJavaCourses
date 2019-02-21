package homeTask2;

import java.util.Scanner;

public class Task2_11 {
	
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
			
			System.out.println(" ");
							
		}
		
		//changing elements

		
		for (int i = 1; i < size-1; i++) {
			
			
			
			mas[i] = (mas[i+1] + mas[i-1])/2;
			
			
							
		}
		
		for (int i = 0; i < size; i++) {
			
			
			System.out.print(mas[i] + " ");
							
		}
		
	
	}

}
