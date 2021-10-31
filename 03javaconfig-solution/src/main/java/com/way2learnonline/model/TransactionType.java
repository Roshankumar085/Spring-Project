package com.way2learnonline.model;

public enum TransactionType {	

	DEBIT("Debit"),CREDIT("Credit");
	
	private String type;

	private TransactionType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
