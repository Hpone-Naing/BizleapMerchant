package com.bizleap.training.tutorial31;

import java.util.Arrays;
import java.util.List;
import com.bizleap.training.tutorial22.Gender;

public class StudentManager {

	public List<Student> getAllStudents(){

		List<Student> students=Arrays.asList(
				new Student("Theint Thu Thu Aung","theint@gmail.com",15,"09-345678123", Gender.FEMALE),
				new Student("Sandar Win","theint@gmail.com",20,"09-345678123", Gender.FEMALE),
				new Student("Htet Wai Lin","theint@gmail.com",19,"09-345678123", Gender.MALE),
				new Student("Kaung Nyunt Hlaing","theint@gmail.com",18,"09-345678123", Gender.MALE), 
				new Student("Hlwan Moe Hein","theint@gmail.com",17,"09-345678123", Gender.MALE), 
				new Student("Thuzar Hlaing","theint@gmail.com",16,"09-345678123", Gender.FEMALE), 
				new Student("Hpone Naing Tun","theint@gmail.com",14,"09-345678123", Gender.MALE),
				new Student("Phu Pwint Eaindray","theint@gmail.com",22,"09-345678123", Gender.FEMALE),
				new Student("Saw Than Shwe","theint@gmail.com",23,"09-345678123", Gender.MALE), 
				new Student("Ei Ei Tone","theint@gmail.com",24,"09-345678123", Gender.FEMALE), 
				new Student("Phoo Pwint Thu","theint@gmail.com",25,"09-345678123", Gender.FEMALE), 
				new Student("Aye Chan Nyein","theint@gmail.com",30,"09-345678123", Gender.MALE), 
				new Student("Naw Phaw Hkee Lar Mya","theint@gmail.com",25,"09-345678123", Gender.FEMALE),
				new Student("Pann Cherry Hlaing","theint@gmail.com",24,"09-345678123", Gender.FEMALE),
				new Student("Aung Baw Ga","theint@gmail.com",28,"09-345678123", Gender.MALE),
				new Student( "Min Thant Khant","theint@gmail.com",23,"09-345678123", Gender.MALE));
		return students;
	}
	
	private int getAverageAge(){
		int total=0;
		for(Student student:getAllStudents()) {
			total+=student.getAge();
		}
		return total/getAllStudents().size();
	}
	
	private Student getYoungestStudent(){
		Student youngestStudent=getAllStudents().get(0);
		for(Student student:getAllStudents()) {
			if(student.isYounger(youngestStudent))
				youngestStudent=student;				
		}
		return youngestStudent;
	}
	
	private Student getOldestStudent(){
		Student oldestStudent=getAllStudents().get(0);
		for(Student student:getAllStudents()) {
			if(student.isOlder(oldestStudent))
				oldestStudent=student;
		}
		return oldestStudent;
	}
	
	private Student getYoungestMale(){
		Student youngestMaleStudent=getAllStudents().get(0);
		for(Student student:getAllStudents()) {
			if(student.isYounger(youngestMaleStudent) && student.isMale())
				youngestMaleStudent=student;				
		}
		return youngestMaleStudent;
	}
	
	private Student getOldestMale(){
		Student oldestMaleStudent=getAllStudents().get(0);
		for(Student student:getAllStudents()) {
			if(student.isOlder(oldestMaleStudent) && student.isMale())
				oldestMaleStudent=student;
		}
		return oldestMaleStudent;
	}
	
	private Student getYoungestFemale(){
		Student youngestFemaleStudent=getAllStudents().get(0);
		for(Student student:getAllStudents()) {
			if(student.isYounger(youngestFemaleStudent) && student.isFemale())
				youngestFemaleStudent=student;				
		}
		return youngestFemaleStudent;
	}
	
	private Student getOldestFemale(){
		Student oldestFemaleStudent=getAllStudents().get(0);
		for(Student student:getAllStudents()) {
			if(student.isOlder(oldestFemaleStudent) && student.isFemale())
				oldestFemaleStudent=student;
		}
		return oldestFemaleStudent;
	}
	
	/*private void getSameAge() {
		
		Map<Integer,List<Student>> sameAgeStudentMap=new HashMap<Integer,List<Student>>();
		Student sameAgeStudent=getAllStudents().get(0);
		List<Student> sameAgeStudentList=null;
		for(Student student:getAllStudents()) {
			int age=student.getAge();
			if(!sameAgeStudentMap.containsKey(age)) {
				sameAgeStudentList=new ArrayList<Student>();
				sameAgeStudent=student;
				sameAgeStudentList.add(student);	
			}
			else {
				sameAgeStudentList=sameAgeStudentMap.get(age);
				sameAgeStudentList.add(student);
			}
			sameAgeStudentMap.put(student.getAge(), sameAgeStudentList);
		}
		System.out.println("Same age Students : " + sameAgeStudentMap);
	}*/
	
	public void start() {
		System.out.println("Average Age:" + getAverageAge());
		System.out.println("Youngest Student:" + getYoungestStudent());
		System.out.println("Oldest Student:" + getOldestStudent());
		System.out.println("Youngest Male:" + getYoungestMale());
		System.out.println("Youngest Female:" + getYoungestFemale());
		System.out.println("Oldest Male:" + getOldestMale());
		System.out.println("Oldest Female:" + getOldestFemale());
	}
	public static void main(String[] args) {

		new StudentManager().start();
	}

}
