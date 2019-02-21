package homeTask2;

import java.util.Scanner;

public class Task2_2 {
	
	public static void main (String[] args) {
		
		//input array size
		
		Scanner in = new Scanner(System.in);
				
		int size = in.nextInt();
				
		//define new array
				
		int [] mas = new int [size];
				
		//fill in array with random int's
		
		int sum = 0;
						
		for (int i = 0; i < size; i++) {
					
			mas[i] = 1 + (int)(Math.random()*size);
					
		}
		
		//calculate sum
		
		for (int i = 0; i < size; i++) {
			
			sum = sum + mas[i];
					
		}
		
		System.out.println(sum);
		
	}

}
