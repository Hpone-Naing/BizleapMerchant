package com.bizleap.training.assignments;

import java.util.Arrays;

//Tutorial16
public class ArrayFunctions {

	public String sortArray(int[] numbers) {

		Arrays.sort(numbers);
		return Arrays.toString(numbers);
	}

	public int displayArrayLength(int[] numbers) {

		return numbers.length;
	}

	public int sumNumbers(int[] numbers) {

		int sum = 0;
		for (Integer i : numbers) {
			sum += i;
		}
		return sum;
	}

	public int averageNumbers(int[] numbers) {

		int sum = 0;
		for (Integer i : numbers) {
			sum += i;
		}
		int average = sum / numbers.length;
		return average;
	}

	public String copyArray(int[] numbers) {

		int[] copy = Arrays.copyOf(numbers, numbers.length);
		return Arrays.toString(copy);
	}

	public static void main(String[] args) {

		int[] numbers = { 23, 45, 1, 2, 56, 67, 89 };
		ArrayFunctions arrfun = new ArrayFunctions();
		System.out.println("Sorting the numbers:" + arrfun.sortArray(numbers));
		System.out.println("Length:" + arrfun.displayArrayLength(numbers));
		System.out.println("Sum:" + arrfun.sumNumbers(numbers));
		System.out.println("Average:" + arrfun.averageNumbers(numbers));
		System.out.println("Copy Arrays:" + arrfun.copyArray(numbers));

	}

}
