package com.bizleap.training.assignments;

//Tutorial11
public class WordCount {

	public static Integer count(String sentence) {
		String[] words = sentence.split("\\s+");		
		return words.length;
	}
	
	public static Integer countChar(String sentence) {
		int count=0;
		for(String str:sentence.split("\\s+")) {
			count+=str.toCharArray().length;
		}
		return count;
	}
	
	public static void main(String[] args) {
		new WordCount();
		WordCount.count("How are you?");
	}

}
