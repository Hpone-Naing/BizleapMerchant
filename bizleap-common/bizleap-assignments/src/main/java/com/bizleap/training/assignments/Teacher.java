package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.List;

import com.bizleap.training.tutorial22.Gender;

public class Teacher {
	private String name;
	private String email;
	private Gender sex;

	public Teacher() {
		super();
	}

	public Teacher(String name, String email, Gender sex) {
		super();
		this.name = name;
		this.email = email;
		this.sex = sex;
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

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public List<Teacher> getAllTeachers(Teacher teachers[], Gender sex) {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		for (Teacher teacher : teachers) {
			if (teacher.isSameGender(sex))
				teacherList.add(teacher);
		}
		return teacherList;
	}

	private boolean isSameGender(Gender sex) {
		return this.sex.equals(sex);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("name=" + name + ", email=" + email + ", sex=" + sex).toString();
	}

	public static void main(String[] args) {

		Teacher teachers[] = new Teacher[4];
		teachers[0] = new Teacher("Daw Hla", "hla@gmail.com", Gender.FEMALE);
		teachers[1] = new Teacher("Daw Mya", "mya@gmail.com", Gender.FEMALE);
		teachers[2] = new Teacher("U Aung", "aung@gmail.com", Gender.MALE);
		teachers[3] = new Teacher("U Phyo", "phyo@gmail.com", Gender.MALE);
		Teacher teacher = new Teacher();
		System.out.println(teacher.getAllTeachers(teachers, Gender.FEMALE));
	}

}
