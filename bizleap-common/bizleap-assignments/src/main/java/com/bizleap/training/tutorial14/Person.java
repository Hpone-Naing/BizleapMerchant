package com.bizleap.training.tutorial14;

//Tutorial14
public class Person {

	private int age;

	public Person(int age) {
		super();
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public AgeCategory determineAgeCategory() {

		if (age < 0)
			return null;

		if (age >= 0 && age <= 12)
			return AgeCategory.CHILD;
		
		if (age >= 13 && age <= 18)
			return AgeCategory.ADOLESCENCE;

		if (age >= 19 && age <= 59)
			return AgeCategory.ADULT;

		return AgeCategory.SENIOR_ADULT;
	}

	public void displayPersonAge() {
		switch (determineAgeCategory()) {
		case CHILD:
			System.out.println("Child");
			break;

		case ADOLESCENCE:
			System.out.println("Adolescence");
			break;

		case ADULT:
			System.out.println("Adult");
			break;

		case SENIOR_ADULT:
			System.out.println("Senior Adult");
			break;

		}
	}

	public static void main(String[] args) {

		System.out.println(new Person(12).determineAgeCategory());
		new Person(3).displayPersonAge();

	}

}
