package com.bizleap.training.tutorial32;

public class LeastHydratingFruit extends HydratingFruit {

	public LeastHydratingFruit(String name) {
		super(name);
	}
	
	public LeastHydratingFruit(String name, double price,double weight) {
		super(name, price,weight);
	}

	@Override
	protected double calculatePrice(Temperature temperatureCategory) {
		switch(temperatureCategory) {
			case HIGH:
				setPrice(getBasePrice()-(getBasePrice()*0.15));
				break;
			case LOW :
				setPrice(getBasePrice()+(getBasePrice()*0.15));
				break;
			default  :
				setPrice(getBasePrice());
		}
		return getPrice();
	}

	
	
	
	

}
