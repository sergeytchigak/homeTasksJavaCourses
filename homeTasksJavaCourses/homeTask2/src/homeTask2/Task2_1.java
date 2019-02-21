package homeTask2;

import java.util.Scanner;

public class Task2_1 {
	
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
		
		//direct output
		
		for (int i = 0; i < size; i++) {
			
			System.out.println(mas[i]);
			
		}
		
		//reverse output
		
		for (int i = size - 1; i >= 0; i--) {
			
			System.out.println(mas[i]);
			
		}
		
	}

}
