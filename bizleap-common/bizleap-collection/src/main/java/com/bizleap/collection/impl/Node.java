package com.bizleap.collection.impl;

public class Node<K, V> {
	
	K key;
	V value;
	Node<K, V> next;
	
	public Node() {

	}

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public Node<K, V> key(K key) {
		this.key = key;
		return this;
	}

	public Node<K, V> value(V value) {
		this.value = value;
		return this;
	}

	public boolean isContainKey(Object key) {
		return key != null && this.key.equals(key);
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node<K, V> getTail() {
		return next;
	}

	public void setTail(Node<K, V> tail) {
		this.next = tail;
	}
	
	@Override
	public String toString() {
		return new StringBuffer().append(key).append(value).toString();
	}
}
