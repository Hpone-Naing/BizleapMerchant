package com.bizleap.training.tutorial24;

import java.time.*;
import java.util.*;
import com.bizleap.training.assignments.WordCount;

public class StudentUtil {

	public static List<HashMap<Student, LocalTime>> getAllStudents() {
		
		List<HashMap<Student, LocalTime>> arriveStudents = null;
		HashMap<Student, LocalTime> inTimeStudents = new HashMap<Student, LocalTime>();	
		Student students[] = { new Student("Hla Hla"), new Student("Mg Mg"), new Student("Moe Moe"),
				new Student("Kyaw Kyaw"), new Student("Aung Aung") };
		for (Student student : students) {
			inTimeStudents.put(student, student.arrive());
			arriveStudents = new ArrayList<HashMap<Student, LocalTime>>();
			arriveStudents.add(inTimeStudents);
		}
		return arriveStudents;

	}
	
	public Map<String,List<Integer>> getWordAndCharacterCountPairs(List<Student> studentList){
	
		Map<String,List<Integer>> wordAndCharacterCountPairs=new HashMap<String, List<Integer>>();
		for(Student student:studentList) {
			List<Integer> countStudentList=new ArrayList<Integer>();
			countStudentList.add(WordCount.count(student.getName()));
			countStudentList.add(WordCount.countChar(student.getName()));
			wordAndCharacterCountPairs.put(student.getName(), countStudentList);
		}
		return wordAndCharacterCountPairs;	
	}
}
