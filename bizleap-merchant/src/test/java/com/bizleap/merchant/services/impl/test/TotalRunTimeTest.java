package com.bizleap.merchant.services.impl.test;
/*package com.bizleap.services.impl.test;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import com.bizleap.collection.BLList;
import com.bizleap.collection.impl.BLHashMapWithBucket;
import com.bizleap.entities.Product;
import com.bizleap.services.impl.RandomProductGenerator;
import org.junit.Test;

public class TotalRunTimeTest {

	RandomProductGenerator randomGenerator = new RandomProductGenerator();
	BLHashMapWithBucket<String, Product> productMap = null;
	BLList<Product> productList = null;
	int productCount=100000;
	double totalApiCall;
	
	private void initializeProductList() {
		productList = randomGenerator.getProductList(productCount);
	}

	private void initializeProductMap() {
		initializeProductList();
		productMap = new BLHashMapWithBucket<String, Product>();
		for (int i = 0; i < productList.size(); i++) {
			productMap.put(productList.get(i).getBoId(), productList.get(i));
		}
	}

	@Test
	public void testPut() {
		System.out.println("Testing put method .....");
		initializeProductList();
		Instant start = Instant.now();
		for (Product product : productList) {
			productMap.put(product.getBoId(), product);
		}
		Instant end = Instant.now();
		Duration timeElasped = Duration.between(start, end);
		System.out.println("Put Average Run time taken: " + (double) timeElasped.toMillis() / productCount + "milisec");
		totalApiCall += (double) timeElasped.getSeconds();
		System.out.println();
	}

	@Test
	public void testKeySetAndValue() {
		System.out.println("\nTesting keySet method .....");
		initializeProductMap();
		Instant startforKeySet = Instant.now();	
		Set<String> keys = (Set<String>) productMap.getKeys();
		Instant endForKeySet = Instant.now();
		Duration timeElaspedForKeySet = Duration.between(startforKeySet, endForKeySet);
		System.out.println(
				"Keys Average Run time taken: " + (double) timeElaspedForKeySet.toMillis() / productCount + "milisec");
		totalApiCall += (double) timeElaspedForKeySet.getSeconds();
		System.out.println();

		System.out.println("\nTesting Values method .....");
		Instant startForValue = Instant.now();
		for (String key : keys) {
			productMap.get(key);
		}
		Instant endForValue = Instant.now();
		Duration timeElaspedForValue = Duration.between(startForValue, endForValue);
		System.out.println(
				"Values Average Run time taken: " + (double) timeElaspedForValue.toMillis() / productCount + "milisec");
		totalApiCall += (double) timeElaspedForValue.getSeconds();
		System.out.println();
	}

	@Test
	public void testRemove() {
		System.out.println("\nTesting remove method .....");
		initializeProductMap();
		Instant start = Instant.now();
		for (Product product : productList) {
			productMap.remove(product.getBoId());
		}
		Instant end = Instant.now();
		Duration timeElasped = Duration.between(start, end);
		System.out.println(" Remove Average Run time taken: " + (double) timeElasped.toMillis() / productCount + "milisec");
		totalApiCall += (double) timeElasped.getSeconds();
		System.out.println();
	}

	@Test
	public void testEntrySet() {
		System.out.println("Testing entry method .....");
		initializeProductMap();
		Instant start = Instant.now();
		//productMap.entrySet();
		System.out.println("Entry Set Size: " + productMap.getEntries().size());
		Instant end = Instant.now();
		Duration timeElasped = Duration.between(start, end);
		System.out.println("Entry Average Run time taken: " + (double) timeElasped.toMillis() / productCount + "sec");
		totalApiCall += (double) timeElasped.getSeconds();
		System.out.println();
	}

	@Test
	public void testAverage() {
		System.out.println("Testing average method .....");
		initializeProductMap();
		System.out.println("Total API " + (double) totalApiCall / 4 + "sec");
	}
}
*/