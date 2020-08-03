package com.bizleap.merchant.services.impl.test;

import org.junit.Test;

import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.enums.CandyBarType;
import com.bizleap.merchant.enums.FlowerType;
import com.bizleap.merchant.enums.FruitType;
import com.bizleap.merchant.factory.impl.CandyBarFactory;
import com.bizleap.merchant.factory.impl.FlowerFactory;
import com.bizleap.merchant.factory.impl.FruitFactory;

public class PricingManagerTest {

	@Test
	public void fruitPricingManagerTest() {
		Product product=new FruitFactory().create("FRU001","Watermelon",8,FruitType.MOSTHYDRATING);
		//product.setPricingManager(new FruitPricingManager(CustomerType.REGULAR,Temperature.HIGH));
		product.calculatePrice();
		System.out.println(product);
				
	}
	
	@Test
	public void flowerPricingManagerTest() {
		Product product=new FlowerFactory().create("FLO001","Rose",2,10,7,FlowerType.LONGER);
		//product.setPricingManager(new FlowerPricingManager(CustomerType.REGULAR,LocalDate.now().plusDays(3)));
		product.calculatePrice();
		System.out.println(product);
	}
	
	@Test
	public void candyBarPricingManagerTest() {
		Product product=new CandyBarFactory().create("CAN001","Hershey",2,CandyBarType.BESTSELLING);
		//product.setPricingManager(new CandyBarPricingManager(CustomerType.REGULAR,Season.RAINY));
		product.calculatePrice();
		System.out.println(product);
	}
}
