package com.bizleap.training.tutorial30;

import com.bizleap.training.tutorial22.Gender;

public class Student extends Person {
	
	private String institution;

	public Student() {
		super();
	}

	public Student(String name, int age, Gender gender,String intstitution) {
		super(name, age, gender);
		this.institution=intstitution;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public boolean isUCSY() {
		return this.institution.equals("UCSY");
	}

	@Override
	protected int getNameWordCount() {
		return super.getNameWordCount();
	}

	@Override
	protected int getNameCharacterCount() {
		return super.getNameCharacterCount();
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("name=" + getName() + " , institution=" + institution ).toString();
	}
}
