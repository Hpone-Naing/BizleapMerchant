package com.bizleap.merchant.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.bizleap.collection.BLSet;
import com.bizleap.collection.impl.BLBinaryTree;
import com.bizleap.collection.impl.BLHashSet;
import com.bizleap.collection.impl.BLStack;
import com.bizleap.merchant.entities.CandyBar;
import com.bizleap.merchant.entities.Flower;
import com.bizleap.merchant.entities.Fruit;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.enums.CandyBarType;
import com.bizleap.merchant.enums.FlowerType;
import com.bizleap.merchant.enums.FruitType;
import com.bizleap.merchant.enums.ProductType;

public class RandomProductGenerator {

	ProductType[] productTypes=new ProductType[3];
	FruitType[] fruitTypes=new FruitType[3];
	FlowerType[] flowerTypes=new FlowerType[3];
	CandyBarType[] candyBarTypes=new CandyBarType[3];
	List<String> fruitNameList=null;
	List<String> flowerNameList=null;
	List<String> candyBarNameList=null;
	
	public List<String> getFruitNameList(){
		fruitNameList=new ArrayList<>();
		fruitNameList.add("Watermelon");
		fruitNameList.add("Pineapple");
		fruitNameList.add("Blueberry");
		fruitNameList.add("Grape");
		fruitNameList.add("Cherries");
		fruitNameList.add("Honeydew");
		fruitNameList.add("Mango");
		fruitNameList.add("Orange");
		fruitNameList.add("Peach");
		fruitNameList.add("Pear");
		fruitNameList.add("Apple");
		fruitNameList.add("Guava");
		fruitNameList.add("Kiwi");
		fruitNameList.add("Dragonfruit");
		fruitNameList.add("Banana");
		fruitNameList.add("Avocado");
		fruitNameList.add("Jackfruit");
		fruitNameList.add("Breadfruit");
		fruitNameList.add("Passionfruit");
		return fruitNameList;		
	}
	
	public List<String> getFlowerNameList(){
		flowerNameList=new ArrayList<>();
		flowerNameList.add("Rose");
		flowerNameList.add("Lavender");
		flowerNameList.add("CapeJasmine");
		flowerNameList.add("Aster");
		flowerNameList.add("Tulip");
		flowerNameList.add("Orchid");
		flowerNameList.add("Sunflower");
		flowerNameList.add("Lily");
		flowerNameList.add("Dahlia");
		flowerNameList.add("Marigold");
		flowerNameList.add("Buttercup");
		flowerNameList.add("Camelia");
		flowerNameList.add("Tuberose");
		flowerNameList.add("Peony");
		return flowerNameList;
	}
	
	public List<String> getCandyBarNameList(){
		candyBarNameList=new ArrayList<>();
		candyBarNameList.add("Snicker");
		candyBarNameList.add("Kitkat");
		candyBarNameList.add("ThreeMustKeeters");
		candyBarNameList.add("Reeses");
		candyBarNameList.add("Hershey");
		candyBarNameList.add("Milkway");
		candyBarNameList.add("ButterFinger");
		candyBarNameList.add("Twinx");
		return candyBarNameList;
	}
	
	public ProductType[] getProductTypes() {
		productTypes[0]=ProductType.FRUIT;
		productTypes[1]=ProductType.FLOWER;
		productTypes[2]=ProductType.CANDYBAR;
		return productTypes;		
	}
	
	public FruitType[] getFruitTypes() {
		fruitTypes[0]=FruitType.MOSTHYDRATING;
		fruitTypes[1]=FruitType.MEDIUMHYDRATING;
		fruitTypes[2]=FruitType.LEASTHYDRATING;
		return fruitTypes;		
	}
	
	public FlowerType[] getFlowerTypes() {
		flowerTypes[0]=FlowerType.LONGER;
		flowerTypes[1]=FlowerType.MEDIUM;
		flowerTypes[2]=FlowerType.SHORTER;
		return flowerTypes;		
	}
	
	public CandyBarType[] getCandyBarTypes() {
		candyBarTypes[0]=CandyBarType.BESTSELLING;
		candyBarTypes[1]=CandyBarType.WELLESTABLISHED;
		candyBarTypes[2]=CandyBarType.NEWCOMER;
		return candyBarTypes;		
	}
	
	public ProductType getRandomProductType() {
		int index=(int)(Math.random()*getProductTypes().length);
		return getProductTypes()[index];
	}
	
	public FruitType getRandomFruitType() {
		int index=(int)(Math.random()*getFruitTypes().length);
		return getFruitTypes()[index];
	}
	
	public FlowerType getRandomFlowerType() {
		int index=(int)(Math.random()*getFlowerTypes().length);
		return getFlowerTypes()[index];
	}
	
	public CandyBarType getRandomCandyBarType() {
		int index=(int)(Math.random()*getCandyBarTypes().length);
		return getCandyBarTypes()[index];
	}
	
	public int getRandomNumbers(int range) {
		return (int) (Math.random()*range);
	}
	
	public double getRandomWeight() {
		return getRandomNumbers(10);
	}
	
	private String getAFlowerName() {
		return getFlowerNameList().get(getRandomNumbers(flowerNameList.size()));
	}
	
	private String getAFruitName() {
		return getFruitNameList().get(getRandomNumbers(fruitNameList.size()));
	}
	
	private String getACandyBarName() {
		return getCandyBarNameList().get(getRandomNumbers(candyBarNameList.size()));
	}
	
	public Fruit generateAFruit(int n) {
		return (Fruit) new Fruit(getRandomFruitType()).boId("FRU"+String.format("%03d", n)).name(getAFruitName()).weight(getRandomWeight()).basePrice(1);
	}
	
	public Flower generateAFlower(int n) {
		return (Flower) new Flower(getRandomFlowerType()).boId("FLO"+String.format("%03d", n)).name(getAFlowerName()).weight(getRandomWeight()).basePrice(6);
	}
	
	public CandyBar generateACandyBar(int n) {
		return (CandyBar) new CandyBar(getRandomCandyBarType()).boId("CAN"+String.format("%03d", n)).name(getACandyBarName()).weight(getRandomWeight()).basePrice(5);
	}
		
	public Product generateAProduct(int n) {
		
		ProductType productType=getRandomProductType();
		switch(productType) {
			case FRUIT:
				return generateAFruit(n);
			case FLOWER:
				return generateAFlower(n);
			case CANDYBAR:
				return generateACandyBar(n);
			default :
		}	
		return null;
	}
	
	public List<Product> getProductList(int n){
		System.out.println("Product List");
		List<Product> productList=new ArrayList<>();		
		for(int i=0;i<n;i++) {
			productList.add(generateAProduct(i));
		}
		System.out.println("ProductList Generated." + productList.size());
		return productList;
	}
	
	public BLSet<Product> getProducts(int n){
		BLSet<Product> products=new BLHashSet<>();		
		for(int i=0;i<n;i++) {
			products.add(generateAProduct(i));
		}
		return products;
	}
	
	public BLStack<Product> getProductsByStack(int n) {
		BLStack<Product> products = null;
		if (products == null)
			products = new BLStack<Product>();
		for (int i = 0; i < n; i++) {
			products.push(generateAProduct(i));
		}
		return products;
	}
	
	public BLBinaryTree<Product> getProductsByBinaryTree(int n) {
		BLBinaryTree<Product> products = null;
		if (products == null)
			products = new BLBinaryTree<Product>();
		for (int i = 0; i < n; i++) {
			products.insert(generateAProduct(i));
		}
		return products;
	}
}
		

