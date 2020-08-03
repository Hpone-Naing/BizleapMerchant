package com.bizleap.training.assignments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BizLeapUtil {

	private static BizLeapUtil instance;

	private BizLeapUtil() {

	}

	public static void checkEvenOdd(double number) {

		if (number % 2 == 0) {

			System.out.println("Your number " + number + " is even.");
		} else
			System.out.println("Your number " + number + " is odd.");
	}

	public static void checkPrime(int number) {
		int count = 0;

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

	public static boolean isToday(LocalDate date) {
		System.out.println("Today is "+LocalDate.now());
		return date.equals(LocalDate.now());

	}
	
	public static List<Integer> getIntegerList(int n) {
		List<Integer> numbers = new ArrayList<Integer>();

		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		return numbers;
	}
	
	public static List<Integer> findEvenNumbers(List<Integer> list) {
		List<Integer> evenList = new ArrayList<Integer>();

		for (Integer i:list) {
			if(i%2 == 0)
			evenList.add(i);
		}
		return evenList;
	}
	
	public static List<Integer> findOddNumbers(List<Integer> list) {
		List<Integer> oddList = new ArrayList<Integer>();

		for (Integer i : list) {
			if (i % 2 != 0)
				oddList.add(i);
		}
		return oddList;
	}

	public static synchronized BizLeapUtil getUtility() {

		if (instance == null) {
			instance = new BizLeapUtil();
		}
		return instance;
	}

	public static void main(String[] args) {

		BizLeapUtil.getUtility();
		BizLeapUtil.checkEvenOdd(45);
		BizLeapUtil.checkPrime(33);
		System.out.println(BizLeapUtil.getIntegerList(20));
		System.out.println(BizLeapUtil.findEvenNumbers(getIntegerList(20)));
		System.out.println(BizLeapUtil.findOddNumbers(getIntegerList(20)));
		System.out.println(BizLeapUtil.isToday(LocalDate.of(2020, 2, 25))? "Your date is up to date.":"Your date is worng.");

	}

}
