package com.bizleap.training.assignments;

//Tutorial9
public class DisplayInitialName {

	public void initialName(String name) {

		for (String word : name.split(" ")) {
			System.out.print(Character.toUpperCase(word.charAt(0)) + " ");
		}
	}

	public static void main(String[] args) {

		new DisplayInitialName().initialName("Hla Hla");

	}

}
