package homeTask3;

public class Task3_3 {
	
	public static void main(String[] args) {
		
		int a = 1 + (int)(Math.random()*100);
		
		System.out.println(a);
		
		int Z = sqrFunction(a);
		
		System.out.print(Z);
		
	}
	
	public static int sqrFunction(int n1) {
	
		   return n1*n1;
		   
		}

}