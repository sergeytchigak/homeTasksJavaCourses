package homeTask9;

public class Sirius extends Star{
	
	double size;
	
	boolean isThereMagntticStorm;
	
	public void Sirius() {
		
		
	}
	
	public Sirius(double size) {
		
		this.size = size;
		
	}
	
	public Sirius(double size, boolean isThereMagntticStorm) {
		
		this.size = size;
		
		this.isThereMagntticStorm = isThereMagntticStorm;
		
	}
	
	public void printSiriusInfo() {
		
		System.out.println(size);
		System.out.println(isThereMagntticStorm);
		
	}

}
