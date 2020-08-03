package com.bizleap.merchant.services.impl.test;

import org.junit.Test;
import com.bizleap.collection.BLSet;
import com.bizleap.collection.impl.BLHashSet;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.services.impl.RandomProductGenerator;

public class BLHashSetTest {

	private BLSet<Product> products;
	private int productCount = 100;
	private long startTime;
	private long endTime;
	private double total;
	private double average;

	private void initializeProducts() {
		if (products == null) {
			RandomProductGenerator randomGenerator = new RandomProductGenerator();
			products = randomGenerator.getProducts(productCount);
		}
	}

	private BLSet<String> getBoIdList() {
		BLSet<String> boIds = new BLHashSet<String>();
		for (Product product : products) {
			boIds.add(product.getBoId());
		}
		return boIds;
	}

	private Product getProductByBoId(String boId, BLSet<Product> products) {
		for (Product product : products) {
			if (product != null && product.getBoId().equals(boId)) {
				return product;
			}
		}
		return null;
	}

	@Test
	public void testRemove() {
		System.out.println("Test remove method....");
		startTime = System.currentTimeMillis();
		initializeProducts();
		System.out.println("Product list size: " + products.size());
		for (String boId : getBoIdList()) {
			Product product = getProductByBoId(boId, products);
			System.out.println("Products size before: " + products.size());
			if (product != null)
				products.remove(product);
			System.out.println("Products size after: " + products.size());
			System.out.println("---------------------------");
		}
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + "ms");
		average = total / productCount;
		System.out.println("Average time taken for remove product list: " + average + "ms");
		System.out.println();
	}
	
	@Test
	public void testAdd() {
		System.out.println("Test add method....");
		startTime = System.currentTimeMillis();
		initializeProducts();
		System.out.println("Produts size: " + products.size());
		for (String boId : getBoIdList()) {
			Product product = getProductByBoId(boId, products);
			System.out.println("Products size before: " + products.size());
			if (product != null)
				products.add(product.clone());		
			System.out.println("Products size after: " + products.size());
			System.out.println("---------------------------");
		}
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + "ms");
		average = total / productCount;
		System.out.println("Average time taken for add products: " + average + "ms");
		System.out.println();
	}	
}
