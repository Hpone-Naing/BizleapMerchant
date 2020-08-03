package com.bizleap.training.tutorial32;

public class Fruit {

	private String name;
	private double price;
	private double basePrice;
	private double weight;
	
	public Fruit() {
		
	}

	public Fruit(String name) {
		this.name = name;
	}
	
	public Fruit(String name, double price) {
		this.name = name;
		this.price = price;
		this.basePrice = price;
	}

	public Fruit(String name, double price, double weight) {
		this.name = name;
		this.price = price;
		this.basePrice = price;
		this.weight = weight;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Fruit name: " + name ).append( ", $ per pound: " + price ).toString();
	}	
}
