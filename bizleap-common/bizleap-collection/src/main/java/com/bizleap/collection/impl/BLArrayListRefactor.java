package com.bizleap.collection.impl;

import java.util.Arrays;
import java.util.Iterator;
import com.bizleap.collection.BLCollection;
import com.bizleap.collection.BLList;

public class BLArrayListRefactor<T> implements BLList<T> {
	int index; // This serves as an index.
	int capacity; // current capacity of the array
	int increment = 100; // to be added implemented whenever reindex
	private T[] items;
	int deletedCount;

	public BLArrayListRefactor() {
		index = 0;
		deletedCount = 0;
		capacity = increment;
		this.items = (T[]) new Object[capacity];
	}

	public BLArrayListRefactor(BLCollection<T> c) {
		items = (T[]) c.toArray();
		if ((index = items.length) != 0) {
			if (items.getClass() != Object[].class)
				items = (T[]) Arrays.copyOf(items, index, Object[].class);
		} else {
			this.items = (T[]) new Object[index];
		}
	}
	
	private class BLIterator<T> implements Iterator<T> {
		int counter = 0;
		int max = size();

		public boolean hasNext() {
			return counter < max;
		}

		public T next() {
			if (items[counter] == null) {
				counter++;
				return null;
			}
			return (T) items[counter++];
		}
	}

	public T[] toArray() {
		return (T[]) Arrays.copyOf(items, index);
	}

	public int size() {
		return index;
	}

	public boolean isEmpty() {
		return index <= 0;
	}

	public boolean add(T t) {
		if (index >= capacity - 1) {
			capacity += capacity;
			items = Arrays.copyOf(items, capacity);
		}
		this.items[index++] = (T) t;
		return true;
	}

	private void reOrganize() {
	//	System.out.println("reOrganizing: " + "index: " + index + ", deleted count: " + deletedCount + ", capacity: "
	//			+ capacity + ", increment: " + increment);
		T[] newitems = (T[]) new Object[capacity];
		deletedCount = 0;
		index = 0;
		for (int i = 0; i <= capacity - 1; i++) {
			if (this.items[i] != null) {
				newitems[index++] = this.items[i];
			}
		}
		this.items = Arrays.copyOf(newitems, capacity);
	}

	public boolean remove(T t) {
		if (this.items.length == 0 || t == null) {
			return false;
		}
		for (int i = 0; i < index; i++) {
			if (t.equals(items[i])) {
				this.items[i] = null;
				deletedCount++;
//				if (deletedCount > capacity / 2) {
				reOrganize();
//				}
//				System.out.println("Removing: " + "index: " + index + ", deleted count: " + deletedCount
//						+ ", capacity: " + capacity + ", increment: " + increment + ", Size:" + size());
				return true;
			}
		}
		System.out.println("Not Found to remove: ");
		return false;
	}

	public void clear() {
		for (int i = 0; i < index; i++)
			items[i] = null;
		index = 0;
	}

	public int indexOf(T t) {
		if (t == null) {
			for (int i = 0; i < index; i++) {
				if (items[i] == null)
					return i;
			}
		} else {
			for (int i = 0; i < index; i++) {
				if (t.equals(items[i]))
					return i;
			}
		}
		return -1;
	}

	public T get(int index) {
		if (index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return (T) items[index];
	}
	
	@Override
	public boolean contains(T t) {
		return indexOf(t) >= 0;
	}

	public Iterator<T> iterator() {
		return new BLIterator<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(items);
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BLArrayListRefactor<T> other = (BLArrayListRefactor<T>) obj;
		if (!Arrays.equals(items, other.items))
			return false;
		if (index != other.index)
			return false;
		return true;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (isEmpty())
			return null;
		for (int i = 0; i < size(); i++) {
			buffer.append(items[i]).append(",");
		}
		if (buffer.substring(1).length() <= 0)
			return "[]";
		return buffer.toString();
	}
}
