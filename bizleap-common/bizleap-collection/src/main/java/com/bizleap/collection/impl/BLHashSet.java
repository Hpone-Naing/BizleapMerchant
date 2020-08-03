package com.bizleap.collection.impl;

import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.bizleap.collection.BLSet;

public class BLHashSet<T> implements BLSet<T> {

	private T items[] = null;
	private int index = 0;
	private int capacity;
	private int increment = 100;
	private BLHashMapWithBucket<Integer, T> blHashMap;

	public BLHashSet() {
		index = 0;
		capacity = increment;
		this.items = (T[]) new Object[capacity];
	}

	public BLHashSet(T[] items) {
		this.items = items;
	}

	private class BLIterator implements Iterator<T> {

		int counter = 0;
		int max = size();

		@Override
		public boolean hasNext() {
			return counter < max;
		}

		@Override
		public T next() {
			if (items[counter] == null)
				return null;
			return (T) items[counter++];
		}
	}

	@Override
	public boolean add(T t) throws IndexOutOfBoundsException {
		if (blHashMap == null)
			blHashMap = new BLHashMapWithBucket<Integer, T>();
		if (index >= capacity - 1) {
			capacity += capacity;
			items = Arrays.copyOf(items, capacity);
		}
		if (!blHashMap.put(t.hashCode(), t))
			return false;
		items[index++] = t;
		return false;
	}

	private void reOrganize() {
		T[] newitems = (T[]) new Object[capacity];
		index = 0;
		for (int i = 0; i <= capacity - 1; i++) {
			if (this.items[i] != null) {
				newitems[index++] = this.items[i];
			}
		}
		this.items = Arrays.copyOf(newitems, capacity);
	}

	@Override
	public boolean remove(T t) throws ClassCastException, NullPointerException, UnsupportedOperationException {
		if (this.items.length == 0 || t == null) {
			return false;
		}
		for (int i = 0; i < index; i++) {
			if (t.equals(items[i])) {
				this.items[i] = null;
				reOrganize();
				return true;
			}
		}
		System.out.println("Not Found to remove: ");
		return false;
	}

	@Override
	public boolean isEmpty() {
		return index <= 0;
	}

	@Override
	public boolean contains(T t) {
		if (isEmpty())
			return false;
		for (Object obj : items) {
			if (obj == null && t == null)
				return true;
			if (obj != null) {
				if (obj.equals(t))
					return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public void clear() {
		index = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new BLIterator();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(51,13)
				.append(items)
				.toHashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof BLArrayListRefactor) || this.getClass() != o.getClass())
			return false;
		BLHashSet<T> originalObject = (BLHashSet<T>) o;
		if (this.size() != originalObject.size())
			return false;
		for (int i = 0; i < size(); i++) {
			if (!this.items[i].equals(originalObject.items[i]))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (isEmpty())
			return null;
		for (int i = 0; i < size(); i++) {
			buffer.append(", " + items[i]);
		}
		if (buffer.substring(1).length() <= 0)
			return "[]";
		return String.format("[%s]", buffer.substring(1));
	}
	
		@Override
		public T[] toArray() {
			return null;
		}
	}
