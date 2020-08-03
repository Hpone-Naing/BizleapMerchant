package com.bizleap.merchant.factory.impl;

import java.time.LocalDate;

import com.bizleap.merchant.entities.Flower;
import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.FlowerType;
import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.services.strategy.FlowerPricingManager;
import com.bizleap.merchant.services.strategy.PricingManager;

public class FlowerFactory extends AbstractProductFactory {

	FlowerType flowerType;
	CustomerType customerType;
	LocalDate purchasingDate;
	 
		public FlowerFactory() {
			super(ProductType.FLOWER);
		}
		
		public FlowerFactory(FlowerType flowerType) {
			super(ProductType.FLOWER);
			this.flowerType=flowerType;
 		}
		
		public FlowerType getFlowerType() {
			return flowerType;
		}

		public void setFlowerType(FlowerType flowerType) {
			this.flowerType = flowerType;
		}

		private LocalDate getInspectionDate(String name) {
			return LocalDate.now();
		}
		/*
		 * To be used with parameter constructor
		 *
		/
		public Flower create(String id,String name,double weight,double basePrice,int shelfLifeInDays) {
			Flower flower=(Flower) new Flower(flowerType, shelfLifeInDays,getInspectionDate(name)).boId(id).name(name).weight(weight).basePrice(basePrice);
			flower.setPricingManager(this.getPricingManager());
			return flower;
		}
		
		/*
		 * To be used with empty constructor
		 */
		public Flower create(String id,String name,double weight,double basePrice,int shelfLifeInDays,FlowerType flowerType) {
			Flower flower=(Flower) new Flower(flowerType, shelfLifeInDays,getInspectionDate(name)).boId(id).name(name).weight(weight).basePrice(basePrice);
			//flower.setPricingManager(this.getPricingManager());
			return flower;
		}

		@Override
		public PricingManager getPricingManager() {
			if(pricingManager==null)
				pricingManager=new FlowerPricingManager(customerType,purchasingDate);
			return pricingManager;
		}

}
