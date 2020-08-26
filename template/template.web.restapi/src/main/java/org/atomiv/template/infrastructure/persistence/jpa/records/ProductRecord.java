package org.atomiv.template.infrastructure.persistence.jpa.records;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.atomiv.framework.infrastructure.jpa.Record;

@Entity
@Table(name = "products")
public class ProductRecord extends Record<UUID> {
	
	@NotNull(message = "Code cannot be null")
	@Size(min = 1, max = 10, message = "Code must be max length 10 characters")
	@Column(name = "code")
	private String code;
	
	@NotNull(message = "Description cannot be null")
	@Size(min = 1, max = 100, message = "Description must be max length 100 characters")
	@Column(name = "description")
	private String description;
	
	@PositiveOrZero(message = "The price should be either positive or zero")
	@DecimalMin("0.00")
	@Digits(integer=6, fraction=2)
	@Column(name = "unitPrice")
	private double unitPrice;
	
	@Column(name = "isListed")
	private boolean isListed;
	
	
	
	public ProductRecord() {
		super();
	}
	public ProductRecord(UUID id, String code, String description, double unitPrice, boolean isListed) {
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
	public void setIsListed(boolean isListed) {
		this.isListed = isListed;
	}
	
	

}
