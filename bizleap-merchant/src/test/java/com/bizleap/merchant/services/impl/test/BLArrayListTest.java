package com.bizleap.merchant.services.impl.test;

import org.junit.Test;
import com.bizleap.collection.BLList;
import com.bizleap.collection.impl.BLArrayListRefactor;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.services.impl.RandomProductGenerator;

public class BLArrayListTest {
	private BLList<Product> productList = null;
	private int productCount = 1000;
	private long startTime, endTime;
	private double total, average;

	private void initializeProductList() {
		if (productList == null) {
			RandomProductGenerator randomGenerator = new RandomProductGenerator();
			//productList = randomGenerator.getProductList(productCount);
		}
	}

	private BLList<String> getBoIdList() {
		BLList<String> blList = new BLArrayListRefactor<String>();

		for (Product product : productList) {
			blList.add(product.getBoId());
		}
		return blList;
	}

	private Product getProductByBoId(String boId, BLList<Product> productList) {

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
		System.out.println("Product list size: " + productList.size());
		System.out.println();
		for (String boId : getBoIdList()) {
			System.out.println("Removing product: " + boId);
			Product product = getProductByBoId(boId, productList);
			System.out.println("Product list size before: " + productList.size());
			if (product != null)
				productList.remove(product);
			System.out.println("Product list size after: " + productList.size());
			System.out.println("---------------------------");
		}
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		System.out.println("Total time taken: " + total + "ms");
		average = total / productCount;
		System.out.println("Average time taken for remove product list: " + average + "ms");
		System.out.println();
	}

	
	  //@Test 
	 public void testRemoveNoneForEach(){
	  System.out.println("Test remove method....");
	  startTime =System.currentTimeMillis(); 
	  initializeProductList();
	  System.out.println("Product list: " + productList);
	  for(int i = 0; i<productList.size(); i++) { 
		  System.out.println("i: " + i); 
		  Product product =productList.get(i);
		  System.out.println("Removing product: " + product); 
		  System.out.println("Product list size before: " + productList.size()); 
		  productList.remove(product);
		  System.out.println("Product list size after: " + productList.size());
		  System.out.println("---------------------------"); 
		  } 
	  endTime = System.currentTimeMillis(); 
	  total = endTime - startTime;
	  System.out.println("Total time taken: " + total + "ms"); average = total /productCount;
	  System.out.println("Average time taken for remove product list: " + average + "ms"); System.out.println();   
	  }
}
