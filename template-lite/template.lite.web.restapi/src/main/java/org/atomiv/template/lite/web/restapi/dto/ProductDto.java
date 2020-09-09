package org.atomiv.template.lite.web.restapi.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String code;
	private String description;
	private double unitPrice;
	private boolean isListed;

	public ProductDto() {

	}

	public ProductDto(long id, String code, String description, double unitPrice, boolean isListed) {
		super();
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

	public boolean isListed() {
		return isListed;
	}

	public void setListed(boolean isListed) {
		this.isListed = isListed;
	}

}
