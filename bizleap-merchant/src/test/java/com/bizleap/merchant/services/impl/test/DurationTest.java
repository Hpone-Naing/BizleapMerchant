package com.bizleap.merchant.services.impl.test;
/*package com.bizleap.services.impl.test;

import org.junit.Test;
import com.bizleap.collection.BLList;
import com.bizleap.collection.impl.BLHashMapWithBucket;
import com.bizleap.entities.Product;
import com.bizleap.services.impl.RandomProductGenerator;

public class DurationTest {

	RandomProductGenerator randomGenerator = new RandomProductGenerator();
	BLHashMapWithBucket<String, Product> productMap = null;
	BLList<Product> productList = null;
	int productCount = 1000000;
	long startTime, endTime;
	double total, average;

	private void initializeProductList() {
		startTime = System.currentTimeMillis();
		if(productList == null) {
		productList = randomGenerator.getProductList(productCount);
		}
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken to build the list of " + productCount +": "+ total + " ms");		
	}

	private void initializeProductMap() {
		productList=null;
		initializeProductList();
		productMap = new BLHashMapWithBucket<String, Product>();
		for (int i = 0; i < productList.size(); i++) {
			productMap.put(productList.get(i).getBoId(), productList.get(i));
		}
	}

	@Test
	public void testProductList() {
		System.out.println("Test product list....");
		startTime = System.currentTimeMillis();
		productList = randomGenerator.getProductList(productCount);
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + " ms");
		average = total / productCount;
		System.out.println("Average time taken for get product list: " + average);
		System.out.println();
	}

	@Test
	public void testPut() {
		System.out.println("Test put method...");
		productList=null;
		initializeProductList();
		productMap = new BLHashMapWithBucket<String, Product>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < productList.size(); i++) {
			productMap.put(productList.get(i).getBoId(), productList.get(i));
		}
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + " ms");
		average = total / productCount;
		System.out.println("Average time taken for put method: " + average);
		System.out.println();
	}

	@Test
	public void testGet() {
		System.out.println("Test get method...");
		initializeProductMap();
		startTime = System.currentTimeMillis();
		for (String key :  productMap.getKeys()) {
			productMap.get(key);
		}
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + " ms");
		average = total / productCount;
		System.out.println("Average time taken for get method: " + average);
		System.out.println();
	}
	
	@Test
	public void testGetKeySet() {
		System.out.println("Test keySet method...");
		initializeProductMap();
		startTime = System.currentTimeMillis();
		System.out.println("KeySet Size: " + productMap.getKeys().size());
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + " ms");
		average = total / productCount;
		System.out.println("Average time taken for get method: " + average);
		System.out.println();
	}
	
	@Test
	public void testGetValues() {
		System.out.println("Test value method...");
		initializeProductMap();
		startTime = System.currentTimeMillis();
		System.out.println("Values Size: " + productMap.getValues().size());
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + " ms");
		average = total / productCount;
		System.out.println("Average time taken for get method: " + average);
		System.out.println();
	}

	@Test
	public void testRemove() {
		System.out.println("Test remove method...");
		initializeProductMap();
		startTime = System.currentTimeMillis();
		for (String key : productMap.getKeys()) {
			productMap.remove(key);
		}
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + " ms");
		average = total / productCount;
		System.out.println("Average time taken for remove method: " + average);
		System.out.println();
	}

	@Test
	public void testGetEntries() {
		System.out.println("Test entry method...");
		initializeProductMap();
		startTime = System.currentTimeMillis();
		//productMap.entrySet();
		System.out.println("Entry Set Size: " + productMap.getEntries().size());
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + " ms");
		System.out.println();
	}
}*/