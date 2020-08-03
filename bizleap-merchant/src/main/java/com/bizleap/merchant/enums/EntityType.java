package com.bizleap.merchant.enums;

public enum EntityType {

	PRODUCT("product","pro"),
	PURCHASEORDER("purchaseorder","po");
	
	private String boIdPrefix;
	private String value;
	
	private EntityType(String boIdPrefix, String value) {
		this.boIdPrefix = boIdPrefix;
		this.value = value;
	}
	
	public String getBoIdPrefix() {
		return boIdPrefix;
	}
	
	public void setBoIdPrefix(String boIdPrefix) {
		this.boIdPrefix = boIdPrefix;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}	
}
