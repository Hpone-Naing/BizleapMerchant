package com.bizleap.training.assignments;

import java.util.*;

public class NumbersList {

	List<Integer> numberList = new ArrayList<Integer>();

	public List<Integer> getItemList() {
		return numberList;
	}

	public void setItemList(List<Integer> itemList) {
		this.numberList = itemList;
	}

	public List<Integer> getIntegerList() {
		numberList = Arrays.asList(1, 2, 3, 3, 2, 5, 6, 6, 7, 6, 5, 9);
		return numberList;
	}

	public int getOccuranceCount(Integer item) {
		int count = 0;
		if (numberList != null) {
			for (Integer number : numberList) {
				if (item.equals(number))
					count++;
			}
		}
		return count;
	}

	public Set<Integer> getMultipleOccurance() {

		Set<Integer> multipleOccuranceNumbersList = new HashSet<Integer>();
		for (int number : numberList) {
			if (getOccuranceCount(number) > 1)
				multipleOccuranceNumbersList.add(number);
		}
		return multipleOccuranceNumbersList;
	}

	public Set<Integer> getEvenOccurance() {

		Set<Integer> evenOccuranceNumbersList = new HashSet<Integer>();
		for (int number : numberList) {
			if (getOccuranceCount(number) % 2 == 0)
				evenOccuranceNumbersList.add(number);
		}
		return evenOccuranceNumbersList;
	}

	public Set<Integer> getOddOccurance() {

		Set<Integer> oddOccuranceNumbersList = new HashSet<Integer>();
		for (int number : numberList) {
			if (getOccuranceCount(number) % 2 != 0)
				oddOccuranceNumbersList.add(number);
		}
		return oddOccuranceNumbersList;
	}

	public static void main(String[] args) {

		NumbersList numList = new NumbersList();
		System.out.println(numList.getIntegerList());
		System.out.println(numList.getMultipleOccurance());
		System.out.println(numList.getEvenOccurance());
		System.out.println(numList.getOddOccurance());

	}

}
