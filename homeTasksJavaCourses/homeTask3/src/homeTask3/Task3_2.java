package homeTask3;

public class Task3_2 {
	
	public static void main(String[] args) {
		
		int a = 1 + (int)(Math.random()*100);
		
		boolean Z = devFunction(a);
		
		System.out.print(Z);
		
	}
	
	public static boolean devFunction(int n1) {
		
		   boolean boolValue;
		   
		   if (n1%2 == 0)
			   
			   boolValue = true;
		   
		   else
			   
			   boolValue = false;

		   return boolValue;
		   
		}

}