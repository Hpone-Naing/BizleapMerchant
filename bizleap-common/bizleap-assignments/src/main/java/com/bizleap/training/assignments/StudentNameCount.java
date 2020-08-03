package com.bizleap.training.assignments;

import java.util.*;

public class StudentNameCount {

	public List<String> getStudentNames() {

		List<String> nameList = new ArrayList<String>();
//		nameList.add("Theint Thu Thu Aung");
//		nameList.add("Sandar Win");
//		nameList.add("Htet Wai Lin");
//		nameList.add("Kaung Nyunt Hlaing");
//		nameList.add("Hlwan Moe Hein");
//		nameList.add("Thuzar Hlaing");
//		nameList.add("Hpone Naing Tun");
//		nameList.add("Phu Pwint Eaindray");
//		nameList.add("Saw Than Shwe");
//		nameList.add("Ei Ei Tone");
//		nameList.add("Phoo Pwint Thu");
//		nameList.add("Aye Chan Nyein");
//		nameList.add("Naw Phaw Hkee Lar Mya");
//		nameList.add("Pann Cherry Hlaing");
//		nameList.add("Aung Baw Ga");
//		nameList.add("Min Thant Khant");
		nameList=Arrays.asList("Theint Thu Thu Aung","Sandar Win","Htet Wai Lin","Kaung Nyunt Hlaing","Hlwan Moe Hein","Thuzar Hlaing",
				"Hpone Naing Tun","Phu Pwint Eaindray","Saw Than Shwe",	"Ei Ei Tone","Phoo Pwint Thu","Aye Chan Nyein","Naw Phaw Hkee Lar Mya","Pann Cherry Hlaing","Aung Baw Ga","Min Thant Khant");

		return nameList;
	}
	
	public List<String> getAllWords(List<String> nameList){
		
		List<String> wordList=new ArrayList<String>();
		for(String name: nameList)
		 wordList.addAll(Arrays.asList(name.split("\\s+")));
		return wordList;
	}

	public int countTotalWords(List<String> nameList) {

//		int count = 0;
//		 for(String word:nameList)  
//         {  
//			 String[] w=word.split("\\s+");
//			 for(int i=0;i<w.length;i++) {
//	                 count++;
//			 }
//            
//		}
//		return count;
	return getAllWords(nameList).size();
		
	}
	
	public List<String> getUniqueList(List<String> wordList){
		
		List<String> uniqueWordList=new ArrayList<String>();
		for(String word:getAllWords(wordList)) {
			if(!uniqueWordList.contains(word)) {
				uniqueWordList.add(word);
			}
		}
		return uniqueWordList;
	}
	
	public int countUniqueWords(List<String> nameList) {
		return getUniqueList(getAllWords(nameList)).size();
	}
//	public int countDifferentWords(List<String> nameList) {
//		
//		int count=0;
//		String[] name;		
//		name=nameList.get(0).split("\\s+");
//		String n= name[0];
//		for(String word:nameList) {
//			for(String w:word.split("\\s+")) {
//				if(!w.equals(n)) {
//					n=w;
//					count++;
//				}	
//			}			
//		}
//		return count;		
//	}
	
	public static void main(String[] args) {

		StudentNameCount name = new StudentNameCount();
		System.out.println("Student Name List:" + name.getStudentNames());
		System.out.println("Numbers of words in student name list:" + name.countTotalWords(name.getStudentNames()));
		System.out.println("Numbers of different words in student name list:" + name.countUniqueWords(name.getStudentNames()));
//

	}

}
