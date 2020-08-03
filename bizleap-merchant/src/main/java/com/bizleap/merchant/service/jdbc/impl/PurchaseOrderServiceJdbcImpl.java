package com.bizleap.merchant.service.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.merchant.service.jdbc.AbstractServiceJdbc;
import com.bizleap.merchant.service.jdbc.ProductServiceJdbc;
import com.bizleap.merchant.service.jdbc.PurchaseOrderServiceJdbc;

public class PurchaseOrderServiceJdbcImpl implements PurchaseOrderServiceJdbc{

	private AbstractServiceJdbc abstractService = new AbstractServiceJdbcImpl();
	private ProductServiceJdbc productServiceJdbc = new ProductServiceJdbcImpl();

	public Connection getConnection() {
		if (abstractService.getConnection() != null)
			return abstractService.getConnection();
		return null;
	}
	
	public Long getId(String boId) throws SQLException {
		if(productServiceJdbc.getAll() != null) {
			for(Product product : productServiceJdbc.getAll()) {
				if(product.getBoId().trim().equals(boId.trim()))
					return product.getId();
			}
		}
		return null;	
	}
	
	@Override
	public void save(PurchaseOrder purchaseOrder) throws SQLException {
		PreparedStatement prepare = getConnection().prepareStatement("insert into purchaseorder(id,boId,purchaseDate,price,quantity,amount,product_Id) values (?, ?, ?, ?, ?, ?, ?)");
		prepare.setLong(1, purchaseOrder.getId());
		prepare.setString(2, purchaseOrder.getBoId().trim());
		prepare.setDate(3, (Date)(purchaseOrder.getPurchaseDate()));
		prepare.setDouble(4, purchaseOrder.getPrice());
		prepare.setDouble(5, purchaseOrder.getAmount());
		prepare.setInt(6, purchaseOrder.getQuantity());
		prepare.setLong(7, getId(purchaseOrder.getProduct().getBoId()));
		prepare.executeUpdate();
		prepare.close();
		getConnection().close();
	}
	
	@Override
	public List<PurchaseOrder> getAll() throws SQLException {
		List<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
		PreparedStatement prepare = getConnection().prepareStatement("select * from purchaseOrder");
		ResultSet resultSet = prepare.executeQuery();
		if (resultSet == null)
			return null;
		while (resultSet.next()) {
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setId(resultSet.getLong("id"));
			purchaseOrder.setBoId(resultSet.getString("boId"));
			purchaseOrder.setPurchaseDate(resultSet.getDate(("purchaseDate")));
			purchaseOrder.setPrice(resultSet.getDouble("price"));
			purchaseOrder.setQuantity(resultSet.getInt("quantity"));
			purchaseOrder.setAmount(resultSet.getDouble("amount"));
			purchaseOrder.setId(resultSet.getLong("product_Id"));
			purchaseOrderList.add(purchaseOrder);
		}
		prepare.close();
		resultSet.close();
		getConnection().close();
		return purchaseOrderList;
	}

	@Override
	public PurchaseOrder findByBoId(String boId) throws SQLException {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		PreparedStatement prepare = getConnection().prepareStatement("select * from purchaseOrder where boId = ?");
		prepare.setString(1, boId);
		ResultSet resultSet = prepare.executeQuery();
		if (resultSet.next()) {
			purchaseOrder.setId(resultSet.getLong("id"));
			purchaseOrder.setBoId(resultSet.getString("boId"));
			purchaseOrder.setPurchaseDate(resultSet.getDate(("purchaseDate")));
			purchaseOrder.setPrice(resultSet.getDouble("price"));
			purchaseOrder.setQuantity(resultSet.getInt("quantity"));
			purchaseOrder.setAmount(resultSet.getDouble("amount"));
			purchaseOrder.setId(resultSet.getLong("product_Id"));
		}
		prepare.close();
		resultSet.close();
		getConnection().close();
		return purchaseOrder;
	}

	@Override
	public boolean delete(String boId) throws SQLException {
		System.out.println("boId: " + boId);
		PreparedStatement prepare = getConnection().prepareStatement("delete from purchaseOrder where boId=?");
		prepare.setString(1, boId.trim());
		int result = prepare.executeUpdate();
		prepare.close();
		getConnection().close();
		return result > 0 ? true : false;
	}
}
