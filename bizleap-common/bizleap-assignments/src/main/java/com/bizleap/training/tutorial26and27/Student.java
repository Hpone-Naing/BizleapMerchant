package com.bizleap.training.tutorial26and27;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.bizleap.training.tutorial22.Gender;

public class Student {

	private String name;
	private String email;
	private int age;
	private String phoneNo;
	private Gender gender;

	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Student(String name, String email, int age, String phoneNo, Gender gender) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNo = phoneNo;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Student> getStudentsInformation(List<Student> students, Gender gender) {
		List<Student> studentList = new ArrayList<Student>();
		for (Student student : students) {
			if (student.isSameGender(gender))
				studentList.add(student);
		}
		return studentList;
	}
	
	private boolean isSameGender(Gender gender) {
		return this.gender.equals(gender);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("age", age).append("email", email)
				.append("gender", gender).append("phone number", phoneNo).toString();

	}


}
