
public class Massive {
	
	public void printMassiveAsLine() {
		
		int [] sum = {1, 3, 4, 7};
		
		for (int i = 0; i < sum.length; i++) {
			
			System.out.print(sum[i]);
			
		}
	
	}
	
	public void printReverseMassiveAsLine() {
		
		int [] sum = {1, 3, 4, 7};
		
		for (int i = sum.length - 1; i >= 0; i--) {
			
			System.out.print(sum[i]);
			System.out.println(" ");
			
		}
		
	}
	
	public int getSumOfElements() {
		
		int [] sum = {1, 3, 4, 7};
		
		int sum_elements = 0;
		
		for (int i = 0; i < sum.length; i++) {
			
			sum_elements = sum_elements + sum[i];
			
		}
		
		System.out.println(sum_elements);
		
		return sum_elements;
		
	}
	
	

}
