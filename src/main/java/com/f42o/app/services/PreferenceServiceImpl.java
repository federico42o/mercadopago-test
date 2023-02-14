package com.f42o.app.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.f42o.app.dto.PaymentMethodDTO;
import com.f42o.app.dto.PreferenceDTO;
import com.f42o.app.dto.PreferenceItemsDTO;
import com.google.gson.Gson;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferencePaymentMethodRequest;
import com.mercadopago.client.preference.PreferencePaymentMethodsRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.paymentmethod.PaymentMethod;
import com.mercadopago.resources.preference.Preference;

@Service
public class PreferenceServiceImpl {
	private static final Logger log = LoggerFactory.getLogger(PreferenceServiceImpl.class);
	@Value("${mercadolibre.config.accessToken}")
	private String AccessToken;

	public Preference create(PreferenceDTO dto) throws MPException, MPApiException {

		MercadoPagoConfig.setAccessToken(AccessToken);

		PreferenceClient client = new PreferenceClient();

		List<PreferenceItemRequest> items = new ArrayList<>();
		for (PreferenceItemsDTO preferenceItem : dto.getItems()) {
			PreferenceItemRequest item =  PreferenceItemRequest.builder()
					.title(preferenceItem.getTitle())
					.description(preferenceItem.getDescription())
					.quantity(preferenceItem.getQuantity())
					.unitPrice(preferenceItem.getUnitPrice())
					.pictureUrl(preferenceItem.getPictureUrl())
					.build();
			items.add(item);
		}
		PreferenceBackUrlsRequest backUrls = null;
		if (dto.getBackUrls() != null) {
			backUrls =
					PreferenceBackUrlsRequest
							.builder()
							.success(dto.getBackUrls().getSuccess())
							.pending(dto.getBackUrls().getPending())
							.failure(dto.getBackUrls().getFailure())
							.build();
		}

		List<PreferencePaymentMethodRequest> excludedPaymentMethods = new ArrayList<>();
		for(int i = 0; i<dto.getPaymentMethods().getExcludedPaymentMethods().size();i++) {
			excludedPaymentMethods.add(dto.getPaymentMethods().getExcludedPaymentMethods().get(i));
		}
		PreferencePaymentMethodsRequest preferencePaymentMethodsRequest = PreferencePaymentMethodsRequest.builder()
				.installments(dto.getPaymentMethods().getInstallments())
				.excludedPaymentMethods(excludedPaymentMethods).build();

		
		
		PreferenceRequest request = PreferenceRequest.builder()
				.items(items)
				.backUrls(backUrls)
				.paymentMethods(preferencePaymentMethodsRequest)
				.externalReference(dto.getExternalReference())
				.autoReturn(dto.getAutoReturn())
				.notificationUrl(dto.getNotificationUrl())
				.build();

		return client.create(request);
	}

}
