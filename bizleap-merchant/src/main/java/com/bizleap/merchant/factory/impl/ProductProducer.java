package com.bizleap.merchant.factory.impl;

import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.factory.ProductFactory;

public class ProductProducer {
	
	public static ProductFactory getFactory(ProductType productType) {
		
		switch(productType) {
			case FRUIT:
				return new FruitFactory();
			case FLOWER:
				return new FlowerFactory();
			default:
				return new CandyBarFactory();
		}
	}
}
