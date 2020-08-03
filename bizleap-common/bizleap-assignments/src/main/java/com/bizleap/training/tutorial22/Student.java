package com.bizleap.training.tutorial22;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private String name;
	private Gender gender;
	private String email;

	public Student() {
		super();
	}
	
	public Student(String name, Gender gender, String email) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Student> getStudentsInformation(Student students[],Gender gender) {
		List<Student> studentList=new ArrayList<Student>();
		for(Student student:students) {
			if(student.isSameGender(gender)) 
				studentList.add(student);		
		}
		return studentList;
	}
	
	/*private boolean isMale(Gender gender) {
		return this.gender.equals(Gender.MALE);
	}
	
	private boolean isFemale(Gender gender) {
		return this.gender.equals(Gender.FEMALE);
	}*/
	
	private boolean isSameGender(Gender gender) {
		return this.gender.equals(gender);
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("name=" + name + ", gender=" + gender + ", email=" + email).toString();
}

	public static void main(String[] args) {
		Student students[]=new Student[4];
		students[0]=new Student("Hla Hla",Gender.FEMALE,"hlahla@gmail.com");
		students[1]=new Student("Moe Moe",Gender.FEMALE,"moemoe@gmail.com");
		students[2]=new Student("Aung Aung",Gender.MALE,"aungaung@gmail.com");
		students[3]=new Student("Tun Tun",Gender.MALE,"tuntun@gmail.com");
		Student student=new Student();
		System.out.println(student.getStudentsInformation(students,Gender.FEMALE));
	}	
}
