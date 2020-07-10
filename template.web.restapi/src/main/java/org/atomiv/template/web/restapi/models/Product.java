package org.atomiv.template.web.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "discription")
	private String discription;
	
	@Column(name = "unitPrice")
	private double unitPrice;
	
	@Column(name = "isListed")
	private boolean isListed;
	
	
	
	public Product() {
		super();
	}
	public Product(long id, String code, String discription, double unitPrice, boolean isListed) {
		super();
		this.id = id;
		this.code = code;
		this.discription = discription;
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
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
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
