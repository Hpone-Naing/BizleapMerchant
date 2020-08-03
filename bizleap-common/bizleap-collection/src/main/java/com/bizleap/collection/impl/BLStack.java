package com.bizleap.collection.impl;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.bizleap.collection.BLList;

public class BLStack<T> implements BLList<T> {

		private T items[] = null;
		private int size = -1;
		private int length = 1000;
		private int index = 0;

		public BLStack() {
			this.items = (T[]) new Object[length];
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
		public boolean add(T t) throws ArrayIndexOutOfBoundsException {
			if (isFull())
				resize();
			items[++size] = t;
			index++;
			return true;
		}

		private boolean isFull() {
			return size() > items.length - 1;
		}

		private void resize() {
			length = size() + 1000;
			items = Arrays.copyOf(items, length);
		}

		@Override
		public boolean remove(T t) throws ClassCastException, NullPointerException, UnsupportedOperationException {
			for (int i = 0; i < size(); i++) {
				if (items[i].equals(t)) {
					changeItemsPosition(i);
					index--;
					return true;
				}
			}
			return false;
		}

		private void changeItemsPosition(int removedIndex) {
			//arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
			System.arraycopy(Arrays.copyOfRange(items, 0, removedIndex), 0, items, 0, removedIndex);
			System.arraycopy(Arrays.copyOfRange(items, removedIndex + 1, size()), 0, items, removedIndex,
					(size() - 1) - removedIndex);
		}

		@Override
		public boolean isEmpty() {
			return items == null || (size <= 0 && items[0] == null);
		}

		@Override
		public boolean contains(T obj) {
			for (T obj1 : items) {
				if (obj1 == null && obj == null)
					return true;
				if (obj1.equals(obj))
					return true;
			}
			return false;
		}

		@Override
		public int size() {
			return index;
		}

		@Override
		public void clear() {
			//size = -1;
			index = 0;
		}

		@Override
		public Iterator<T> iterator() {
			return new BLIterator();
		}

		@Override
		public T get(int index) {
			if (index < size())
				return (T) items[index];
			return null;
		}

		@Override
		public int indexOf(T t) {
			for (int i = 0; i < items.length; i++) {
				if (t.equals(items[i]))
					return i;
			}
			return -1;
		}

		public T push(T item) {
			add(item);
			return item;
		}

		public T pop() {
			if (!empty()) {
				int lastIndex = size--;
				T item = (T) items[lastIndex];
				items[lastIndex] = null;
				index--;
				return item;
			}
			throw new EmptyStackException();
		}

		public T peek() {
			if (!empty()) {
				return (T) items[size--];
			}
			throw new EmptyStackException();
		}

		public boolean empty() {
			return size < 0;
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder(51,13)
					.append(items)
					.toHashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof BLArrayListRefactor) || this.getClass() != obj.getClass())
				return false;
			BLStack<T> originalT = (BLStack<T>) obj;
			if (this.size() != originalT.size())
				return false;
			for (int i = 0; i < size(); i++) {
				if (!this.items[i].equals(originalT.items[i]))
					return false;
			}
			return true;
		}

		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer("[");
			if (isEmpty())
				return null;
			for (int i = 0; i < size(); i++) {
				buffer.append(items[i]).append(",");
			}
			if (buffer.substring(1).length() <= 0)
				return "[]";
			return buffer.insert(buffer.length() - 1, "]").substring(0, buffer.length() - 1).toString();
		}

		@Override
		public T[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}
	}

