package com.bizleap.merchant.dao;

import java.util.Date;
import java.util.List;
import com.bizleap.utils.ServiceUnavailableException;

public interface AbstractDao<E,I> {
	
	public void saveOrUpdate(E e) throws ServiceUnavailableException;
	public void delete(E e) throws ServiceUnavailableException;
	public long getCount(String queryString);
	public List<E> findByDate(String queryString, Date date);
	public List<E> findByString(String queryString, String value);
	public List<E> findByDateRange(String queryString, Date startDate, Date endDate);

}
