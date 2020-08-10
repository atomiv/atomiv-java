package org.atomiv.template.core.domain;

public class Product {
	
	private long id;
	private String code;
	private String description;
	private double unitPrice;
	private boolean isListed;
	
	public Product(long id, String code, String description, double unitPrice, boolean isListed) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.unitPrice = unitPrice;
		this.isListed = isListed;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public boolean getIsListed() {
		return isListed;
	}
	public void setIsListed(boolean isListed) {
		this.isListed = isListed;
	}
	
}
