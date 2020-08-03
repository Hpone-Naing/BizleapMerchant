package com.bizleap.training.assignments;
//tutorial7
public class CalculateTotalStudentHeight {

	public void totalHeight(String height) {

		double total = 0;
		System.out.print("Height of Students: " + height);
		String[] studentHeight = height.split(";");
		for (int i = 0; i < studentHeight.length; i++) {
			total += Double.parseDouble(studentHeight[i]);
		}
		System.out.println("\nTotal Height of Students:" + total);
	}

	public static void main(String[] args) {

		CalculateTotalStudentHeight totalHeight = new CalculateTotalStudentHeight();
		totalHeight.totalHeight("5.32; 5.11; 5.74");

	}

}
