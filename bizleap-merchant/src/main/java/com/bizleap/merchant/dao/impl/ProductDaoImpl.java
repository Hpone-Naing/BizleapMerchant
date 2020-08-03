package com.bizleap.merchant.dao.impl;

import org.springframework.stereotype.Repository;
import com.bizleap.merchant.dao.ProductDao;
import com.bizleap.merchant.entities.Product;
import com.bizleap.utils.ServiceUnavailableException;

@Repository
public class ProductDaoImpl extends AbstractDaoImpl<Product, String> implements ProductDao {

	protected ProductDaoImpl() {
		super(Product.class);
	}
	
	@Override
	public void save(Product product) throws ServiceUnavailableException {
		saveOrUpdate(product); 
	}
}
