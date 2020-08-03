package com.bizleap.training.assignments;

public class StringCreator {

	public void createStrings() {

		String tenantId;

		long n = 999999999;

		long freeMemoryBefore = Runtime.getRuntime().freeMemory();
		System.out.println("Free memory: " + freeMemoryBefore);

		do {
			// tenantId="BizLeap";
			tenantId = new String("BizLeap");
		} while (n-- > 0);

		long currentFreeMemory = Runtime.getRuntime().freeMemory();
		System.out.println("Free/Used memory : " + currentFreeMemory +"/"+( freeMemoryBefore-currentFreeMemory));
	}

	public static void main(String[] args) {

		new StringCreator().createStrings();

	}

}
