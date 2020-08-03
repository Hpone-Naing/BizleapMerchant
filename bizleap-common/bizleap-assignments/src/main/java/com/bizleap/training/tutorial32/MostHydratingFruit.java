package com.bizleap.training.tutorial32;

public class MostHydratingFruit extends HydratingFruit {

	public MostHydratingFruit(String name) {
		super(name);
	}
	
	public MostHydratingFruit(String name, double price,double weight) {
		super(name, price,weight);
	}

	@Override
	protected double calculatePrice(Temperature temperatureCategory) {
//		if(temperatureCategory == Temperature.HIGH)
//			return getPrice()+(getPrice()*0.15);
//		if(temperatureCategory == Temperature.LOW)
//			return getPrice()-(getPrice()*0.15);
//		return getPrice();
		
		switch(temperatureCategory) {
			case HIGH:
				setPrice(getBasePrice()+(getBasePrice()*0.15));
				break;
			case LOW :
				setPrice(getBasePrice()-(getBasePrice()*0.15));
				break;
			default  :
				setPrice(getBasePrice());
		}
		return getPrice();
	}

	
}
