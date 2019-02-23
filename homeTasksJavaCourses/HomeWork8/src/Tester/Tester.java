package Tester;

public class Tester {
	
	public String name;
	private String surname;
	int expirienceInYears;
	protected double salary;
	public String englishLevel;
	
	private Tester(String name, String surname, int expirienceInYears) {
		this.name = name;
		this.surname = surname;
		this.expirienceInYears = expirienceInYears;
	}
	
	private Tester(String name, String surname, int expirienceInYears, double salary) {
		this(name, surname, expirienceInYears);
		this.salary = salary;	
	}
	
	public Tester(String name, String surname, int expirienceInYears, double salary, String englishLevel) {
		this(name, surname, expirienceInYears, salary);
		this.englishLevel = englishLevel;	
	}
	
	protected String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected String getSurname() {
		return surname;
	}
	
	protected void setSurname(String surname) {
		this.surname = surname;
	}
	
	protected int getExpirienceInYears() {
		return expirienceInYears;
	}
	
	protected void setExpirienceInYears(int expirienceInYears) {
		this.expirienceInYears = expirienceInYears;
	}
	
	protected double getSalary() {
		return salary;
	}
	
	protected void setSalary(double salary) {
		this.salary = salary;
	}
	
	protected String getEnglishLevel() {
		return englishLevel;
	}
	
	protected void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}
	
	private double multiplySalary() {
		return salary*2;
	}
	
	protected void printName() {
		System.out.println(getName() + getSurname());
	}
	
	public void printAllInfo() {
		System.out.println(getName() + getSurname() + getSalary() + getExpirienceInYears() + getSalary() + getEnglishLevel());
	}
}
