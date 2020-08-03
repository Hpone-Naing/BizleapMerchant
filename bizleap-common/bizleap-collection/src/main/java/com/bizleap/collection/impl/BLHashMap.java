package com.bizleap.collection.impl;

import java.util.HashSet;
import java.util.Set;
import com.bizleap.collection.BLCollection;

public class BLHashMap<K,V> {

	Node<K, V> buckets[] = new Node[256];

	public class Node<K, V> {
		private K key;
		private V value;
		private BLLinkedList<Node<K, V>> values = null;

		public Node() {
			if (values == null)
				values = new BLLinkedList<>();
		}

		public boolean isSame(K key) {
			return this.key != null && this.key.equals(key);
		}

		@Override
		public String toString() {
			return new StringBuffer().append(key + "=" + value + ", ").toString();
		}
	}

	public int getHashCode(K key) {
		int hashCode = 1;
		for (char ch : key.toString().toCharArray()) {
			hashCode += (13 * hashCode + (ch * ch)) * 0xff;
		}
		return Math.abs(hashCode % 256);
	}

	public boolean put(K key, V value) {
		Node<K, V> newNode = null;
		int index = getHashCode(key);
		if (buckets[index] == null) {
			if (newNode == null)
				newNode = new Node<>();
			newNode.key = key;
			newNode.value = value;
			buckets[index] = newNode;
		} else {
			if (buckets[index].isSame(key)) {
				buckets[index].key = key;
				buckets[index].value = value;
			} else {
				Node<K, V> collisionNode = new Node<>();
				collisionNode.key = key;
				collisionNode.value = value;
				buckets[index].values.put(collisionNode);
			}
		}
		return true;
	}

	public V get(K k) {
		int findIndex = getHashCode(k);
		if (buckets[findIndex].isSame(k))
			return buckets[findIndex].value;
		BLLinkedList<Node<K, V>> list = buckets[findIndex].values;
		BLLinkedList<BLHashMap<K, V>.Node<K, V>>.Entry<BLHashMap<K, V>.Node<K, V>> currentNode = list.head;
		while (currentNode != null) {
			if (currentNode.value.isSame(k))
				return currentNode.value.value;
			currentNode = currentNode.tail;
		}
		return null;
	}

	public boolean remove(K key) {
		int removedIndex = getHashCode(key);
		if (buckets[removedIndex].isSame(key)) {
			if (buckets[removedIndex].values.head == null) {
				buckets[removedIndex] = null;
				return true;
			}
			BLLinkedList<Node<K, V>> copy = buckets[removedIndex].values;
			buckets[removedIndex] = copy.head.value;
			buckets[removedIndex].values = copy;
			buckets[removedIndex].values.remove(buckets[removedIndex].values.head.value);
			BLLinkedList<Node<K, V>> removedHead = buckets[removedIndex].values;
			buckets[removedIndex].values = removedHead;
			return true;
		}
		BLLinkedList<BLHashMap<K, V>.Node<K, V>>.Entry<BLHashMap<K, V>.Node<K, V>> currentNode = buckets[removedIndex].values.head;
		while (currentNode != null) {
			if (currentNode.value.key.equals(key)) {
				return buckets[removedIndex].values.remove(currentNode.value);
			}
			currentNode = currentNode.tail;
		}
		return false;
	}

	public Set<K> keySet() {
		Set<K> keys = new HashSet<>();
		for (Node<K, V> node : buckets) {
			if (node != null) {
				keys.add((K) node.key);
				BLLinkedList<BLHashMap<K, V>.Node<K, V>>.Entry<BLHashMap<K, V>.Node<K, V>> currentNode = node.values.head;
				while(currentNode != null) {
					keys.add(currentNode.value.key);
					currentNode = currentNode.tail;
				}
			}
		}
		return keys;
	}

	public BLCollection<V> values() {
		BLCollection<V> valueList = null;
		if (valueList == null)
			valueList = new BLArrayListRefactor<>();
		BLLinkedList<BLHashMap<K, V>.Node<K, V>>.Entry<BLHashMap<K, V>.Node<K, V>> currentNode;
		for (Node<K, V> key : buckets) {
			if (key != null) {
				valueList.add(key.value);
				currentNode = key.values.head;
				while (currentNode != null) {
					valueList.add((V) currentNode.value);
					currentNode = currentNode.tail;
				}
			}
		}
		return valueList;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (buckets == null)
			return null;
		for (Node<K, V> node : buckets) {
			if (node != null) {
				if (buffer.length() < 1)
					buffer.append(node.key + "=" + node.value + node.values.toString());
				else
					buffer.append(", " + node.key + "=" + node.value + node.values.toString());
			}
		}
		return String.format("{%s}", buffer);
	}
}
