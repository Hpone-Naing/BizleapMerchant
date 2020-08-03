package com.bizleap.merchant.services.strategy;

import java.time.LocalDate;

import com.bizleap.merchant.entities.Flower;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.enums.CustomerType;

public class FlowerPricingManager extends AbstractPricingManager{
	
	LocalDate purchasingDate;

	public FlowerPricingManager(CustomerType customerType,LocalDate purchasingDate) {	
		super(customerType);
		this.purchasingDate = purchasingDate;
	}
		
	public LocalDate getPurchasingDate() {
		return purchasingDate;
	}

	public void setPurchasingDate(LocalDate purchasingDate) {
		this.purchasingDate = purchasingDate;
	}

	@Override	
	public double calculatePrice(Product product) {
		double price=product.getBasePrice()*product.getWeight();
		int days =purchasingDate.getDayOfMonth()-((Flower)product).getInspectionDate().getDayOfMonth();			
		switch(((Flower)product).getFlowerType()) {
			case LONGER:
				for (int i = 1; i <=days; i++) {
					price=price- (price * 0.1);
				}	
				product.setPrice(price);
			break;
			case MEDIUM:
				for (int i = 1; i <=days; i++) {
				price=price- (price* 0.07);
				}
				product.setPrice(price);
			break;
			default:
				for (int i = 1; i <=days; i++) {
				price=price- (price * 0.02);
				}	
				product.setPrice(price);
			break;
		}
		return price;
	}
	
	@Override
	public double doPricing(Product product) {
		return super.doPricing(product);
	}	
}
