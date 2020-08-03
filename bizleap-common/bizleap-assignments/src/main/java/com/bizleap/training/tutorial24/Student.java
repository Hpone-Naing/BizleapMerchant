package com.bizleap.training.tutorial24;

import java.time.LocalTime;
import java.util.*;

public class Student {

	private String name;

	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("name=" + name).toString();
	}

	public LocalTime arrive() {
		return LocalTime.now();
	}

	public String award() {
		return this.name + " get cetificate.";
	}

	public static void main(String[] args) {

		for (HashMap<Student, LocalTime> item : StudentUtil.getAllStudents()) {
			HashMap<Student, LocalTime> currentItem = item;
			Set<Student> keys = currentItem.keySet();
			for (Student key : keys) {
				System.out.println(key.award() + " Arrival Time : " + currentItem.get(key));
			}
			
			List<Student> studentList = new ArrayList<Student>(
					Arrays.asList(
							new Student("Hla Aung"), 
							new Student("Kyaw Kyaw Soe"),
							new Student("Thura Zaw")));
			System.out.print(new StudentUtil().getWordAndCharacterCountPairs(studentList));
		}

	}

}
