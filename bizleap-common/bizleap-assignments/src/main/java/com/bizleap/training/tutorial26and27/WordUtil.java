package com.bizleap.training.tutorial26and27;

public class WordUtil {

	private static WordUtil instance;
	
	private WordUtil() {
		
	}

	public static synchronized WordUtil getInstance() {

		if (instance == null) {
			instance = new WordUtil();
		}
		return instance;
	}
	
	public static Integer countWords(String names) {

		String[] words = names.split("\\s+");
		return words.length;
	}

	public static Integer countCharacters(String names) {

		int count = 0;
		for (String word : names.split("\\s+")) {
			count += word.toCharArray().length;
		}
		return count;
	}
}
