package com.f42o.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mercadopago.client.preference.PreferencePaymentMethodRequest;
import com.mercadopago.client.preference.PreferencePaymentTypeRequest;

@JsonNaming(SnakeCaseStrategy.class)
public class PaymentMethodDTO {

	@JsonProperty("excludedPaymentMethods")
	private List<PreferencePaymentMethodRequest> excludedPaymentMethods = new ArrayList<>();
	@JsonProperty("excludedPaymentTypes")
	private List<PreferencePaymentTypeRequest> excludedPaymentTypes = new ArrayList<>();
	private int installments;

	public PaymentMethodDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentMethodDTO(List<PreferencePaymentMethodRequest> excludedPaymentMethods,
			List<PreferencePaymentTypeRequest> excludedPaymentTypes, int installments) {
		this.excludedPaymentMethods = excludedPaymentMethods;
		this.excludedPaymentTypes = excludedPaymentTypes;
		this.installments = installments;
	}

	public List<PreferencePaymentMethodRequest> getExcludedPaymentMethods() {
		return excludedPaymentMethods;
	}

	public void setExcludedPaymentMethods(List<PreferencePaymentMethodRequest> excludedPaymentMethods) {
		this.excludedPaymentMethods = excludedPaymentMethods;
	}

	public List<PreferencePaymentTypeRequest> getExcludedPaymentTypes() {
		return excludedPaymentTypes;
	}

	public void setExcludedPaymentTypes(List<PreferencePaymentTypeRequest> excludedPaymentTypes) {
		this.excludedPaymentTypes = excludedPaymentTypes;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}

}
