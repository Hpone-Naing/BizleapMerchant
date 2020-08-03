package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.List;
//Tutorail18
public class AddingString {

	public List<Integer> getIntegerList(int number) {

		List<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= number; i++) {
			numberList.add(i);
		}
		return numberList;
	}

	public List<String> getString(List<Integer> numberList) {

		List<String> addList = new ArrayList<String>();
		for (int i : numberList) {
			if (i % 3 == 0 && i % 5 == 0)
				addList.add("BizLeap");
			else if (i % 3 == 0)
				addList.add("Biz");
			else if (i % 5 == 0)
				addList.add("Leap");
			
		}
		return addList;
	}

	public static void main(String[] args) {

		AddingString as = new AddingString();
		System.out.println(as.getIntegerList(15));
		System.out.println(as.getString(as.getIntegerList(15)));

	}

}
