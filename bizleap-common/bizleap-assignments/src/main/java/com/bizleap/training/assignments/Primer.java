package com.bizleap.training.assignments;

//TutorialSix
public class Primer {
	int count = 0;

	public void isPrime(int number) {

		if (number <= 1) {
			System.out.println("This is not a prime number.");
			return;
		}
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				count++;
			}
		}
		if (count == 0)
			System.out.println("This is a prime number.");

		else
			System.out.println("This is not a prime number.");

	}

	public static void main(String[] args) {
		new Primer().isPrime(-3);
		new Primer().isPrime(2);
	}

}
