package com.bizleap.training.assignments;

import java.util.*;

public class WordsUtil2 {
	private static WordsUtil2 instance;
	private static List<String> itemList = Arrays.asList("Biz", "Leap", "BizLeap", "Biz", "Leap");

	private WordsUtil2() {

	}

	public static synchronized WordsUtil2 getInstance() {

		if (instance == null) {
			instance = new WordsUtil2();
		}
		return instance;
	}

	public static Set<String> getSingleOccuranceTest() {

		List<String> multipleList = new ArrayList<String>();
		Set<String> multiple = new HashSet<String>();
		for (String item : itemList) {
			if (!multiple.add(item))
				multipleList.add(item);
		}
		multiple.removeAll(multipleList);
		return multiple;
	}

	public static Set<String> getMultipleOccuranceTest2() {
		Set<String> multipleOccurance = new HashSet<String>();
		multipleOccurance.addAll(itemList);
		multipleOccurance.removeAll(getSingleOccuranceTest());
		return multipleOccurance;
	}

	public static Set<String> getOddOccurance() {
		Set<String> oddOccurance = new HashSet<String>();
		for (String item : itemList) {
			if (!oddOccurance.add(item))
				oddOccurance.remove(item);
		}
		return oddOccurance;
	}

	public static Set<String> getEvenOccurance() {
		Set<String> evenOccurance = new HashSet<String>();
		evenOccurance.addAll(itemList);
		evenOccurance.removeAll(getOddOccurance());
		return evenOccurance;
	}

	public static void main(String[] args) {

		//WordsUtil2.getInstance();
		System.out.println(WordsUtil2.getSingleOccuranceTest());
		System.out.println(WordsUtil2.getMultipleOccuranceTest2());
		System.out.println(WordsUtil2.getOddOccurance());
		System.out.println(WordsUtil2.getEvenOccurance());

	}

}
