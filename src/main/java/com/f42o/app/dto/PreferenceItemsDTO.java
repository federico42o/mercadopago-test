package com.f42o.app.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PreferenceItemsDTO {

	private String id;
	private String title;
	private String description;
	private Integer quantity;
//	@JsonProperty("unit_price")
	private BigDecimal unitPrice;
//	@JsonProperty("picture_url")
	private String pictureUrl;

	public PreferenceItemsDTO() {
		super();

	}

	public PreferenceItemsDTO(String id, String title, String description, Integer quantity, BigDecimal unitPrice, String pictureUrl) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.pictureUrl = pictureUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

}
