package com.bizleap.merchant.factory.impl;

import com.bizleap.merchant.entities.Fruit;
import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.FruitType;
import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.enums.Temperature;
import com.bizleap.merchant.services.strategy.FruitPricingManager;
import com.bizleap.merchant.services.strategy.PricingManager;

public class FruitFactory extends AbstractProductFactory{

	FruitType fruitType;
	CustomerType customerType;
	Temperature temperature;

	public FruitFactory() {
		super(ProductType.FRUIT);
	}
	
	public FruitFactory(FruitType fruitType) {
		super(ProductType.FRUIT);
		this.fruitType=fruitType;
	}

	private double getBasePrice(String name) {
		return 1;
	}
	/*
	 * To be used with fruitType constructor
	 * /
	public Fruit create(String id,String name,double weight) {
		Fruit fruit=(Fruit) new Fruit(fruitType).boId(id).name(name).weight(weight).basePrice(getBasePrice(name));
		fruit.setPricingManager(this.getPricingManager());
		return fruit;
	}
	
	/*
	 * To be used with empty constructor
	 */
	public Fruit create(String id,String name,double weight,FruitType fruitType) {
		Fruit fruit=(Fruit) new Fruit(fruitType).boId(id).name(name).weight(weight).basePrice(getBasePrice(name));
		//fruit.setPricingManager(this.getPricingManager());
		return fruit;
	} 
	
	@Override
	public PricingManager getPricingManager() {
		if(pricingManager==null)
			pricingManager=new FruitPricingManager(customerType,temperature);
		return pricingManager;
	}
}
