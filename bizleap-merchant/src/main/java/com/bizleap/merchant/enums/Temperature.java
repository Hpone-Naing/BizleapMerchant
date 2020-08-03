package com.bizleap.merchant.enums;

public enum Temperature {

	HIGH("High"),MEDIUM("Medium"),LOW("Low");
   private String temperature;
   
	private Temperature(String temperature) {
	this.temperature = temperature;
}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
    
}
