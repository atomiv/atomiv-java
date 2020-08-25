package org.atomiv.template.core.domain.products;

import org.atomiv.framework.core.domain.Entity;

public class Product extends Entity<ProductIdentity> {
	
	private String code;
	private String description;
	private double unitPrice;
	private boolean isListed;
	
	public Product(ProductIdentity id, String code, String description, double unitPrice, boolean isListed) {
		super(id);
		this.code = code;
		this.description = description;
		this.unitPrice = unitPrice;
		this.isListed = isListed;
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

	public void relist() {
		// TODO: VC: Throw exception if already listed
		this.isListed = true;
	}

	public void unlist() {
		// TODO: VC: Throw exception if already not listed
		this.isListed = false;
	}
	
}
