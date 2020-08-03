package com.bizleap.training.tutorial26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.bizleap.training.tutorial26.Student;

public class StudentAnalyser {

	private Map<Integer, List<Student>> studentWordMap = null;
	private Map<Integer, List<Student>> studentCharacterMap = null;
	
	public StudentAnalyser(){
		start();
	}

	public void doInitialization() {
		if (studentWordMap == null)
			studentWordMap = new HashMap<Integer, List<Student>>();
		if (studentCharacterMap == null)
			studentCharacterMap = new HashMap<Integer, List<Student>>();
	}

	public List<Student> getAllStudets() {

		List<Student> studentList = Arrays.asList(
				new Student("Theint Thu Thu Aung"), 
				new Student("Sandar Win"),
				new Student("Htet Wai Lin"),
				new Student("Kaung Nyunt Hlaing"), 
				new Student("Hlwan Moe Hein"),
				new Student("Thuzar Hlaing"),
				new Student("Hpone Naing Tun"), 
				new Student("Phu Pwint Eaindray"),
				new Student("Saw Than Shwe"), 
				new Student("Ei Ei Tone"),
				new Student("Phoo Pwint Thu"),
				new Student("Aye Chan Nyein"),
				new Student("Naw Phaw Hkee Lar Mya"), 
				new Student("Pann Cherry Hlaing"),
				new Student("Aung Baw Ga"),
				new Student("Min Thant Khant"));
		return studentList;
	}

	private void populateWordMap() {
		List<Student> studentList = new ArrayList<Student>();
		for (Student student : getAllStudets()) {
			if (!student.isContainWord(studentWordMap)) {
				studentList = new ArrayList<Student>();
				studentList.add(student);
			} else {
				studentList = studentWordMap.get(student.getNameWordCount());
				studentList.add(student);
			}
			studentWordMap.put(student.getNameWordCount(), studentList);
		}
		System.out.println("Word Count : " + studentWordMap);
	}

	private void populateCharacterMap() {
		List<Student> studentList = new ArrayList<Student>();
		for (Student student : getAllStudets()) {
			if (!student.isContainCharacter(studentCharacterMap)) {
				studentList = new ArrayList<Student>();
				studentList.add(student);
			} else {
				studentList = studentCharacterMap.get(student.getNameCharacterCount());
				studentList.add(student);
			}
			studentCharacterMap.put(student.getNameCharacterCount(), studentList);
		}
		System.out.println("Character count : " + studentCharacterMap);
	}

	public void start() {
		doInitialization();
		populateWordMap();
		populateCharacterMap();
	}

	public static void main(String[] args) {
		new StudentAnalyser();
	}
}
