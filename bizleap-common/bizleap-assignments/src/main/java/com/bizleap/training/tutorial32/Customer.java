package com.bizleap.training.tutorial32;

import java.util.List;

public class Customer{

	String name;
	CustomerType customerType;
	List<Fruit> fruitList;
	
	public Customer() {
		
	}

	public Customer(String name) {
		this.name=name;
		this.customerType=CustomerType.REGULAR;
	}

	public Customer(String name, CustomerType customerType, List<Fruit> fruitList) {
		this.name = name;
		this.customerType = customerType;
		this.fruitList = fruitList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public List<Fruit> getFruitList() {
		return fruitList;
	}

	public void setFruitList(List<Fruit> fruitList) {
		this.fruitList = fruitList;
	}
	
	
	
	

}
