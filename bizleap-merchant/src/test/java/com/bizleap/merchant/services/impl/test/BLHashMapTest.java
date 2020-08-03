package com.bizleap.merchant.services.impl.test;
/*package com.bizleap.services.impl.test;

import org.junit.Test;

import com.bizleap.collection.BLList;
import com.bizleap.collection.impl.BLHashMapWithBucket;
import com.bizleap.entities.Product;
import com.bizleap.services.impl.RandomProductGenerator;

public class BLHashMapTest {
	
	@Test
	public void testPut() {
		RandomProductGenerator randomProductGenerator = new RandomProductGenerator();
		BLList<Product> productList = randomProductGenerator.getProductList(1000);
		BLHashMapWithBucket<String, String> randomProduct = new BLHashMapWithBucket<>();
		Long startCallMethod = System.currentTimeMillis();
		for (Product product : productList) {
			randomProduct.put(product.getBoId() + product.getName(), product.getBoId() + product.getProductType());
		}
		Long endCallMethod = System.currentTimeMillis();
		System.out.println(randomProduct);
		System.out.println("HashMap DataSize: " + randomProduct.getSize());
		System.out.println("Time Taken:" + (endCallMethod - startCallMethod) + "milliseconds");		
	}

}
*/