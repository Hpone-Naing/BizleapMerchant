package com.bizleap.collection;

public interface BLList<T> extends BLCollection<T> {
	
	public T get(int index);

	public int indexOf(T t);

}
