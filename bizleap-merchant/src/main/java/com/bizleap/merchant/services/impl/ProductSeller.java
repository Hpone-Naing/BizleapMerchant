package com.bizleap.merchant.services.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bizleap.merchant.entities.CandyBar;
import com.bizleap.merchant.entities.Flower;
import com.bizleap.merchant.entities.Fruit;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.entities.PurchaseRecord;
import com.bizleap.merchant.enums.CandyBarType;
import com.bizleap.merchant.enums.CustomerType;
import com.bizleap.merchant.enums.FlowerType;
import com.bizleap.merchant.enums.FruitType;
import com.bizleap.merchant.enums.ProductType;
import com.bizleap.merchant.enums.Season;
import com.bizleap.merchant.enums.Temperature;
import com.bizleap.merchant.factory.impl.CandyBarFactory;
import com.bizleap.merchant.factory.impl.FlowerFactory;
import com.bizleap.merchant.factory.impl.FruitFactory;
import com.bizleap.merchant.factory.impl.ProductProducer;
import com.bizleap.merchant.loader.DataLoader;
import com.bizleap.merchant.loader.impl.DataLoaderImpl;

public class ProductSeller {

	List<Product> productList = null;
	double flowerInitialOrder = 22500;
	double fruitInitialOrder = 800000;
	double candyBarInitialOrder = 66000;
	private DataLoader dataLoader;

