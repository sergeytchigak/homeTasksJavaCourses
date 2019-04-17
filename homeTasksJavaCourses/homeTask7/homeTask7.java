package homeTask7;

import java.util.Scanner;

public class homeTask7 {
	
	public static void main(String[] args) {
		
		System.out.println("Input string number: ");
		
        Scanner scanner1 = new Scanner(System.in);
		
        int n = scanner1.nextInt();
        
        String[] str = new String[n];
        
        Scanner scanner2 = new Scanner(System.in);
        
        for (int i = 0; i < n; i++) {
        	
        	str[i] = scanner2.nextLine();
        	
        }
        
        String min = str[0];
        
        for (int i = 0; i < n; i++) {
        	
        	if (str[i].length() < str[0].length()) {
        		
        		min = str[i];
        		
        	}
        	
        }
        
        System.out.println(min + " " + min.length());
       
	}
	
}
