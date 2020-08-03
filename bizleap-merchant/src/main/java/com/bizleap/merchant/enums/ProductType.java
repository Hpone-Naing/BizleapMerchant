package com.bizleap.merchant.enums;

public enum ProductType {
	
	FRUIT("Fruit"),FLOWER("Flower"),CANDYBAR("CandyBar");
	
	private String type;

	private ProductType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
