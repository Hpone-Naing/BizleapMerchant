package com.bizleap.collection.impl;

import java.util.Arrays;
import java.util.Iterator;

public class BLQueue<T> implements Iterable<T> {

		int front = 0, rear = -1;
		int maximumSize = 10;
		T[] items;

		public BLQueue() {
			items = (T[]) new Object[maximumSize];
		}

		public BLQueue(T[] items) {
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
				return items[counter++];
			}
		}

		public boolean hasMoreRoom()
		{
			return rear >= items.length - 1;
		}
		
		public boolean shouldResize()
		{
			return (int) (items.length * 0.2) < front;
		}
		
		public void add(T value) {
			if (hasMoreRoom()) {
				if (shouldResize()) {
					reArrange();
				} else
					resize();
			}
			items[++rear] = value;
			// System.out.println("rear count: " + rear + ", value: " + value);
		}

		public T poll() {
			if (!isEmpty())
				return items[front++];
			return null;
		}

		public T element() {
			return items[0];
		}

		public T remove() {
			if (isEmpty())
				return null;
			T item = items[0];
			for (int i = 1; i < size(); i++) {
				items[i - 1] = items[i];
				items[i] = null;

			}
			return item;
		}

		public int size() {
			int count = 0;
			for (T item : items) {
				if (item != null)
					count++;
			}
			return count;
		}

		public void resize() {
			items = Arrays.copyOf(items, items.length * 2);
		}

		public boolean isFull() {
			return rear - front >= items.length - 1;
		}

		public boolean isEmpty() {
			return front > rear;
		}

		public void reArrange() {
			int index = 0;
			for (int i = front + 1; i < rear; i++) {
				items[index++] = items[i];
				items[i] = null;
			}
			rear = items.length - (front + 1);
			front = 0;
			// System.out.println("Front" + front);
		}

		@Override
		public Iterator<T> iterator() {
			return new BLIterator();
		}

		/*@Override
		public String toString() {
			 StringBuffer buffer = new StringBuffer();
			  Stream.of(items).forEach(obj -> { if (obj != null) { buffer.append("," +
			  obj.toString()); } });
			  
			  return String.format("[%s]", buffer.length() > 0 ? buffer.substring(1) : "");
			  }
		}*/
		
}	


