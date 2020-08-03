package com.bizleap.training.assignments;

//tutorial8
public class StringFunctions {

	public void testUpperandLowercase() {
		String greeting = "Hi,I'm Mya Mya.";
		System.out.println("LowerCase of string:" + greeting.toLowerCase());
		System.out.println("UpperCase of string:" + greeting.toUpperCase());
	}

	public void testStartEndWith() {
		String greeting = "Hi,I'm Mya Mya.";
		System.out.println("Start with H:" + greeting.startsWith("H"));
		System.out.println("End with o:" + greeting.endsWith("o"));
	}

	public boolean testContain() {
		String greeting = "Hi,I'm Mya Mya.";
		if (greeting.contains("Mya")) {
			System.out.println("This string contains Mya.");
			return true;
		} else {
			System.out.println("This string contains Mya.");
			return false;
		}

	}

	public void testTrimAndLength() {
		String greeting = "Hi,I'm Mya Mya.";
		System.out.println("Length of string:" + greeting.length());
		System.out.println("Trim:" + greeting.trim() + "Nice to meet you.");
	}

	public boolean testEqual() {
		String greetingOne = "Hi";
		String greetingTwo = "Hello";
		if (greetingOne.equals(greetingTwo)) {
			System.out.println("These strings are equal.");
			return true;
		} else {
			System.out.println("These strings are not equal.");
			return false;
		}

	}

	public void testReplace() {
		String greeting = "Hi,I'm Mya Mya.";
		System.out.println("Replace all 'a' with 'o':"
				+ greeting.replace('a', 'o'));
	}

	public void testSplit() {

		String greeting = "What's your name?What is your hobby?";
		System.out.print("Split:");
		for (String g : greeting.split("\\?")) {
			System.out.print(g);
		}
	}

	public void testConcat() {
		String greetingOne = "Hi,I'm Mya Mya.";
		String greetingTwo = "Nice to meet you.";
		System.out.println("Concat StringOne and StringTwo:"
				+ greetingOne.concat(greetingTwo));
	}

	public static void main(String[] args) {

		StringFunctions sf = new StringFunctions();
		sf.testContain();
		sf.testUpperandLowercase();
		sf.testTrimAndLength();
		sf.testStartEndWith();
		sf.testEqual();
		sf.testReplace();
		sf.testConcat();
		sf.testSplit();

	}

}
