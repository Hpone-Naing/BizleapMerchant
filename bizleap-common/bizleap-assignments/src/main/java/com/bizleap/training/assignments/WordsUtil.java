/*package com.bizleap.training.assignments;

import java.util.*;

public class WordsUtil {
	
	private static WordsUtil instance;
	private static List<String> itemList=new ArrayList<String>();
	
	private WordsUtil() {

	}

	public static synchronized WordsUtil getInstance() {

		if (instance == null) {
			instance = new WordsUtil();
		}
		return instance;
	}
	
	public static List<String> getItemList() {
		return itemList;
	}

	public static void setItemList(List<String> itemList) {
		WordsUtil.itemList = itemList;
	}

	public static List<Integer> getIntegerList(int number) {

		List<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= number; i++) {
			numberList.add(i);
		}
		return numberList;
	}

	public static List<String> createStringList(List<Integer> n) {

		for (int i : n) {
			if (i % 3 == 0 && i % 5 == 0)
				itemList.add("BizLeap");
			else if (i % 3 == 0)
				itemList.add("Biz");
			else if (i % 5 == 0)
				itemList.add("Leap");		
		}
		return itemList;
	}
	
	public static int getOccuranceCount(String item){
		
		int count=0;
		if	(itemList != null) {
			for(String word:itemList) {
				if(item.equals(word))
					count++;				
			}
		}
		return count;
	}
	
	public static boolean isEvenOccurance(String item){
		
		return getOccuranceCount(item)%2==0;
	}

	public static boolean isOddOccurance(String item){
	
	return !isEvenOccurance(item);
	}
		
	public static Set<String> getMultipleOccurance(){
		
		Set<String> multipleOccuranceWordsList=new HashSet<String>();
		for(String word:itemList) {
			if(getOccuranceCount(word)>1) 
				multipleOccuranceWordsList.add(word);			
		}
		return multipleOccuranceWordsList;
	}
		
	public static Set<String> getEvenOccurance(){
		
		Set<String> evenOccuranceWordsList=new HashSet<String>();
		for(String word:itemList) {
			if(isEvenOccurance(word)) 
				evenOccuranceWordsList.add(word);			
		}
		return evenOccuranceWordsList;
	}
	
	public static Set<String> getOddOccurance(){
		
		Set<String> oddOccuranceWordsList=new HashSet<String>();
		for(String word:itemList) {
			if(isOddOccurance(word)) 
				oddOccuranceWordsList.add(word);			
		}
		return oddOccuranceWordsList;
	}
	
	public static Set<String> getStudentNames() {

		Set<String> names = new HashSet<String>(Arrays.asList("Theint Thu Thu Aung", "Sandar Win", "Htet Wai Lin",
				"Kaung Nyunt Hlaing", "Hlwan Moe Hein", "Thuzar Hlaing", "Hpone Naing Tun", "Phu Pwint Eaindray",
				"Saw Than Shwe", "Ei Ei Tone", "Phoo Pwint Thu", "Aye Chan Nyein", "Naw Phaw Hkee Lar Mya",
				"Pann Cherry Hlaing", "Aung Baw Ga", "Min Thant Khant"));
		return names;
	}
	
	public static List<String> getNames() {

		List<String> names = new ArrayList<String>(Arrays.asList("Theint Thu Thu Aung", "Sandar Win", "Htet Wai Lin",
				"Kaung Nyunt Hlaing", "Hlwan Moe Hein", "Thuzar Hlaing", "Hpone Naing Tun", "Phu Pwint Eaindray",
				"Saw Than Shwe", "Ei Ei Tone", "Phoo Pwint Thu", "Aye Chan Nyein", "Naw Phaw Hkee Lar Mya",
				"Pann Cherry Hlaing", "Aung Baw Ga", "Min Thant Khant"));
		return names;
	}
	
	public static  List<String> getAllWords(List<String> names) {

		List<String> words = new ArrayList<String>();
		for (String word : names) {
			words.addAll(Arrays.asList(word.split("\\s+")));
		}
		return words;
	}
	
	public  static int countAllWords(List<String> names) {
		return getAllWords(names).size();
	}

	public static Set<String> getUniqueWords(Set<String> names) {

		Set<String> uniqueWords = new HashSet<String>();
		for (String word : names) {
			uniqueWords.addAll(Arrays.asList(word.split("\\s+")));
		}
		return uniqueWords;
	}

	public static int countUniqueWords(Set<String> names) {
		return getUniqueWords(names).size();
	}

	public static void main(String[] args) {

		WordsUtil.getInstance();
		System.out.println("Student Names: " + WordsUtil.getStudentNames());
		System.out.println("Count Different Words:" + WordsUtil.countAllWords(WordsUtil.getAllWords(WordsUtil.getNames())));
		System.out.println("Count Unique Words:" + WordsUtil.countUniqueWords(WordsUtil.getUniqueWords(WordsUtil.getStudentNames())));
		System.out.println("Numbers in the list: " + WordsUtil.getIntegerList(15));
		System.out.println(WordsUtil.createStringList(WordsUtil.getIntegerList(15)));
		System.out.println(WordsUtil.getMultipleOccurance());
		System.out.println(WordsUtil.getEvenOccurance());
		System.out.println(WordsUtil.getOddOccurance());

	}

}
*/