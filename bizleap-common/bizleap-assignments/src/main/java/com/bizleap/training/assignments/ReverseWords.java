package com.bizleap.training.assignments;

//Tutorial10
public class ReverseWords {

	public String reverseStringMutable(String sentence) {

		StringBuilder result = new StringBuilder();

		if (sentence != null) {
			for (String word : sentence.split("\\s+")) {
				result.insert(0, word + " ");
			}
		}
		return result.toString();
	}

	public String reverseStringImmutable(String sentence) {

		String result = "";

		if (sentence != null) {
			for (String word : sentence.split("\\s+")) {
				result = word + " " + result;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		String toReverse="Naw Phaw Hkee Lar Mya";
		System.out.println(toReverse + " -----> " + new ReverseWords().reverseStringMutable(toReverse));
		System.out.println(toReverse + " -----> " + new ReverseWords().reverseStringImmutable(toReverse));
	}
}
