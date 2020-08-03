package com.bizleap.merchant.loader.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.merchant.loader.AssociationMapper;
import com.bizleap.merchant.loader.DataLoader;
import com.bizleap.merchant.loader.DataManager;
import com.bizleap.merchant.saver.ProductSaver;
import com.bizleap.merchant.saver.PurchaseOrderSaver;

@Service
public class DataManagerImpl implements DataManager {
	
	@Autowired
	private DataLoader datatLoader;

	@Autowired
	private AssociationMapper associationMapper;
	
	@Autowired
	private ProductSaver productSaver;
	
	@Autowired
	private PurchaseOrderSaver purchasedOrderSaver;
	
	private List<Product> productList;
	private List<PurchaseOrder> purchasedOrderList;
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<PurchaseOrder> getPurchasedOrderList() {
		return purchasedOrderList;
	}

	public void setPurchasedOrderList(List<PurchaseOrder> purchasedOrderList) {
		this.purchasedOrderList = purchasedOrderList;
	}

	@Override
	public void loadData() throws Exception {
		productList = datatLoader.loadProduct();
		purchasedOrderList = datatLoader.loadPurchaseOrder();
	}

	public void buildAssociations() throws Exception {
		associationMapper.buildAssociations(this);
	}

	public void saveDataJdbc() throws Exception {
		productSaver.setProductList(getProductList());
		productSaver.save();
		purchasedOrderSaver.setPurchaseOrderList(getPurchasedOrderList());
		purchasedOrderSaver.savePurchaseOrder();
	}
	
	@Override
	public void saveData() throws Exception {		
		productSaver.setProductList(getProductList());
		productSaver.save();
		purchasedOrderSaver.setPurchaseOrderList(getPurchasedOrderList());
		purchasedOrderSaver.savePurchaseOrder();
	}

	public void start() throws Exception {
		try {
			loadData();
			buildAssociations();
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
