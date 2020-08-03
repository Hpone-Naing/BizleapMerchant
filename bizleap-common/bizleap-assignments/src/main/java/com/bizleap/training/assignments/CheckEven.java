package com.bizleap.training.assignments;
//TutorialThree
import java.util.Scanner;

public class CheckEven {
	public boolean isEven(double number) {
		
		return (number%2==0);
		/*if (number % 2 == 0) {
			return true;
		} else
			return false;*/
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number:");
		double number = sc.nextDouble();
		CheckEven tutothree = new CheckEven();
		if (tutothree.isEven(number))
			System.out.print("Your number "+number+" is even.");

		else
			System.out.print("Your number "+number+" is odd.");
		sc.close();
	}

}
