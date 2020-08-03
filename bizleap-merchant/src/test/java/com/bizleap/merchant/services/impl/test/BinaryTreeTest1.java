package com.bizleap.merchant.services.impl.test;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import org.junit.Test;
import com.bizleap.collection.impl.BLBinaryTree;
import com.bizleap.collection.impl.BLNode;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.services.impl.RandomProductGenerator;

public class BinaryTreeTest1 {
	BLBinaryTree<Product> blBinaryTree = new BLBinaryTree<Product>();
	Instant startTime;
	Instant endTime;
	Duration duration;

	private void initialize() {
		RandomProductGenerator productGenerator = new RandomProductGenerator();
		blBinaryTree = productGenerator.getProductsByBinaryTree(10);
		System.out.println(blBinaryTree);
	}

	@Test
	public void insertTest() {
		startTime = Instant.now();
		initialize();
		endTime = Instant.now();
		duration = Duration.between(startTime, endTime);
		System.out.println("insert method duration: " + (double) duration.toMillis() / 1000);
	}

	@Test
	public void FindTest() {
		startTime = Instant.now();
		initialize();	
		blBinaryTree.find(new Product().boId("FLO001"));
		endTime = Instant.now();
		duration = Duration.between(startTime, endTime);
		System.out.println("find method duration: " + (double) duration.toMillis() / 1000);
	}

	@Test
	public void deleteTest() throws IOException {
		startTime = Instant.now();
		initialize();		
		BLNode<Product> root = blBinaryTree.getRoot();
		if (root != null) {
			blBinaryTree.remove(root, root.getValue());
		}
		endTime = Instant.now();
		duration = Duration.between(startTime, endTime);
		System.out.println("remove method duration: " + (double) duration.toMillis() / 1000);
	}

}
