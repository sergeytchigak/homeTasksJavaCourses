package homeTask9;

public class Example {

	public static void main(String[] args) {
		
		Planet planet = new Planet();
		planet.printMyName();
		
		Star star = new Star();
		star.printMyName();
		
		Earth earth = new Earth();
		earth.setNumberOfContinents(5);
		earth.getNumberOfContinents();
		earth.setPlanetPopulation(9.3);
		earth.getPlanetPopulation();
		
		Sun sun = new Sun(134.4, true);
		Sirius sirius = new Sirius(120.1, false);
	}

}
