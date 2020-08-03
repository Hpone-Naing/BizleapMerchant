package com.bizleap.merchant.service.hibernate;

import java.util.List;
import com.bizleap.merchant.entities.Product;
import com.bizleap.utils.ServiceUnavailableException;

public interface ProductService {

	public void saveProduct(Product product) throws Exception;
	public List<Product> getAll() throws ServiceUnavailableException;
	public Product findByBoId(String boId) throws ServiceUnavailableException;
}
