package com.bizleap.training.tutorial32;

import java.util.List;

public class DiscountCalculation{

	
	public double calculateDiscount(Customer customer, Fruit fruit) {
		double totalPrice = totalPrice(customer.getFruitList());
		double totalWeight = totalWeight(customer.getFruitList());
		if(customer.getCustomerType().equals(CustomerType.VALUE))
			return totalPrice-(totalPrice * 0.1);
		if(customer.getCustomerType().equals(CustomerType.VOLUME) && totalWeight>100)
			return fruit.getBasePrice() - (fruit.getBasePrice()*0.15);
		return fruit.getBasePrice();		
	}

	public double totalPrice(List<Fruit> fruitList) {
		double totalPrice=0.0;
		for(Fruit fruit:fruitList) {
			totalPrice += fruit.getPrice();
		}
		return totalPrice;
	}
	
	private double totalWeight(List<Fruit> fruitList) {
		double totalWeight = 0.0;
		for(Fruit fruit:fruitList) {
			totalWeight += fruit.getWeight();
		}
		return totalWeight;
	}
}
