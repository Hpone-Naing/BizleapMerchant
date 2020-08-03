package com.bizleap.merchant.services.strategy;

import com.bizleap.merchant.entities.Fruit;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.Temperature;

public class FruitPricingManager extends AbstractPricingManager{

	Temperature temperatureCategory;
	
	public FruitPricingManager(CustomerType customerType,Temperature temperatureCategory ) {
		super(customerType);
		this.temperatureCategory=temperatureCategory;
	}

	public Temperature getTemperatureCategory() {
		return temperatureCategory;
	}


	public void setTemperatureCategory(Temperature temperatureCategory) {
		this.temperatureCategory = temperatureCategory;
	}

	@Override
	public double calculatePrice(Product product) {
		
		double price=product.getBasePrice()*product.getWeight();
		//MediumHydrating fruit price is not infected by temperature changes
		if(!((Fruit)product).isMediumHydrating()) {
			switch(temperatureCategory) {
				case HIGH:
					price += price * (((Fruit)product).isMostHydrating()? 0.15 : -0.15);
					break;
				case LOW :
					price += price * (((Fruit)product).isLeastHydrating()? 0.15 : -0.15);
				default  :
			}
		}
		product.setPrice(price);
		return price;			
	}
	
	@Override
	public double doPricing(Product product) {
		return super.doPricing(product);
	}	
}
