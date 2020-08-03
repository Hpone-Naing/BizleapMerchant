package com.bizleap.training.tutorial26and27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.bizleap.training.tutorial22.Gender;
import com.bizleap.training.tutorial26and27.Student;

public class StudentUtil {
	
	private static StudentUtil instance;
	private	static List<Student> studentList=null;
	
	private StudentUtil(){
		
	}

	public static synchronized StudentUtil getInstance() {
		if (instance == null) {
			instance = new StudentUtil();
		}
		return instance;
	}
	
	public static List<Student> getAllStudets(){
		if(studentList==null) {
			studentList =Arrays.asList(
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
					new Student( "Min Thant Khant"));
		}
		return studentList;
	}
	public static Map<String,List<Integer>> getWordsAndCharactersCountPairs(List<Student> studentList){
		
		Map<String,List<Integer>> wordsAndCharactersCountPairs=new HashMap<String, List<Integer>>();
		for(Student student:studentList) {
			List<Integer> studentListCount=new ArrayList<Integer>();
			WordUtil.getInstance();
			studentListCount.add(WordUtil.countWords(student.getName()));
			//WordUtil.getInstance();
			studentListCount.add(WordUtil.countCharacters(student.getName()));
			wordsAndCharactersCountPairs.put(student.getName(), studentListCount);
		}
		return wordsAndCharactersCountPairs;
	}
	
	public static void main(String[] args) {

		List<Student> students=Arrays.asList(
				new Student("Theint Thu Thu Aung","theint@gmail.com",21,"09-345678123", Gender.FEMALE),
				new Student("Sandar Win","theint@gmail.com",21,"09-345678123", Gender.FEMALE),
				new Student("Htet Wai Lin","theint@gmail.com",21,"09-345678123", Gender.FEMALE),
				new Student("Kaung Nyunt Hlaing","theint@gmail.com",21,"09-345678123", Gender.FEMALE), 
				new Student("Hlwan Moe Hein","theint@gmail.com",21,"09-345678123", Gender.FEMALE), 
				new Student("Thuzar Hlaing","theint@gmail.com",21,"09-345678123", Gender.FEMALE), 
				new Student("Hpone Naing Tun","theint@gmail.com",21,"09-345678123", Gender.FEMALE),
				new Student("Phu Pwint Eaindray","theint@gmail.com",21,"09-345678123", Gender.FEMALE),
				new Student("Saw Than Shwe","theint@gmail.com",21,"09-345678123", Gender.FEMALE), 
				new Student("Ei Ei Tone","theint@gmail.com",21,"09-345678123", Gender.FEMALE), 
				new Student("Phoo Pwint Thu","theint@gmail.com",21,"09-345678123", Gender.FEMALE), 
				new Student("Aye Chan Nyein","theint@gmail.com",21,"09-345678123", Gender.FEMALE), 
				new Student("Naw Phaw Hkee Lar Mya","theint@gmail.com",21,"09-345678123", Gender.FEMALE),
				new Student("Pann Cherry Hlaing","theint@gmail.com",21,"09-345678123", Gender.FEMALE),
				new Student("Aung Baw Ga","theint@gmail.com",21,"09-345678123", Gender.FEMALE),
				new Student( "Min Thant Khant","theint@gmail.com",21,"09-345678123", Gender.FEMALE));
		Student student = new Student();
		System.out.println(student.getStudentsInformation(students, Gender.FEMALE));
		StudentUtil.getInstance();
		//StudentUtil.getInstance();
		System.out.println(StudentUtil.getWordsAndCharactersCountPairs(StudentUtil.getAllStudets()));
			
	}
}
