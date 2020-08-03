package com.bizleap.collection.impl;

public class BLBinaryTree<T extends Comparable<T>>{

	BLNode<T> root;
		
	public BLNode<T> getRoot() {
		return root;
	}

	public void setRoot(BLNode<T> root) {
		this.root = root;
	}
	
	private BLNode<T> insert(BLNode<T> current, T value) {

		if (current.compareTo(value) < 0) {
			if (current.getLeftNode() == null) {
				current.setLeftNode(new BLNode<T>(value));
			} else {
				//current.setLeftNode(insert(current.getLeftNode(), value));
				insert(current.getLeftNode(), value);
			}
		}
		if (current.compareTo(value) > 0) {
			if (current.getRightNode() == null) {
				current.setRightNode(new BLNode<T>(value));
			} else {
				//current.setRightNode(insert(current.getRightNode(), value));
				insert(current.getRightNode(), value);
			}
		}
		return current;
	}

	public void insert(T value) {
		if(value != null) {
			if (root == null) {
				root = new BLNode<T>(value);
			} else {
				insert(root, value);
			}
		}
	}

	private T getSmallestNode(BLNode<T> node) {
		if (node.getLeftNode() == null) {
			return node.getValue();
		}
		return getSmallestNode(node.getLeftNode());
	}

	public BLNode<T> remove(BLNode<T> current, T value) {
		if (current == null) 
			return null;
		
		if ( current.compareTo(value) == 0) { 
			if (current.getLeftNode() != null && current.getRightNode() != null) { 	// has two childs
				T smallestValue = getSmallestNode(current.getRightNode());
				current.setValue(smallestValue);
				current.setRightNode(remove(current.getRightNode(), smallestValue));
			}
			else if (current.getLeftNode() == null) {   // has right child
				current = current.getRightNode();
			}
			else if (current.getRightNode() == null) {   // has left child
				current = current.getLeftNode();
			} 
			 else{     // has no child
				current = null;
			}
		}
		else if (current.compareTo(value) < 0) {
			current.setLeftNode(remove(current.getLeftNode(), value));
		}
		 else {
			current.setRightNode(remove(current.getRightNode(), value));
		}
		return current;
	}

	public T remove(T value) {
		root = remove(root, value);
		return value;
	}

	private BLNode<T> find(BLNode<T> current, T value) {
		if (current == null) {
			return null;
		}
		if (current.compareTo(value) < 0) {
			return find(current.getLeftNode(), value);
		}
		if (current.compareTo(value) > 0) {
			return find(current.getRightNode(), value);
		}
		return current;
	}

	public BLNode<T> find(T value) {
		return (value == null)? null : find(root, value);
	}

	private void preOrder(BLNode<T> node){ 
		if(node == null)
			return;
		System.out.println(" " + root.getValue());
		preOrder(root.getLeftNode());
		preOrder(root.getRightNode());
	}
	
	public void preOrder() {
		preOrder(root);
	}
	private void inOrder(BLNode<T> node){ 
		if(node == null)
			return;
		inOrder(root.getLeftNode());
		System.out.println(" " + root.getValue());
		inOrder(root.getRightNode());
	}
	
	public void inOrder() {
		inOrder(root);
	}
	private void postOrder(BLNode<T> node){ 
		if(node == null)
			return;
		postOrder(root.getLeftNode());
		postOrder(root.getRightNode());
		System.out.println(" " + root.getValue());
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	@Override
	public String toString() {
		if (root == null)
			return null;
		StringBuffer stringBuffer = new StringBuffer();
		return stringBuffer.append(root).toString();
	}
}
