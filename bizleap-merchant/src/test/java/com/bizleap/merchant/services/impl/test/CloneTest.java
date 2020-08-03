package com.bizleap.merchant.services.impl.test;

import org.junit.Test;

import com.bizleap.merchant.entities.CandyBar;
import com.bizleap.merchant.entities.Flower;
import com.bizleap.merchant.entities.Fruit;
import com.bizleap.merchant.enums.CandyBarType;
import com.bizleap.merchant.enums.FlowerType;
import com.bizleap.merchant.enums.FruitType;
import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.factory.impl.CandyBarFactory;
import com.bizleap.merchant.factory.impl.FlowerFactory;
import com.bizleap.merchant.factory.impl.FruitFactory;
import com.bizleap.merchant.factory.impl.ProductProducer;

public class CloneTest {
	
	@Test
	public void fruitCloneTest() {
		System.out.println("Cloning Fruit");
		System.out.println("-------------------------");
		FruitFactory fruitFactory = (FruitFactory) ProductProducer.getFactory(ProductType.FRUIT);
		Fruit fruit=fruitFactory.create("FRU001", "Watermelon", 8, FruitType.MOSTHYDRATING);
		Fruit clonedFruit=fruit.clone();
		System.out.println(clonedFruit);
	}
	
	@Test
	public void flowerCloneTest() {
		System.out.println("Cloning Flower");
		System.out.println("-------------------------");
		FlowerFactory flowerFactory = (FlowerFactory) ProductProducer.getFactory(ProductType.FLOWER);
		Flower flower=flowerFactory.create("FLO001", "Rose", 2, 10, 7, FlowerType.LONGER);
		Flower clonedFlower=flower.clone();
		System.out.println(clonedFlower);
	}
	
	@Test
	public void candyBarCloneTest() {
		System.out.println("Cloning CandyBar");
		System.out.println("-------------------------");
		CandyBarFactory candyBarFactory = (CandyBarFactory) ProductProducer.getFactory(ProductType.CANDYBAR);
		CandyBar candyBar=candyBarFactory.create("CAN001", "Snicker", 1, CandyBarType.BESTSELLING);
		CandyBar clonedCandyBar=candyBar.clone();
		System.out.println(clonedCandyBar);
	}

}
