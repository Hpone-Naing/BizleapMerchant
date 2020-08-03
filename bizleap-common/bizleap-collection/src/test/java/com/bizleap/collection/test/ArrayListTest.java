package com.bizleap.collection.test;

import com.bizleap.collection.BLList;
import com.bizleap.collection.impl.BLArrayListRefactor;

import org.junit.Test;

public class ArrayListTest {
	
	@Test
	public void testArrayList() {
		BLList<Integer> blInteger = new BLArrayListRefactor<>();
		System.out.println("Test ArrayList");
		for(int i=0;i<100;i++) {
			blInteger.add(i);
		}
		System.out.println("Number in List: " + blInteger);
		for(int i=0;i<100;i++) {
			System.out.println("Removed number: " + blInteger.remove(i));
		}		
		System.out.println("Contain Number 101 in List: " + blInteger.contains(101));
		System.out.println("Get Number 10 in List: " + blInteger.get(10));
		System.out.println("--------------------------");
	}

}
