package com.f42o.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class PreferenceItems implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	private String title;
	private String description;
	private Integer quantity;
	private BigDecimal unitPrice;
	
	
	
	
	public PreferenceItems() {
		super();

	}
	
	public PreferenceItems(String title, String description, Integer quantity, BigDecimal unitPrice) {
		this.title = title;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	

}
