package com.bizleap.collection.impl;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BLNode<T extends Comparable<T>> implements Comparable <T> {
	private BLNode<T> leftNode;
	private BLNode<T> rightNode;
	private T value;

	public BLNode(T value) {
		this.value = value;
		leftNode = null;
		rightNode = null;
	}

	public BLNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BLNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public BLNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(BLNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public int compareTo(T t) {
		/*if(value.hashCode() == t.hashCode())
			return 0;
		if(value.hashCode() > t.hashCode())
			return 1;
		if(value.hashCode() < t.hashCode())
			return -1;
		return 0;*/
		return (getValue().compareTo(t));
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31)
					.append(value)
					.hashCode();
	}
	
	@Override
	public String toString() {
		return new StringBuffer()
				.append("[value: "+  this.value)
				.append(", leftnode:" + this.leftNode)
				.append(", rightnode:" + this.rightNode + "]").toString();
	}
}
    
	
    

