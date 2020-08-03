package com.bizleap.merchant.services.impl.test;

import org.junit.Test;
import com.bizleap.collection.impl.BLStack;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.services.impl.RandomProductGenerator;

public class BLStackTest {
	private BLStack<Product> productStack = null;
	private int productCount = 10;
	private long startTime, endTime;
	private double total, average;

	private void initializeProductList() {
		if (productStack == null) {
			RandomProductGenerator randomGenerator = new RandomProductGenerator();
			productStack = randomGenerator.getProductsByStack(productCount);
		}
	}

	private BLStack<String> getBoIdList() {
		BLStack<String> boIdList = new BLStack<String>();
		for (Product product : productStack) {
			boIdList.add(product.getBoId());
		}
		return boIdList;
	}

	private Product getProductByBoId(String boId, BLStack<Product> productList) {
		for (Product product : productList) {
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
		initializeProductList();
		System.out.println("Product list size: " + productStack.size());
		for (String boId : getBoIdList()) {
			Product product = getProductByBoId(boId, productStack);
			System.out.println("Product list size before: " + productStack.size());
			if (product != null)
				productStack.remove(product);
			System.out.println("Product list size after: " + productStack.size());
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
	public void testPop() {
		System.out.println("Test pop method....");
		startTime = System.currentTimeMillis();
		initializeProductList();
		System.out.println("Product list size: " + productStack.size());
		for (String boId : getBoIdList()) {
			Product product = getProductByBoId(boId, productStack);
			System.out.println("Product list size before: " + productStack.size());
			if (product != null)
				productStack.pop();
			System.out.println("Product list size after: " + productStack.size());
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
	public void testPeek() {
		System.out.println("Test peek method....");
		startTime = System.currentTimeMillis();
		initializeProductList();
		System.out.println("Product list size before: " + productStack.size());
		while (!productStack.empty()) {
			System.out.println("peek from product stack: " + productStack.peek());
			System.out.println("Product list size after: " + productStack.size());
		}
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + "ms");
		average = total / productCount;
		System.out.println("Average time taken for remove product list: " + average + "ms");
		System.out.println();
	}
}
