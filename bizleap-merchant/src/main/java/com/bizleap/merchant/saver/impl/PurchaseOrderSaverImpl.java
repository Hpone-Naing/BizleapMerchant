package com.bizleap.merchant.saver.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.merchant.saver.PurchaseOrderSaver;
import com.bizleap.merchant.service.hibernate.ProductService;
import com.bizleap.merchant.service.hibernate.PurchaseOrderService;
import com.bizleap.merchant.service.jdbc.PurchaseOrderServiceJdbc;
import com.bizleap.merchant.service.jdbc.impl.PurchaseOrderServiceJdbcImpl;

@Service
public class PurchaseOrderSaverImpl implements PurchaseOrderSaver{

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@Autowired
	private ProductService productService;
	
	private List<PurchaseOrder> purchaseOrderList;
	private PurchaseOrderServiceJdbc purchaseOrderServiceJdbc;
	private Map<String,Product> productMapDB;

	public PurchaseOrderSaverImpl() {
		if (purchaseOrderServiceJdbc == null)
			purchaseOrderServiceJdbc = new PurchaseOrderServiceJdbcImpl();
	}

	public List<PurchaseOrder> getPurchaseOrderList() {
		if (purchaseOrderList == null)
			purchaseOrderList = new ArrayList<PurchaseOrder>();
		return purchaseOrderList;
	}

	public void setPurchaseOrderList(List<PurchaseOrder> purchaseOrderList) {
		this.purchaseOrderList = purchaseOrderList;
	}

	private Product getProductFromBD(Product product) throws Exception {
		if(productMapDB == null) 
			productMapDB = new HashMap<>();
		Product  productFromDB = productMapDB.get(product.getBoId());
		if(productFromDB == null) {
			productFromDB = productService.findByBoId(product.getBoId());
			if(productFromDB != null)
			productMapDB.put(productFromDB.getBoId(), productFromDB);
		}
		return productFromDB != null ? productFromDB : product;
	}
	@Override
	public void savePurchaseOrder() throws Exception {
		System.out.println("in saver: " + purchaseOrderList.size());
		if (purchaseOrderList != null) {
			for (PurchaseOrder purchaseOrder : purchaseOrderList) {
				purchaseOrder.setProduct(getProductFromBD(purchaseOrder.getProduct()));
//				purchaseOrderServiceJdbc.save(purchaseOrder);
				purchaseOrderService.savePurchaseOrder(purchaseOrder);
			}
		}
	}
}
