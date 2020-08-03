package com.bizleap.training.assignments;

import java.util.*;

//Tutorial15
public class IntegerUtil {

	private static IntegerUtil instance;

	public IntegerUtil() {

	}

	public static synchronized IntegerUtil getInstance() {

		if (instance == null) {
			instance = new IntegerUtil();
		}
		return instance;
	}

	public List<Integer> getIntegerList(int n) {

		List<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}
		return numberList;
	}
	
	public int sum(List<Integer> list) {
		
		int sum = 0;
		for (Integer i : list) 
			sum += i;
			
		return sum;
		
	}

	public List<Integer> findEvenNumbers(List<Integer> list) {

		List<Integer> evenList = new ArrayList<Integer>();
		for (Integer i : list) {
			if (i % 2 == 0)
				evenList.add(i);
		}
		return evenList;
	}

	public int sumEvenNumber(List<Integer> numbers) {

		return sum(findEvenNumbers(numbers));		
	}

	public List<Integer> findOddNumbers(List<Integer> list) {

		List<Integer> oddList = new ArrayList<Integer>();
		for (Integer i : list) {
			if (i % 2 != 0)
				oddList.add(i);
		}
		return oddList;
	}

	public int sumOddNumber(List<Integer> numbers) {

//		int sum = 0;
//		for (Integer i : numbers) {
//			if (i % 2 != 0)
//				sum += i;
//		}
//
//		return sum;
		return sum(findOddNumbers(numbers));
	}

	public static void main(String[] args) {
		IntegerUtil intList = new IntegerUtil();
		System.out.println("Numbers in the list: " + IntegerUtil.getInstance().getIntegerList(20));
		System.out.println("Even numbers in the list: " + IntegerUtil.getInstance().findEvenNumbers(intList.getIntegerList(20)));
		System.out.println("Sum of even numbers in the list: " + IntegerUtil.getInstance().sumEvenNumber(intList.getIntegerList(20)));
		System.out.println("Odd numbers in the list: " + IntegerUtil.getInstance().findOddNumbers(intList.getIntegerList(20)));
		System.out.println("Sum of odd numbers in the list: " + IntegerUtil.getInstance().sumOddNumber(intList.getIntegerList(20)));
	}

}
