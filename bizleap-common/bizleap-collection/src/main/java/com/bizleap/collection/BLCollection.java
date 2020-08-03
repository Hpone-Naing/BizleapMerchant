package com.bizleap.collection;

public interface BLCollection<T> extends Iterable<T> {
	
	public boolean add(T t);

	public boolean remove(T t);

	public boolean isEmpty();

	public boolean contains(T t);

	public int size();

	public void clear();
	
	public boolean equals(Object o);
	
	public int hashCode();

	public T[] toArray();

	
}
