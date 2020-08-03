package com.bizleap.merchant.factory.impl;

import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.factory.ProductFactory;
import com.bizleap.merchant.services.strategy.PricingManager;

public abstract class AbstractProductFactory implements ProductFactory {

	ProductType productType;
	PricingManager pricingManager;
	
	public AbstractProductFactory(ProductType productType) {
		this.productType=productType;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	public void setPricingManager(PricingManager pricingManager) {
		this.pricingManager = pricingManager;
	}

	@Override
	public Product create() {
		return null;
	}
	
	public abstract PricingManager getPricingManager();
	
}
