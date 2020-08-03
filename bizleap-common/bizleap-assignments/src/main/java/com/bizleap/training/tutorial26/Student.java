package com.bizleap.training.tutorial26;

import java.util.List;
import java.util.Map;

public class Student {

	private String names;
	
	public Student(String names) {
		super();
		this.names = names;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public  Integer getNameWordCount() {

		String[] words = names.split("\\s+");
		return words.length;
	}
	
	public  Integer getNameCharacterCount() {

		int count = 0;
		for (String word : names.split("\\s+")) {
			count += word.toCharArray().length;
		}
		return count;
	}
	
	public boolean isContainWord(Map<Integer,List<Student>> studentWordMap) {
		return studentWordMap.containsKey(this.getNameWordCount());
	}
	
	public boolean isContainCharacter(Map<Integer,List<Student>> studenCharacterMap) {
		return studenCharacterMap.containsKey(this.getNameCharacterCount());
	}
	@Override
	public String toString() {
		return new StringBuilder().append("names=" + names).toString();
	}

}
