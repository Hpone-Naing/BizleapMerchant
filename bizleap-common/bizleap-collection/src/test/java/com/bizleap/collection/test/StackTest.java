package com.bizleap.collection.test;

import org.junit.Test;
import com.bizleap.collection.impl.BLStack;

public class StackTest {

	@Test
	public void testStack() {
		BLStack<Integer> blStack = new BLStack<Integer>();
		blStack.push(4);
		blStack.push(5);
		blStack.push(6);
		/*System.out.println(blStack.pop());
		System.out.println(blStack.pop());
		System.out.println(blStack.pop());
		System.out.println(blStack.pop());
*/		System.out.println(blStack.peek());
		System.out.println(blStack.peek());
		System.out.println(blStack.peek());
		System.out.println("size: " + blStack.size());
		System.out.println(blStack);		
	}
}
