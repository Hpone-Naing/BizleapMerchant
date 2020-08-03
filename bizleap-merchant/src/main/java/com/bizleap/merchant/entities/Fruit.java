package com.bizleap.merchant.entities;

import java.util.Map;

import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.FruitType;
import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.enums.Temperature;
import com.bizleap.merchant.services.strategy.FruitPricingManager;
import com.bizleap.merchant.services.strategy.PricingManager;

public class Fruit extends Product implements Cloneable{

	private FruitType fruitType;
	public static PricingManager pricingManager;

	public Fruit() {
		
	}
	
	public Fruit(FruitType fruitType) {
		super(ProductType.FRUIT);
		this.fruitType = fruitType;
	}

	/*
	 * public Fruit(String name,double price, double weight, ProductType
	 * productType,FruitType fruitType) { super(name,price, weight, productType);
	 * this.fruitType=fruitType; }
	 */

	public FruitType getFruitType() {
		return fruitType;
	}

	public void setFruitType(FruitType fruitType) {
		this.fruitType = fruitType;
	}

	public boolean isMostHydrating() {
		return this.fruitType == FruitType.MOSTHYDRATING;
	}

	public boolean isMediumHydrating() {
		return this.fruitType == FruitType.MEDIUMHYDRATING;
	}

	public boolean isLeastHydrating() {
		return this.fruitType == FruitType.LEASTHYDRATING;
	}
/*
	public void configurePricingManager(CustomerType customerType, Temperature temperature) {
		((FruitPricingManager) this.getPricingManager()).setTemperatureCategory(temperature);
		((FruitPricingManager) this.getPricingManager()).setCustomerType(customerType);
	}
*/
	@Override
	public void configurePricingManager(Map<String, String> paramMap) {
		//FruitPricingManager fruitPricingManager = (FruitPricingManager) this.getPricingManager();
		FruitPricingManager fruitPricingManager = (FruitPricingManager)pricingManager;
		fruitPricingManager.setCustomerType(CustomerType.valueOf(paramMap.get("customerType")));
		fruitPricingManager.setTemperatureCategory(Temperature.valueOf(paramMap.get("temperature")));
	}

	@Override
	public Fruit clone() {
		Fruit fruit = new Fruit();
		super.clone(fruit);
		fruit.setFruitType(getFruitType());
		return fruit;
	}

	@Override
	public String toString() {
		return new StringBuffer() 
				  .append( super.toString())
				  .append(" FruitType:" + fruitType)
				  .toString();
	}
}
