package com.bizleap.merchant.dao;

import java.util.List;

import com.bizleap.merchant.entities.Product;
import com.bizleap.utils.ServiceUnavailableException;

public interface ProductDao extends AbstractDao<Product, String>{
	
	public List<Product> getAll(String string);
	public void save(Product product) throws ServiceUnavailableException;

}
