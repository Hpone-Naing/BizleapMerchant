package com.bizleap.training.assignments;

//TutorialFour
public class PlayerSelection {

	public void checkPlayer(int age, int height) {
		if (age <= 16 && age >= 30 && height >= 180)
			System.out.println("Age " + age + " and height " + height
					+ " is selected.");

		else
			System.out.println("Age " + age + " and height " + height
					+ " is rejected.");

	}

	public static void main(String[] args) {
		new PlayerSelection().checkPlayer(16, 180);
		new PlayerSelection().checkPlayer(28, 200);
	}

}
