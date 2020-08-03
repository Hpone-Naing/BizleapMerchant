package com.bizleap.collection.impl;

public class BLLinkedList<V>{

	Entry<V> head=null;
	
	class Entry<V> {
		V value;
		Entry<V> tail;
		
		public Entry(V value) {
			this.value = value;
		}

		public boolean isSame(V value) {
			return value != null && this.value.equals(value);
		}
		
		@Override
		public String toString() {
			return new StringBuffer().append(value + ", " + tail).toString();
		}
	}

	public boolean contain(V value) {
		if (head == null)
			return false;
		Entry<V> currentNode = head;
		while (currentNode != null) {
			if (currentNode.isSame(value))
				return true;
			currentNode = currentNode.tail;
		}
		return false;
	}

	public boolean remove(V value) {
		Entry<V> currentNode = head;
		Entry<V> previousNode = null;
		while (currentNode != null && !currentNode.isSame(value)) {
			previousNode = currentNode;
			currentNode = currentNode.tail;
		}
		if (currentNode == null) {
			return false;
		}
		if (previousNode == null) {
			head = currentNode.tail;
			return true;
		}
		previousNode.tail = currentNode.tail;
		return true;

	}

	public boolean put(V value) {
		Entry<V> newNode = new Entry<V>(value);
		newNode.tail = null;

		if (head == null)
			head = newNode;
		else {
			Entry<V> lastNode = head;
			while (lastNode.tail != null) {
				lastNode = lastNode.tail;
			}
			lastNode.tail = newNode;
		}
		return true;
	}
	
	@Override
	public String toString() {
		Entry<V> currentNode = head;
		StringBuilder stringBuilder=new StringBuilder();
		while (currentNode != null) {
			stringBuilder.append(currentNode.value);
			currentNode = currentNode.tail;
		}
		return String.format("%s", stringBuilder.insert(0,""));
	}			
}
	
	

