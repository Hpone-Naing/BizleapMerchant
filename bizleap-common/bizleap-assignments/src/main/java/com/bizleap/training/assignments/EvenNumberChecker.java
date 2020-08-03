package com.bizleap.training.assignments;
//TutorialTwo
import java.util.Scanner;

public class EvenNumberChecker {
	public void checkEvenOdd(double number) {
		
		if (number%2==0) {

			System.out.print("Your number "+number+" is even.");		} 
		else
			System.out.print("Your number "+number+" is odd.");
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number:");
		double number = sc.nextDouble();
		new EvenNumberChecker().checkEvenOdd(number);
		sc.close();
	}
}
