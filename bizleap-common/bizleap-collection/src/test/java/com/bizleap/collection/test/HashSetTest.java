package com.bizleap.collection.test;

import org.junit.Test;
import com.bizleap.collection.impl.BLHashSet;

public class HashSetTest {

	@Test
	public void testadd() {
		BLHashSet<Integer> test = new BLHashSet<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(3);
		System.out.println(test.size());
	}
}
