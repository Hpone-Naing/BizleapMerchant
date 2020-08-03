package com.bizleap.training.assignments;
//tutorial29
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.bizleap.training.tutorial26.Student;

public class DisplayNames {

	private List<Student> studentList=null;
	
	public DisplayNames(){
		doInitialize();
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public void doInitialize() {

				studentList = Arrays.asList(
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
	}

	public void getInputAndSearch(){
		List<Student> nameMatchList=new ArrayList<Student>();
		System.out.println("Enter names.....");
		Scanner sc=new Scanner(System.in);
		String str="";
		while(sc.hasNext()) {
			str += sc.next();
			for(Student student : studentList) {
				String searchString=makeString(student.getNames());
				if(searchString.contains(makeString(str)))
					nameMatchList.add(student);
			}
			if(nameMatchList.isEmpty()) {
				System.out.println("No result found...");
				System.exit(0);
			}
//			if(nameMatchList.size()==1)
//				break;
			if(nameMatchList.size()>=1) {
				System.out.println("Search....." + str + "\n Result : " + nameMatchList);
				nameMatchList.clear();
			}
		}
		System.out.println("Search...." + nameMatchList.get(0).getNames()+ "\n Match result : " + 
		nameMatchList);
	}
	
	private String makeString(String str) {
		StringBuffer sb=new StringBuffer();
		for(String word : str.split("\\s+")) {
			sb.append(word.toLowerCase());
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		new DisplayNames().getInputAndSearch();
	}
}
