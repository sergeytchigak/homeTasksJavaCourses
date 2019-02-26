package homeTask9;

public class Sun extends Star{
	
	double size;
	
	boolean isThereMagntticStorm;
	
	
	public Sun(double size) {
		this.size = size;
	}
	
	public Sun(double size, boolean isThereMagntticStorm) {
		this(size);
		this.isThereMagntticStorm = isThereMagntticStorm;
	}
}
