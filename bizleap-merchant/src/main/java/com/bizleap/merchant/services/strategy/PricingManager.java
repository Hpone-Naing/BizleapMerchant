package com.bizleap.merchant.services.strategy;

import com.bizleap.merchant.entities.Product;

public interface PricingManager {

	double doPricing(Product product);
	double calculatePrice(Product product);
}
