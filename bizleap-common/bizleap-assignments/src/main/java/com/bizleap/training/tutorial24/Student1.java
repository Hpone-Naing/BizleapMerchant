package com.bizleap.training.tutorial24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Comparator;

public class Student1 {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student1(String name) {
		super();
		this.name = name;
	}

	public Student1() {
		super();
	}

	public List<Entry<Student1, String>> arrive(List<Student1> studentList) {
		List<Entry<Student1, String>> sortedArrivalTimeStudents = null;
		for (Student1 student : studentList) {
			HashMap<Student1, String> inTimeStudents = new HashMap<Student1, String>();
			inTimeStudents.put(student, student.timeGenerator());
			if (sortedArrivalTimeStudents == null)
				sortedArrivalTimeStudents = new ArrayList<Entry<Student1, String>>();
			sortedArrivalTimeStudents.addAll(inTimeStudents.entrySet());
		}
		Collections.sort(sortedArrivalTimeStudents, valueComparator);
		return sortedArrivalTimeStudents;
	}

	public List<HashMap<String, String>> award(List<Student1> sortedStudentList) {
		List<HashMap<String, String>> awardStudentList = null;
		for (Entry<Student1, String> entry : arrive(sortedStudentList)) {
			HashMap<String, String> awardStudent = new HashMap<String, String>();
			awardStudent.put(entry.getKey().toString().concat(" get Certificate."),
					new StringBuffer().append(" arrival time: " + entry.getValue() + " hr").toString());
			if (awardStudentList == null)
				awardStudentList = new ArrayList<HashMap<String, String>>();
			awardStudentList.add(awardStudent);
		}
		return awardStudentList;
	}

	Comparator<Entry<Student1, String>> valueComparator = new Comparator<Entry<Student1, String>>() {
		public int compare(Entry<Student1, String> entity1, Entry<Student1, String> entity2) {
			int entity1Hour = Integer.parseInt(entity1.getValue().split(":")[0]);
			int entity2Hour = Integer.parseInt(entity2.getValue().split(":")[0]);
//			int entity1Min = Integer.parseInt(entity1.getValue().split(":")[1]);
//			int entity2Min = Integer.parseInt(entity2.getValue().split(":")[1]);
			if (entity1Hour > entity2Hour)
				return 1;
			if (entity1Hour < entity2Hour)
				return -1;
//			if (entity1Hour == entity2Hour) {
//				if (entity1Min > entity2Min)
//					return 1;
//				if (entity1Min < entity2Min)
//					return -1;
//			}
			return 0;
		}
	};

	@Override
	public String toString() {
		return new StringBuilder().append("name:" + name).toString();
	}

	public String timeGenerator() {
		return new StringBuilder().append((int) (Math.random() * ((12 - 7) + 1)) + 7).toString();
	}

	public static void main(String[] args) {

		System.out.println(new Student1().award(
				Arrays.asList(new Student1[] { new Student1("Hla Hla"), new Student1("Ko Ko"), new Student1("Moe Moe"),
						new Student1("Soe Soe"), new Student1("Kyaw Kyaw"), new Student1("Aye Aye") })));
	}

}
