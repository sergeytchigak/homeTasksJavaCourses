package homeTask7;

import java.util.Scanner;

public class homeTask7_2 {

	public static void main(String[] args) {
		
		System.out.println("Input string number: ");
		
        Scanner scanner1 = new Scanner(System.in);
		
        int n = scanner1.nextInt();
        
        String[] str = new String[n];
        
        Scanner scanner2 = new Scanner(System.in);
        
        for (int i = 0; i < n; i++) {
        	
        	str[i] = scanner2.nextLine();
        	
        }
        
        for (int i = n - 1; i > 0; i--) {
        	
        	for (int j = 0 ; j < i ; j++) {
        		
        		if( str[j].length() > str[j+1].length() ) {
        			
                    String tmp = str[j];
                    
                    str[j] = str[j+1];
                    
                    str[j+1] = tmp;
                }
        		
        	}
        	
        }
        
        for (int i = 0; i < n; i++) {
        	
        	System.out.println(str[i]);
        	
        }
        
        for (int j = 0; j < n; j++) {
        	
            for (int k = 0; k < n - 1; k++) {
            	
                if (str[k].length() < str[k + 1].length()) {
                	
                    String tmp = str[k];
                    
                    str[k] = str[k + 1];
                    
                    str[k + 1] = tmp;
                    
                }
            }
		}
        
        for (int i = 0; i < n; i++) {
        	
        	System.out.println(str[i]);
        	
        }
	}

}
