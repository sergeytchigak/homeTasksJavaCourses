package Example;

import Tester.Tester;

public class Example {

	public static void main(String[] args) {
		
		Tester tester = new Tester("Sergey", "Tchigak", 5, 300.5, "Upper");
		System.out.println(tester.multiplySalary()); //private method - not work
		tester.printName(); 
		tester.printAllInfo(); //protected method - other package not work

	}

}
