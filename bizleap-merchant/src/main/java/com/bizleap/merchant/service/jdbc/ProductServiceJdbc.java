package com.bizleap.merchant.service.jdbc;

import java.sql.SQLException;
import java.util.List;
import com.bizleap.merchant.entities.Product;

public interface ProductServiceJdbc {

	public void save(Product product) throws SQLException;
	public List<Product> getAll() throws SQLException;
	public Product findByBoId(String boId) throws SQLException;	
	public boolean delete(String boId) throws SQLException;
}
