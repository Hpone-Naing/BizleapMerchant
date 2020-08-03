package com.bizleap.merchant.dao.impl;

import org.springframework.stereotype.Repository;
import com.bizleap.merchant.dao.PurchaseOrderDao;
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.utils.ServiceUnavailableException;

@Repository
public class PurchaseOrderDaoImpl extends AbstractDaoImpl<PurchaseOrder, String> implements PurchaseOrderDao {

	protected PurchaseOrderDaoImpl() {
		super(PurchaseOrder.class);
	}
	
	@Override
	public void save(PurchaseOrder purchaseOrder) throws ServiceUnavailableException {
		saveOrUpdate(purchaseOrder);
	}
}
