package com.bizleap.collection.test;

import org.junit.Test;
import com.bizleap.collection.impl.BLLinkedList;

public class LinkedListTest {

	@Test
	public void testPut() {
	BLLinkedList<String> blLinkedList = new BLLinkedList<String>();
	blLinkedList.put("a");
	blLinkedList.put("b");
	blLinkedList.put("c");
	blLinkedList.put("d");
	System.out.println(blLinkedList.contain("c"));
	System.out.println(blLinkedList.remove("b"));
	System.out.println(blLinkedList);
	}
}
