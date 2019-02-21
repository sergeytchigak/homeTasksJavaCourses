
public class Person {
	
	String name;
	
	String surname;
	
	int age;
	
	int phone;
	
	//getters and setters
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setSurname(String surname) {
		
		this.surname = surname;
		
	}
	
	public void setAge(int age) {
		
		this.age = age;
		
	}
	
	public void setPhone(int phone) {
		
		this.phone = phone;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public String getSurname() {
		
		return this.surname;
		
	}
	
	public int getAge() {
		
		return this.age;
		
	}
	
	public int getPhone() {
		
		return this.phone;
		
	}
	
	//methods
	
	public void printAllInformation() {
		
		System.out.println(getName() + getSurname() + getAge() + getPhone());
		
	}
	
	public void printName() {
		
		System.out.println(getName() + getSurname());
		
	}
	
	public boolean isAdult() {
		
			if (getAge() > 18) {
				
				System.out.println(true);
				
				return true;
				
			} else {
				
				System.out.println(false);
				
				return false;
				
			}
		
	}

}
