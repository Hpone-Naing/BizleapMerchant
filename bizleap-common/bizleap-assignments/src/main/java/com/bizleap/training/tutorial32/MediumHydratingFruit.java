package com.bizleap.training.tutorial32;

public class MediumHydratingFruit extends HydratingFruit{

	public MediumHydratingFruit(String name) {
		super(name);
	}
	
	public MediumHydratingFruit(String name, double price,double weight) {
		super(name, price,weight);
	}

	@Override
	protected double calculatePrice(Temperature temperatureCategory) {
		return getPrice();
	}
	
	

	
}
