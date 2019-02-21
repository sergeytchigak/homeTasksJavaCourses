
public class Example {

	public static void main(String[] args) {
		
		//class Person
		
		Person person = new Person();
		
		person.setAge(25);
		person.setName("Sergey");
		person.setPhone(5788350);
		person.setSurname("Tchigak");
		
		person.isAdult();
		person.printAllInformation();
		person.printName();
		
		
		//class Massive
		
		Massive massive = new Massive();
		
		massive.printMassiveAsLine();
		massive.getSumOfElements();
		massive.printReverseMassiveAsLine();

	}

}
