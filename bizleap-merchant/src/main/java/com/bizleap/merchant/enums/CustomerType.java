package com.bizleap.merchant.enums;

public enum CustomerType {
	REGULAR("regular"),VALUE("value"),VOLUME("volume");
	
	private String type;
	
	private CustomerType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
