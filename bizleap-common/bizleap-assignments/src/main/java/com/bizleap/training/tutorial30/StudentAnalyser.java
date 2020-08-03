package com.bizleap.training.tutorial30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.bizleap.training.tutorial22.Gender;
import com.bizleap.training.tutorial30.Student;

public class StudentAnalyser {
	
	private List<Student> studentList=null;
	private Map<Integer,List<Student>> otherStudentWordMap = null;
	private Map<Integer,List<Student>> otherStudentCharacterMap = null;
	private Map<Integer,List<Student>> ucsyStudentWordMap = null;
	private Map<Integer,List<Student>> ucsyStudentCharacterMap = null;
	
	public StudentAnalyser(){
		start();
	}

	public void doInitialization() {
		if(studentList==null) {
			studentList = Arrays.asList(
					new Student[] {
					new UCSYStudent("Theint Thu Thu Aung",21,Gender.FEMALE,"UCSY"), 
					new UCSYStudent("Sandar Win",20,Gender.FEMALE,"UCSY"),
					new OtherStudent("Htet Wai Lin",22,Gender.MALE,"Other"),
					new OtherStudent("Kaung Nyunt Hlaing",23,Gender.MALE,"Other"), 
					new UCSYStudent("Hlwan Moe Hein",25,Gender.MALE,"UCSY"),
					new OtherStudent("Thuzar Hlaing",16,Gender.FEMALE,"Other"),
					new UCSYStudent("Hpone Naing Tun",28,Gender.MALE,"UCSY"), 
					new OtherStudent("Phu Pwint Eaindray",24,Gender.FEMALE,"Other"),
					new OtherStudent("Saw Than Shwe",27,Gender.MALE,"Other"), 
					new OtherStudent("Ei Ei Tone",19,Gender.FEMALE,"Other"),
					new UCSYStudent("Phoo Pwint Thu",23,Gender.FEMALE,"UCSY"),
					new UCSYStudent("Aye Chan Nyein",29,Gender.MALE,"UCSY"),
					new UCSYStudent("Naw Phaw Hkee Lar Mya",22,Gender.FEMALE,"UCSY"), 
					new OtherStudent("Pann Cherry Hlaing",17,Gender.FEMALE,"Other"),
					new OtherStudent("Aung Baw Ga",18,Gender.MALE,"Other"),
					new OtherStudent("Min Thant Khant",24,Gender.MALE,"Other")
					});
		}
		if (otherStudentWordMap == null)
			otherStudentWordMap = new HashMap<Integer,List<Student>>();
		if (otherStudentCharacterMap == null)
			otherStudentCharacterMap = new HashMap<Integer,List<Student>>();
		if (ucsyStudentWordMap == null)
			ucsyStudentWordMap = new HashMap<Integer,List<Student>>();
		if (ucsyStudentCharacterMap == null)
			ucsyStudentCharacterMap = new HashMap<Integer,List<Student>>();	
		}

	

	private void populateWordMap() {
	
		List<Student> ucsyStudentList = new ArrayList<Student>();
		List<Student> ucsyStudent = null;
		List<Student> otherStudentList = new ArrayList<Student>();
		List<Student> otherStudent =null;
		
		for (Student student : studentList) {
			if(student.isUCSY())
				ucsyStudentList.add(student);
			else
				otherStudentList.add(student);
		}
		
		for(Student student:otherStudentList) {
			if(!otherStudentWordMap.containsKey(student.getNameWordCount())) {
				otherStudent=new ArrayList<Student>();
				otherStudent.add(student);
			}
			else {
				otherStudent=otherStudentWordMap.get(student.getNameWordCount());
				otherStudent.add(student);
			}
			otherStudentWordMap.put(student.getNameWordCount(), otherStudent);
			}
		
	for(Student student:ucsyStudentList) {
		if(!ucsyStudentWordMap.containsKey(student.getNameWordCount())) {
			ucsyStudent=new ArrayList<Student>();
			ucsyStudent.add(student);
		}
		else {
			ucsyStudent=ucsyStudentWordMap.get(student.getNameWordCount());
			ucsyStudent.add(student);
		}
		ucsyStudentWordMap.put(student.getNameWordCount(), ucsyStudent);
		}
	
	System.out.println("UCSY Student Word Count :" + ucsyStudentWordMap);
	System.out.println("Other Student Word Count :" + otherStudentWordMap);
	
	}
				
	private void populateCharacterMap() {
		
		List<Student> ucsyStudentList = new ArrayList<Student>();
		List<Student> ucsyStudent = null;
		List<Student> otherStudentList = new ArrayList<Student>();
		List<Student> otherStudent =null;
		
		for (Student student : studentList) {
			if(student.isUCSY())
				ucsyStudentList.add (student);
			else
				otherStudentList.add(student);
		}
		
		for(Student student:otherStudentList) {
			if(!otherStudentCharacterMap.containsKey(student.getNameCharacterCount())) {
				otherStudent=new ArrayList<Student>();
				otherStudent.add(student);
			}
			else {
				otherStudent=otherStudentCharacterMap.get(student.getNameCharacterCount());
				otherStudent.add(student);
			}
			otherStudentCharacterMap.put(student.getNameCharacterCount(), otherStudent);
			}
		
	for(Student student:ucsyStudentList) {
		if(!ucsyStudentCharacterMap.containsKey(student.getNameCharacterCount())) {
			ucsyStudent=new ArrayList<Student>();
			ucsyStudent.add(student);
		}
		else {
			ucsyStudent=ucsyStudentCharacterMap.get(student.getNameCharacterCount());
			ucsyStudent.add(student);
		}
		ucsyStudentCharacterMap.put(student.getNameCharacterCount(), ucsyStudent);
		}
		
	System.out.println("UCSY Student Character Count :" + ucsyStudentCharacterMap);
	System.out.println("Other Student Character Count :" + otherStudentCharacterMap);
	
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
