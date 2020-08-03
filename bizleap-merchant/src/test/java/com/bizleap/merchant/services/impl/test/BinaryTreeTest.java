package com.bizleap.merchant.services.impl.test;

import org.junit.Test;
import com.bizleap.collection.impl.BLBinaryTree;

public class BinaryTreeTest {

	BLBinaryTree<Integer> blBinaryTree = new BLBinaryTree<>();
	private long startTime;
	private long endTime;
	private double total;

	private void initialize() {
		for (int i = 0; i < 1000; i++) {
			blBinaryTree.insert(i);
		}
		System.out.println(blBinaryTree);
	}

	@Test
	public void insertTest() {
		System.out.println("Test insert method....");
		startTime = System.currentTimeMillis();
		initialize();
		endTime = System.currentTimeMillis();
		total = endTime-startTime;
		System.out.println("Total time: " + total + " ms");
	}
	
	@Test
	public void FindTest() {
		System.out.println("Test find method....");
		startTime = System.currentTimeMillis();
		initialize();
		for (int i = 0; i < 1000; i++) {
			blBinaryTree.find(i);
		}
		endTime = System.currentTimeMillis();
		total = endTime-startTime;
		System.out.println("Total time: " + total + " ms");
	}
	
	@Test
	public void deleteTest() {
		System.out.println("Test delete method....");
		startTime = System.currentTimeMillis();
		initialize();
		/*BLNode<Integer> root = blBinaryTree.getRoot();
		if(root != null) {
			blBinaryTree.removeRecursive(root, root.getValue());
		}*/
		for (int i = 0; i < 1000; i++) {
			blBinaryTree.remove(i);
		}
		endTime = System.currentTimeMillis();
		total = endTime-startTime;
		System.out.println("Total time: " + total + " ms");
	}
}
