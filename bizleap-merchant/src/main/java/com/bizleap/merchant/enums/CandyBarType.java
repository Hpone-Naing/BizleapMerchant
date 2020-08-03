package com.bizleap.merchant.enums;

public enum CandyBarType {

	BESTSELLING("Best-Selling Brand"),WELLESTABLISHED("Well-established Brand"),NEWCOMER("New Comer");
	String candyBarType;

	public String getCandyBarType() {
		return candyBarType;
	}

	public void setCandyBarType(String candyBarType) {
		this.candyBarType = candyBarType;
	}

	private CandyBarType(String candyBarType) {
		this.candyBarType = candyBarType;
	}
}
