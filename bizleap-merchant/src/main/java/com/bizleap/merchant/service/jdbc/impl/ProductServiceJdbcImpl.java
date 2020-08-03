package com.bizleap.merchant.service.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.service.jdbc.AbstractServiceJdbc;
import com.bizleap.merchant.service.jdbc.ProductServiceJdbc;

public class ProductServiceJdbcImpl implements ProductServiceJdbc {
	private AbstractServiceJdbc abstractService = new AbstractServiceJdbcImpl();

	public Connection getConnection() {
		if (abstractService.getConnection() != null)
			return abstractService.getConnection();
		return null;
	}

	@Override
	public void save(Product product) throws SQLException {
		PreparedStatement prepare = getConnection().prepareStatement("insert into product(id,boId,name,basePrice,weight,productType) values (?, ?, ?, ?, ?, ?)");
		prepare.setLong(1, product.getId());
		prepare.setString(2, product.getBoId().trim());
		prepare.setString(3, product.getName().trim());
		prepare.setDouble(4, product.getBasePrice());
		prepare.setDouble(5, product.getWeight());
		prepare.setString(6, String.valueOf(product.getProductType()));
		prepare.executeUpdate();
		prepare.close();
		getConnection().close();
	}

	@Override
	public List<Product> getAll() throws SQLException {
		List<Product> productList = new ArrayList<Product>();
		PreparedStatement prepare = getConnection().prepareStatement("select * from product");
		ResultSet resultSet = prepare.executeQuery();
		if (resultSet == null)
			return null;
		while (resultSet.next()) {
			Product product = new Product();
			product.setId(resultSet.getLong("id"));
			product.setBoId(resultSet.getString("boId").trim());
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getDouble("basePrice"));
			product.setWeight(resultSet.getDouble("weight"));
			product.setProductType(ProductType.valueOf(resultSet.getString("productType")));
			productList.add(product);
		}
		prepare.close();
		resultSet.close();
		getConnection().close();
		return productList;
	}

	@Override
	public Product findByBoId(String boId) throws SQLException {
		Product product = new Product();
		PreparedStatement prepare = getConnection().prepareStatement("select * from product where boId = ?");
		prepare.setString(1, boId);
		ResultSet resultSet = prepare.executeQuery();
		if (resultSet.next()) {
			product.setId(resultSet.getInt("id"));
			product.setBoId(resultSet.getString("boId"));
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getDouble("basePrice"));
			product.setWeight(resultSet.getDouble("weight"));
			product.setProductType(ProductType.valueOf(resultSet.getString("productType")));
		}
		prepare.close();
		resultSet.close();
		getConnection().close();
		return product;
	}

	@Override
	public boolean delete(String boId) throws SQLException {
		System.out.println("boId: " + boId);
		PreparedStatement prepare = getConnection().prepareStatement("delete from product where boId=?");
		prepare.setString(1, boId.trim());
		int result = prepare.executeUpdate();
		prepare.close();
		getConnection().close();
		return result > 0 ? true : false;
	}
}
