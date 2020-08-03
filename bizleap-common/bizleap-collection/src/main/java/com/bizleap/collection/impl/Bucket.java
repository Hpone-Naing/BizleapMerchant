package com.bizleap.collection.impl;

public class Bucket<K, V> {

	Node<K, V> head;
	int size=0;
	
	/*public boolean put(K key, V value) {
		Node<K, V> newNode = new Node<K, V>(key, value);
		newNode.next=null;
		if (head == null) {
			head = newNode;
		} 
		else {
			Node<K, V> currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}		
		size++;
		return true;
	}*/
	
	public boolean put(K key, V value) {
		Node<K, V> newNode = new Node<K, V>(key, value);
		newNode.next = null;
		
		Node<K, V> currentNode = head;
		while (currentNode != null && currentNode.next != null) {
			currentNode = currentNode.next;
		}
		if(currentNode != null) {
			currentNode.next = newNode;
		}
		else {
			head = newNode;
		}
		size++;
		return true;
	}

	public boolean remove(K key) {
		Node<K, V> currentNode = head;
		Node<K, V> previousNode = null;
		while (currentNode != null && !currentNode.isContainKey(key)) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		if (currentNode == null)
			return false;
		
		if (previousNode == null) {
			head = currentNode.next;
			size--;
			return true;
		}
		
		previousNode.next = currentNode.next;
		size--;
		return true;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		Node<K, V> currentNode = head;
		while (currentNode != null) {
				buffer.append(currentNode.key + "=" + currentNode.value);
			currentNode = currentNode.next;
		}
		return String.format("{%s}", buffer.substring(1));
	}
}
