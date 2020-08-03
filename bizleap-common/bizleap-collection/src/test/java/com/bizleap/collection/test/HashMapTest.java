package com.bizleap.collection.test;

import org.junit.Test;

import com.bizleap.collection.impl.BLHashMapWithBucket;

public class HashMapTest {

	@Test
	public void testPut() {
		BLHashMapWithBucket<String, String> bltest2 = new BLHashMapWithBucket<>();
		bltest2.put("a", "abc");
		bltest2.put("a", "efg");
		bltest2.put("a", "yu");
		bltest2.put("b", "bcd");
		bltest2.put("b", "hij");
		bltest2.put("c", "e");
		bltest2.put("c", "ijk");
		bltest2.put("d", "f");
		System.out.println("delete a: " + bltest2.remove("b"));
	}
}
