package com.bizleap.merchant.enums;

public enum FlowerType {
	LONGER("Longer-shelfLife"),MEDIUM("Medium-shelfLife"),SHORTER("Shorter-shelfLife");
	
	String flowerType;

	private FlowerType(String flowerType) {
		this.flowerType = flowerType;
	}

	public String getFlowerType() {
		return flowerType;
	}

	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}
	

}
