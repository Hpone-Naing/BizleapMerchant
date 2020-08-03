package com.bizleap.merchant.services.strategy;

import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.enums.CustomerType;

public class AbstractPricingManager implements PricingManager{

	CustomerType customerType;
	
	public AbstractPricingManager(CustomerType customerType) {
		this.customerType=customerType;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	@Override
	public double calculatePrice(Product product) {
		return 0;
	}

	@Override
	public double doPricing(Product product) {
		switch(customerType) {
		case VALUE:
			product.setPrice(calculatePrice(product)-(calculatePrice(product))*0.1);
			break;
		case VOLUME:
			product.setPrice(calculatePrice(product)-(calculatePrice(product))*0.15);
			break;
		default:
			product.setPrice(calculatePrice(product));
			break;
		}
		return product.getPrice();	
	}
}
