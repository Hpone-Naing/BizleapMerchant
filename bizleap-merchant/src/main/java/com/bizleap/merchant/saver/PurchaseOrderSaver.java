package com.bizleap.merchant.saver;

import java.util.List;

import com.bizleap.merchant.entities.PurchaseOrder;

public interface PurchaseOrderSaver {
	
	public void savePurchaseOrder() throws Exception;
	public void setPurchaseOrderList(List<PurchaseOrder> purchaseOrderList);
}
