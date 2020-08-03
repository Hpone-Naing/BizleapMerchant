package com.bizleap.collection.impl;

import java.util.HashSet;
import java.util.Set;
import com.bizleap.collection.BLCollection;
import com.bizleap.collection.BLList;

public class BLHashMapWithBucket<K, V> {

	private int bucketCount = 256;
	private Bucket<K, V> buckets[] = new Bucket[bucketCount];
	private int size = 0;

	private int getHashCode(K key) {
		if(key == null) {
			return -1;
		}	
		int hashCode = 1;
	//	System.out.println("Key is: " + key);
		for (char ch : key.toString().toCharArray()) {
			hashCode += ch * ch;
		}
		return hashCode % 256;
	}
	
	public boolean isValidIndex(int index) {
		return index >= 0 && index < this.bucketCount;
	}

	public boolean put(K key, V value) {
		
		int index = getHashCode(key);
		if(!isValidIndex(index)){
			return false;
		}
		if (buckets[index] == null) {
			buckets[index] = new Bucket<>();
			buckets[index].put(key, value);
		} else { 
			Node<K, V> currentNode = buckets[index].head;
			while (currentNode != null) {
				if (currentNode.isContainKey(key)) {
					currentNode.value = value;
					size++;
					return false;
				}
				currentNode = currentNode.next;
			}
			buckets[index].put(key, value);
		}
		size++;
		return true;
	}
		
	public V get(K key) {
		if(key == null) {
			new Exception().printStackTrace();
		}
		int index = getHashCode(key);
		if(isValidIndex(index)) {
			if(buckets[index] == null) {
				return null;
			}
			Node<K, V> currentNode = buckets[index].head;
			while (currentNode != null) {
				if (currentNode.isContainKey(key)) {
					return currentNode.value;
				}
				currentNode = currentNode.next;
			}
		}
		return null;
//		if(key == null) {
//			System.out.println("Key get(): " + key);
//			//new Exception().printStackTrace();
//			return null;
//		}
//		int index = getHashCode(key);
//		if(isValidIndex(index)){
//			if(buckets[index] == null) {
//				System.out.println("Get failed.");
//				return null;
//			}
//			Node<K, V> currentNode = buckets[index].head;	
//			while (currentNode != null) {
//				if (currentNode.isContainKey(key)) {
//					return currentNode.value;
//				}
//				currentNode = currentNode.next;
//			}
//		}
//		return null;
	}

	public int getSize() {
		return size;
	}

	public boolean remove(K key) {
		int index = getHashCode(key);
		if(isValidIndex(index)){
			size--;
			Bucket<K,V> bucket = buckets[index];
			if(bucket != null) {
				buckets[index].remove(key);
			}
			else {
				throw new ArrayIndexOutOfBoundsException("Bucket is null for " + key);
			}
			//return key != null && buckets[index].remove(key);
		}
		return false;		
	}
	
	public BLList<K> getKeys() {
	
		BLList<K> keys = null;
		if (keys == null) {
			keys = new BLArrayListRefactor();
		}
		for (Bucket<K, V> bucket : buckets) {
			if (bucket != null) {
				Node<K, V> currentNode = bucket.head;
				while (currentNode != null) {
					keys.add(currentNode.key);
					currentNode = currentNode.next;
				}
			}
		}
		return keys;
	}
	
	public BLCollection<V> getValues() {
		
		BLCollection<V> values = null;
		if (values == null) {
			values = new BLArrayListRefactor<>();
		}
		for (Bucket<K, V> bucket : buckets) {
			if (bucket != null) {
				Node<K, V> currentNode = bucket.head;
				while (currentNode != null) {
					values.add(currentNode.value);
					currentNode = currentNode.next;
				}
			}
		}
		return values;
	}
	
	public Set<Node<K,V>> getEntries() {
		
		Set<Node<K,V>> entries = null;
		if(entries == null) 
			entries = new HashSet<Node<K,V>>(); 
		for(Bucket<K,V> bucket : buckets) {
			if(bucket != null) {
				Node<K,V> currentNode = bucket.head;
				while(currentNode != null) {
					entries.add(currentNode);
					currentNode = currentNode.next;
				}
			}
		}
		return entries;
	}

	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		int index = 0;
		for (Bucket<K, V> bucket : buckets) {
			if (bucket != null) {
				buffer.append("\n index[" + index + "]");
				Node<K, V> currentNode = bucket.head;
				while (currentNode != null) {
					buffer.append(", " + currentNode.key + "=" + currentNode.value);
					currentNode = currentNode.next;
				}
			} else
				buffer.append("\n index[" + index + "]");
			index++;
		}
		return String.format("{%s}", buffer.substring(1));
	}
}
