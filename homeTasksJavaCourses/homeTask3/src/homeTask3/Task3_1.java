package homeTask3;

public class Task3_1 {
	
	public static void main(String[] args) {
		
		
		int a = 1 + (int)(Math.random()*100);
		
		int b = 1 + (int)(Math.random()*100);
		
		
		int Z = minFunction(a, b);
		
		System.out.print(Z);
		
	}
	
	public static int minFunction(int n1, int n2) {
		
		   int min;
		   
		   if (n1 > n2)
			   
		      min = n2;
		   
		   else
			   
		      min = n1;

		   return min;
		   
		}

}
