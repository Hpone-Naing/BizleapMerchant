package com.bizleap.merchant.loader;

import java.util.List;

import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.merchant.entities.PurchaseRecord;

public interface DataLoader {
	
	public List<PurchaseRecord> loadPurchaseRecord() throws Exception;
	public int getIndex();
	public void setIndex(int index);
	public List<PurchaseOrder> loadPurchaseOrder() throws Exception;
	public List<Product> loadProduct() throws Exception;
}