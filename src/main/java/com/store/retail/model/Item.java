package com.store.retail.model;

public class Item {
	private String upcCode;
	private Enum itemType;
	private double price;
	private String description;

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public Enum getItemType() {
		return itemType;
	}

	public void setItemType(Enum itemType) {
		this.itemType = itemType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
