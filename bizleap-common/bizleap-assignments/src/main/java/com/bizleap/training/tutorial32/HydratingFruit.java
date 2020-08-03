package com.bizleap.training.tutorial32;

public abstract class HydratingFruit extends Fruit {
	
	public HydratingFruit() {
		super();
	}

	public HydratingFruit(String name) {
		super(name);
	}
	
	public HydratingFruit(String name, double price,double weight) {
		super(name, price,weight);
	}

	protected abstract double calculatePrice(Temperature temperature);

}
