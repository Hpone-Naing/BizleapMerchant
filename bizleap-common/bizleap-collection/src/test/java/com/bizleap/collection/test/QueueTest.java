package com.bizleap.collection.test;

import org.junit.Test;

import com.bizleap.collection.impl.BLQueue;

public class QueueTest {
	
	@Test
	public void testQueue() {
		BLQueue<String> q = new BLQueue<String>();
		for (int i = 0; i < 100; i++) {
			q.add(i + "");
			System.out.println(q.poll());
		}
	}
}
