package com.bizleap.training.tutorial30;

import com.bizleap.training.tutorial22.Gender;

public class OtherStudent extends Student{

	public OtherStudent() {
		super();
	}

	public OtherStudent(String name, int age, Gender gender, String intstitution) {
		super(name, age, gender, intstitution);
	}
	
	@Override
	protected int getNameWordCount() {
		return super.getNameWordCount();
	}

	@Override
	protected int getNameCharacterCount() {
		return super.getNameCharacterCount();
	}

}
