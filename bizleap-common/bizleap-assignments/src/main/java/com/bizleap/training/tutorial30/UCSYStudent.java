package com.bizleap.training.tutorial30;

import com.bizleap.training.tutorial22.Gender;

public class UCSYStudent extends Student{

	public UCSYStudent() {
		super();
	}

	public UCSYStudent(String name, int age, Gender gender, String intstitution) {
		super(name, age, gender, intstitution);
	}

	@Override
	protected int getNameCharacterCount() {
		String str[] = getName().split("\\s+");
		return str[0].toCharArray().length + str[str.length-1].toCharArray().length;
	}

	@Override
	protected int getNameWordCount() {
		return 2;
	}	
}
