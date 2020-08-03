package com.bizleap.training.tutorial30;

import com.bizleap.training.tutorial22.Gender;

public class Person {

	private String name;
	private int age;
	private Gender gender;

	public Person() {
		super();
	}

	public Person(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isMale() {
		return this.gender.equals(Gender.MALE);
	}

	public boolean isFemale() {
		return this.gender.equals(Gender.FEMALE);
	}

	protected int getNameWordCount() {
		return getName().split("\\s").length;
	}

	protected int getNameCharacterCount() {
		int count = 0;
		for (String word : getName().split("\\s+")) {
			count += word.toCharArray().length;
		}
		return count;
	}
}