	public ProductSeller() {

	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public void initializeProduct() {
		FruitFactory fruitFactory = new FruitFactory();
		FlowerFactory flowerFactory = new FlowerFactory();
		CandyBarFactory candyBarFactory = new CandyBarFactory();

		productList = Arrays.asList((Product)
				fruitFactory.create("FRU001", "Watermelon", 8, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU002", "PineApple", 9, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU003", "BlueBerry", 7, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU004", "Grape", 5, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU005", "Cherry", 5, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU006", "HoneyDrew", 4, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU007", "Mango", 4, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU008", "Orange", 3, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU009", "Peach", 4, FruitType.MEDIUMHYDRATING),
				fruitFactory.create("FRU0010", "Pair Apple", 4, FruitType.MEDIUMHYDRATING),
				fruitFactory.create("FRU0011", "Guava", 3, FruitType.MEDIUMHYDRATING),
				fruitFactory.create("FRU0012", "Dragon Fruit", 4, FruitType.MEDIUMHYDRATING),
				fruitFactory.create("FRU0013", "Banana", 2, FruitType.LEASTHYDRATING),
				fruitFactory.create("FRU0014", "Avocado", 4, FruitType.LEASTHYDRATING),
				fruitFactory.create("FRU0015", "JackFruit", 8, FruitType.LEASTHYDRATING),
				fruitFactory.create("FRU0016", "Bread", 3, FruitType.LEASTHYDRATING),
				fruitFactory.create("FRU0017", "Passion Fruit", 3, FruitType.LEASTHYDRATING),

				flowerFactory.create("FLO001", "Rose", 2, 10, 7, FlowerType.LONGER),
				flowerFactory.create("FLO002", "Lavender", 3, 6, 5, FlowerType.MEDIUM),
				flowerFactory.create("FLO003", "Cape Jasmine", 4, 8, 4, FlowerType.MEDIUM),
				flowerFactory.create("FLO004", "Aster", 3, 5, 3, FlowerType.SHORTER),
				flowerFactory.create("FLO005", "Tulip", 2, 3, 5, FlowerType.MEDIUM),
				flowerFactory.create("FLO006", "Orchid", 3, 9, 7, FlowerType.LONGER),
				flowerFactory.create("FLO007", "Sunflower", 4, 4, 6, FlowerType.LONGER),
				flowerFactory.create("FLO008", "Lily", 3, 5, 5, FlowerType.MEDIUM),
				flowerFactory.create("FLO009", "Dahila", 3, 4, 3, FlowerType.SHORTER),
				flowerFactory.create("FLO0010", "Buttercup", 3, 6, 4, FlowerType.MEDIUM),
				flowerFactory.create("FLO0011", "Camelia", 4, 2, 6, FlowerType.LONGER),
				flowerFactory.create("FLO0012", "Tuberose", 3, 7, 6, FlowerType.LONGER),
				flowerFactory.create("FLO0013", "Peony", 3, 4, 7, FlowerType.LONGER),

				candyBarFactory.create("CAN001", "Hershey", 2, CandyBarType.BESTSELLING),
				candyBarFactory.create("CAN001", "Snicker", 1, CandyBarType.BESTSELLING),
				candyBarFactory.create("CAN001", "Kitkat", 3, CandyBarType.BESTSELLING),
				candyBarFactory.create("CAN001", "ThreeMustkeeters", 2, CandyBarType.WELLESTABLISHED),
				candyBarFactory.create("CAN001", "Reeses", 2, CandyBarType.WELLESTABLISHED),
				candyBarFactory.create("CAN001", "MilkyWay", 3, CandyBarType.BESTSELLING),
				candyBarFactory.create("CAN001", "ButterFinger", 2, CandyBarType.NEWCOMER),
				candyBarFactory.create("CAN001", "Twix", 2, CandyBarType.NEWCOMER)

		);
	}

	public void initializeFruit() {
		FruitFactory fruitFactory = (FruitFactory) ProductProducer.getFactory(ProductType.FRUIT);
		Fruit.pricingManager=fruitFactory.getPricingManager();

		productList = Arrays.asList((Product) fruitFactory.create("FRU001", "Watermelon", 8, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU002", "PineApple", 9, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU003", "BlueBerry", 7, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU004", "Grape", 5, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU005", "Cherry", 5, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU006", "HoneyDrew", 4, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU007", "Mango", 4, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU008", "Orange", 3, FruitType.MOSTHYDRATING),
				fruitFactory.create("FRU009", "Peach", 4, FruitType.MEDIUMHYDRATING),
				fruitFactory.create("FRU0010", "Pair Apple", 4, FruitType.MEDIUMHYDRATING),
				fruitFactory.create("FRU0011", "Guava", 3, FruitType.MEDIUMHYDRATING),
				fruitFactory.create("FRU0012", "Dragon Fruit", 4, FruitType.MEDIUMHYDRATING),
				fruitFactory.create("FRU0013", "Banana", 2, FruitType.LEASTHYDRATING),
				fruitFactory.create("FRU0014", "Avocado", 4, FruitType.LEASTHYDRATING),
				fruitFactory.create("FRU0015", "JackFruit", 8, FruitType.LEASTHYDRATING),
				fruitFactory.create("FRU0016", "Bread", 3, FruitType.LEASTHYDRATING),
				fruitFactory.create("FRU0017", "Passion Fruit", 3, FruitType.LEASTHYDRATING));
	}

	public void initializeFlower() {
		FlowerFactory flowerFactory = (FlowerFactory) ProductProducer.getFactory(ProductType.FLOWER);
		Flower.pricingManager=flowerFactory.getPricingManager();


		productList = Arrays.asList((Product)

		flowerFactory.create("FLO001", "Rose", 2, 10, 7, FlowerType.LONGER),
				flowerFactory.create("FLO002", "Lavender", 3, 6, 5, FlowerType.MEDIUM),
				flowerFactory.create("FLO003", "Cape Jasmine", 4, 8, 4, FlowerType.MEDIUM),
				flowerFactory.create("FLO004", "Aster", 3, 5, 3, FlowerType.SHORTER),
				flowerFactory.create("FLO005", "Tulip", 2, 3, 5, FlowerType.MEDIUM),
				flowerFactory.create("FLO006", "Orchid", 3, 9, 7, FlowerType.LONGER),
				flowerFactory.create("FLO007", "Sunflower", 4, 4, 6, FlowerType.LONGER),
				flowerFactory.create("FLO008", "Lily", 3, 5, 5, FlowerType.MEDIUM),
				flowerFactory.create("FLO009", "Dahila", 3, 4, 3, FlowerType.SHORTER),
				flowerFactory.create("FLO0010", "Buttercup", 3, 6, 4, FlowerType.MEDIUM),
				flowerFactory.create("FLO0011", "Camelia", 4, 2, 6, FlowerType.LONGER),
				flowerFactory.create("FLO0012", "Tuberose", 3, 7, 6, FlowerType.LONGER),
				flowerFactory.create("FLO0013", "Peony", 3, 4, 7, FlowerType.LONGER));
	}

	public void initializeCandyBar() {
		CandyBarFactory candyBarFactory = (CandyBarFactory) ProductProducer.getFactory(ProductType.CANDYBAR);
		CandyBar.pricingManager=candyBarFactory.getPricingManager();

		productList = Arrays.asList((Product)

				candyBarFactory.create("CAN001", "Hershey", 2, CandyBarType.BESTSELLING),
				candyBarFactory.create("CAN001", "Snicker", 1, CandyBarType.BESTSELLING),
				candyBarFactory.create("CAN001", "Kitkat", 3, CandyBarType.BESTSELLING),
				candyBarFactory.create("CAN001", "ThreeMustkeeters", 2, CandyBarType.WELLESTABLISHED),
				candyBarFactory.create("CAN001", "Reeses", 2, CandyBarType.WELLESTABLISHED),
				candyBarFactory.create("CAN001", "MilkyWay", 3, CandyBarType.BESTSELLING),
				candyBarFactory.create("CAN001", "ButterFinger", 2, CandyBarType.NEWCOMER),
				candyBarFactory.create("CAN001", "Twix", 2, CandyBarType.NEWCOMER)

		);
	}

	/*public List<Product> getAllProductList() {
		initializeProduct();
		return getProductList();
	}*/

	public List<Product> doFruitPricing(CustomerType customerType, Temperature temperature) {

		initializeFruit();
		System.out.println();		
		System.out.println("Fruit Prices for Customer Type: " + customerType + ",Temperature Type: " + temperature);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Fruit Name, Weight, Total Price, Base Price, Sale Price, Fruit Type");
		System.out.println("----------------------------------------------------------------------");
		Map<String,String> paramMap=new HashMap<>();
		paramMap.put("customerType", customerType.toString());
		paramMap.put("temperature", temperature.toString());
		for (Product product : productList) {
			product.configurePricingManager(paramMap);
			double price=product.calculatePrice();
			System.out.println(product.getName() + " / " +product.getWeight()+ " / " +
			price /product.getWeight()+ " / " +product.getBasePrice() + " / " +product.getPrice()+ " /" +((Fruit)product).getFruitType());
		}
		return productList;
	}

	public List<Product> doFlowerPricing(CustomerType customerType, LocalDate purchasingDate) {

		initializeFlower();
		System.out.println();
		System.out.println("Flower Prices for Customer Type: " + customerType + ",Pruchasing Date :" + purchasingDate);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Flower Name, Weight, Total Price, Base Price, Sale Price, Flower Type");
		System.out.println("----------------------------------------------------------------------");
		Map<String,String> paramMap=new HashMap<>();
		paramMap.put("customerType", customerType.toString());
		paramMap.put("purchasingDate", purchasingDate.toString());
		for (Product product : productList) {
			product.configurePricingManager(paramMap);
			double price=product.calculatePrice();
			System.out.println(product.getName() + " / " +product.getWeight()+ " / " +
			price/product.getWeight() + " / " +product.getBasePrice() + " / " +product.getPrice()+ " /" +((Flower)product).getFlowerType());
		}
		return productList;
	}

	public List<Product> doCandyBarPricing(CustomerType customerType, Season season) {

		initializeCandyBar();
		System.out.println();
		System.out.println("CandyBar Prices for Customer Type: " + customerType + ",Season: " + season);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Candy Name, Weight, Total Price, Base Price, Sale Price, Candy Type");
		System.out.println("----------------------------------------------------------------------");
		Map<String,String> paramMap=new HashMap<>();
		paramMap.put("customerType", customerType.toString());
		paramMap.put("season", season.toString());
		for (Product product : productList) {
			product.configurePricingManager(paramMap);
			double price=product.calculatePrice();
			System.out.println(product.getName() + " / " +product.getWeight()+ " / " +
			price/product.getWeight() + " / " +product.getBasePrice() + " / " +product.getPrice()+ " /" +((CandyBar)product).getCandyBarType());
		}
		return productList;
	}
	
	public void restock() throws Exception{
		 
		 dataLoader=new DataLoaderImpl();
		 for(PurchaseRecord purchaseRecord:dataLoader.loadPurchaseRecord()) {
			 switch(purchaseRecord.getItem().getProductType()) {
			 case FLOWER:
				 flowerInitialOrder -= purchaseRecord.getItem().getQuanitity();
				 if(flowerInitialOrder <= 100) 
					 System.out.println(purchaseRecord.getCustomer().getBuyProductDate());
			 break;
			 case FRUIT:
				 fruitInitialOrder -= purchaseRecord.getItem().getQuanitity();
				 if(fruitInitialOrder <= 500) 
					 System.out.println(purchaseRecord.getCustomer().getBuyProductDate());
			break;
			default:
					candyBarInitialOrder -= purchaseRecord.getItem().getQuanitity();
				 if(candyBarInitialOrder <= 300) 
					 System.out.println(purchaseRecord.getCustomer().getBuyProductDate());
		    break;
				 
			 }				 
		 } 
	}
}
