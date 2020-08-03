package com.bizleap.merchant.service.jdbc;

import java.sql.SQLException;
import java.util.List;
import com.bizleap.merchant.entities.PurchaseOrder;

public interface PurchaseOrderServiceJdbc {

	public void save(PurchaseOrder purchaseOrder) throws SQLException;
	public List<PurchaseOrder> getAll() throws SQLException;
	public PurchaseOrder findByBoId(String boId) throws SQLException;
	public boolean delete(String boId) throws SQLException;
}
