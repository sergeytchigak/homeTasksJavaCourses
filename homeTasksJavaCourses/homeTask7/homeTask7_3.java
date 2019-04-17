package homeTask7;

import java.util.Scanner;

public class homeTask7_3 {

	public static void main(String[] args) {
		
		System.out.println("Input string number: ");
		
        Scanner scanner1 = new Scanner(System.in);
		
        int n = scanner1.nextInt();
        
        String[] str = new String[n];
        
        Scanner scanner2 = new Scanner(System.in);
        
        for (int i = 0; i < n; i++) {
        	
        	str[i] = scanner2.nextLine();
        	
        }
        
        int sumLength = 0;
        
        for (int i = 0; i < n; i++) {
        	
        	sumLength += str[i].length();
        	
        }
        
        
        double avvSum = sumLength / n;
        
        
        for (int i = 0; i < n; i++) {
        	
        	if ((double)str[i].length() > avvSum ) {
        		
        		System.out.println(str[i] + " " + str[i].length());
        		
        	}
        	
        }
        
        for (int i = 0; i < n; i++) {
        	
        	if ((double)str[i].length() < avvSum ) {
        		
        		System.out.println(str[i] + " " + str[i].length());
        		
        	}
        	
        }

	}

}
