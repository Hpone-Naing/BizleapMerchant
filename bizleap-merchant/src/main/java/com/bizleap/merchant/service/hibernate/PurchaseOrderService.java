package com.bizleap.merchant.service.hibernate;

import java.util.List;

import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.utils.ServiceUnavailableException;

public interface PurchaseOrderService {

	public long getCount();
	public void savePurchaseOrder(PurchaseOrder purchaseOrder) throws Exception;
	public List<PurchaseOrder> getAll() throws ServiceUnavailableException;
	public PurchaseOrder findByBoId(String boId) throws ServiceUnavailableException;	
}

