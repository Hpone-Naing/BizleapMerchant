package com.bizleap.merchant.dao;

import java.util.List;
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.utils.ServiceUnavailableException;

public interface PurchaseOrderDao extends AbstractDao<PurchaseOrder, String>{

	public void save(PurchaseOrder purchaseOrder) throws ServiceUnavailableException;
	public List<PurchaseOrder> getAll(String string);
	public List<PurchaseOrder> findByString(String query, String boId);

}
