package com.f42o.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public class PreferenceDTO {

	private List<PreferenceItemsDTO> items = new ArrayList<>();

	@JsonProperty("backUrls")
	private BackUrlsDTO backUrls;
	@JsonProperty("paymentMethods")
	private PaymentMethodDTO paymentMethods;

	private PayerDTO payer;
	@JsonProperty("externalReference")
	private String externalReference;
	@JsonProperty("autoReturn")
	private String autoReturn;
	@JsonProperty("notificationUrl")
	private String notificationUrl;

	public PreferenceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreferenceDTO(List<PreferenceItemsDTO> items, BackUrlsDTO backUrls, PaymentMethodDTO paymentMethods,
			PayerDTO payer, String externalReference, String autoReturn, String notificationUrl) {
		this.items = items;
		this.backUrls = backUrls;
		this.paymentMethods = paymentMethods;
		this.payer = payer;
		this.externalReference = externalReference;
		this.autoReturn = autoReturn;
		this.notificationUrl = notificationUrl;
	}

	public List<PreferenceItemsDTO> getItems() {
		return items;
	}

	public void setItems(List<PreferenceItemsDTO> items) {
		this.items = items;
	}

	public BackUrlsDTO getBackUrls() {
		return backUrls;
	}

	public void setBackUrls(BackUrlsDTO backUrls) {
		this.backUrls = backUrls;
	}

	public PaymentMethodDTO getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethodDTO paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public PayerDTO getPayer() {
		return payer;
	}

	public void setPayer(PayerDTO payer) {
		this.payer = payer;
	}

	public String getExternalReference() {
		return externalReference;
	}

	public void setExternalReference(String externalReference) {
		this.externalReference = externalReference;
	}

	public String getAutoReturn() {
		return autoReturn;
	}

	public void setAutoReturn(String autoReturn) {
		this.autoReturn = autoReturn;
	}

	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

}
