package com.bizleap.merchant.enums;

public enum FruitType {
	
	MOSTHYDRATING("Most Hydrating Fruit"),MEDIUMHYDRATING("Most Hydrating Fruit"),LEASTHYDRATING("Most Hydrating Fruit");
	
	String fruitType;

	private FruitType(String fruitType) {
		this.fruitType = fruitType;
	}

	public String getFruitType() {
		return fruitType;
	}

	public void setFruitType(String fruitType) {
		this.fruitType = fruitType;
	}
	
	

}
