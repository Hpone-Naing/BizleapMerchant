package com.bizleap.training.assignments;

//TutorialFive
public class FactorialTest {
	
	public void checkFactorial(int number) {
		int fact=1;
		for (int i =1; i<=number; i++) {
			fact = i* fact;

		}
		System.out.print(fact);
	}

	public static void main(String[] args) {
		new FactorialTest().checkFactorial(4);
	}

}
