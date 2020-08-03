package com.bizleap.collection.impl;

import java.util.HashSet;
import java.util.Set;

import com.bizleap.collection.BLCollection;

public class BLHashMapWithLinkedList<K,V> {

	BLLinkedList<Node<K, V>> buckets[] = new BLLinkedList[256];

	public int getHashCode(K key) {
		int hashCode = 1;
		for (char ch : key.toString().toCharArray()) {
			hashCode += (13 * hashCode + (ch * ch)) * 0xff;
		}
		return Math.abs(hashCode % 256);
	}

	public boolean put(K key, V value) {
		int index = getHashCode(key);
		if (buckets[index] == null) {
			buckets[index] = new BLLinkedList<>();
			buckets[index].put(new Node<>(key, value));
		} else {
			BLLinkedList<Node<K, V>>.Entry<Node<K, V>> currentNode = buckets[index].head;
			while (currentNode != null) {
				if (currentNode.value.isContainKey(key)) {
					currentNode.value.key = key;
					currentNode.value.value = value;
					return true;
				}
				currentNode = currentNode.tail;
			}
			buckets[index].put(new Node<>(key, value));
		}
		return true;
	}

	public boolean remove(K key) {
		BLLinkedList<Node<K, V>>.Entry<Node<K, V>> currentNode = buckets[getHashCode(key)].head;
		while (currentNode != null) {
			if (currentNode.value.isContainKey(key)) {
				buckets[getHashCode(key)].remove(currentNode.value);
				return true;
			}
			currentNode = currentNode.tail;
		}
		return false;
	}

	public V get(K key) {
		BLLinkedList<Node<K, V>>.Entry<Node<K, V>> currentNode = buckets[getHashCode(key)].head;
		while (currentNode != null) {
			if (currentNode.value.isContainKey(key)) {
				return currentNode.value.value;
			}
			currentNode = currentNode.tail;
		}
		return null;
	}

	public Set<K> keySet() {
		Set<K> keys = null;
		if (keys == null) {
			keys = new HashSet<>();
		}
		for (BLLinkedList<Node<K, V>> bucket : buckets) {
			if (bucket != null) {
				BLLinkedList<Node<K, V>>.Entry<Node<K, V>> currentNode = bucket.head;
				while (currentNode != null) {
					keys.add(currentNode.value.key);
					currentNode = currentNode.tail;
				}
			}
		}
		return keys;
	}

	public BLCollection<V> values() {
		BLCollection<V> values = null;
		if (values == null) {
			values = (BLCollection<V>) new HashSet<>();
		}
		for (BLLinkedList<Node<K, V>> bucket : buckets) {
			if (bucket != null) {
				BLLinkedList<Node<K, V>>.Entry<Node<K, V>> currentNode = bucket.head;
				while (currentNode != null) {
					values.add(currentNode.value.value);
					currentNode = currentNode.tail;
				}
			}
		}
		return values;
	}
/*
	public Set<BLLinkedList<Node<K, V>>> entrySet(){
		Set<BLLinkedList<Node<K, V>>> entries = null;
		if(entries == null) 
			entries = new HashSet<>();
		for(BLLinkedList<Node<K, V>> bucket : buckets) {
			if(bucket != null) {
				BLLinkedList<Node<K, V>>.Entry<Node<K, V>> currentNode = bucket.head;
				while(currentNode != null) {
					entries.add((BLLinkedList<Node<K, V>>) currentNode.value.value);
					currentNode=currentNode.tail;
				}
			}
		}
		return entries;
	}
*/	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (BLLinkedList<Node<K, V>> bucket : buckets) {
			if (bucket != null) {
				BLLinkedList<Node<K, V>>.Entry<Node<K, V>> currentNode = bucket.head;
				while (currentNode != null) {
					buffer.append(", " + currentNode.value.key + "=" + currentNode.value.value);
					currentNode = currentNode.tail;
				}
			}
		}
		return String.format("{%s}", buffer.substring(2));
	}
}
