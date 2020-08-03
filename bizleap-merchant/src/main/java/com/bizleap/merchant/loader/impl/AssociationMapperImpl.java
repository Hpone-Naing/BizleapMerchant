package com.bizleap.merchant.loader.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.merchant.loader.AssociationMapper;

@Service
public class AssociationMapperImpl implements AssociationMapper {

	private DataManagerImpl dataManager;

	private void addProductToPurchaseOrder(PurchaseOrder purchaseOrder) {
		List<Product> productList = dataManager.getProductList();
		for (Product product : productList) {
			// System.out.println("is same product: " +
			// product.isSameBoId(purchaseOrder.getProduct()));
			if (product.sameBoId(purchaseOrder.getProduct())) {
				System.out.println("here is same boid.....");
				purchaseOrder.setProduct(product);
				System.out.println("after map: " + purchaseOrder.getProduct());
			}
		}
	}

	private void setUpPurchaseOrderAssociation() {
		for (PurchaseOrder purchaseOrder : dataManager.getPurchasedOrderList()) {
			addProductToPurchaseOrder(purchaseOrder);
		}
	}

	@Override
	public void buildAssociations(DataManagerImpl dataManager) {
		if (dataManager == null)
			dataManager = new DataManagerImpl();
		this.dataManager = dataManager;
		setUpPurchaseOrderAssociation();
	}
}
