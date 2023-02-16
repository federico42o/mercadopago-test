package com.f42o.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.f42o.app.dto.PayerDTO;
import com.f42o.app.dto.PreferenceDTO;
import com.f42o.app.dto.PreferenceItemsDTO;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.MercadoPagoClient;
import com.mercadopago.client.common.AddressRequest;
import com.mercadopago.client.common.PhoneRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferencePayerRequest;
import com.mercadopago.client.preference.PreferencePaymentMethodRequest;
import com.mercadopago.client.preference.PreferencePaymentMethodsRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.core.MPRequestOptions;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.Headers;
import com.mercadopago.resources.payment.PaymentPayer;
import com.mercadopago.resources.preference.Preference;

@Service
public class PreferenceServiceImpl implements IPreferenceService {
	private static final Logger log = LoggerFactory.getLogger(PreferenceServiceImpl.class);
	@Value("${ACCESS_TOKEN}")
	private String AccessToken;
	@Value("${INTEGRATOR_ID}")
	private String integratorId;

	@Override
	public Preference create(PreferenceDTO dto) throws MPException, MPApiException {

		MercadoPagoConfig.setAccessToken(AccessToken);


		PreferenceClient client = new PreferenceClient();
	    Map<String, String> customHeaders = new HashMap<>();
	    customHeaders.put(Headers.INTEGRATOR_ID, integratorId);

	    MPRequestOptions requestOptions =
	        MPRequestOptions.builder()
	            .customHeaders(customHeaders)
	            .build();
		
		List<PreferenceItemRequest> items = new ArrayList<>();
		for (PreferenceItemsDTO preferenceItem : dto.getItems()) {
			PreferenceItemRequest item = PreferenceItemRequest.builder()
					.id(preferenceItem.getId())
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
			backUrls = PreferenceBackUrlsRequest.builder().success(dto.getBackUrls().getSuccess())
					.pending(dto.getBackUrls().getPending()).failure(dto.getBackUrls().getFailure()).build();
		}

		List<PreferencePaymentMethodRequest> excludedPaymentMethods = new ArrayList<>();
		for (int i = 0; i < dto.getPaymentMethods().getExcludedPaymentMethods().size(); i++) {
			excludedPaymentMethods.add(dto.getPaymentMethods().getExcludedPaymentMethods().get(i));
		}
		PreferencePaymentMethodsRequest preferencePaymentMethodsRequest = PreferencePaymentMethodsRequest.builder()
				.installments(dto.getPaymentMethods().getInstallments()).excludedPaymentMethods(excludedPaymentMethods)
				.build();

		PayerDTO payerDto = dto.getPayer();
		PreferencePayerRequest prefPayer = PreferencePayerRequest.builder().name(payerDto.getName())
				.surname(payerDto.getLastName()).email(payerDto.getEmail())
				.address(AddressRequest.builder().streetName(payerDto.getAddress().getStreetName())
						.streetNumber(payerDto.getAddress().getStreetNumber())
						.zipCode(payerDto.getAddress().getZipCode()).build())
				.phone(PhoneRequest.builder().number(payerDto.getPhone().getNumber())
						.areaCode(payerDto.getPhone().getAreaCode()).build())
				.build();
		PaymentPayerRequest payer = PaymentPayerRequest.builder().email(payerDto.getEmail())
				.lastName(payerDto.getLastName()).firstName(payerDto.getName()).build();
		PaymentPayer pp = new PaymentPayer();
		Map<String, Object> id = new HashMap<>();
		id.put("integratorId", integratorId);
		PreferenceRequest request = PreferenceRequest.builder()

				.items(items)
				.backUrls(backUrls)
				.paymentMethods(preferencePaymentMethodsRequest)
				.externalReference(dto.getExternalReference())
				.autoReturn(dto.getAutoReturn())
//				.notificationUrl(dto.getNotificationUrl())
				.notificationUrl("https://163c-190-137-55-233.sa.ngrok.io/notification")
				.statementDescriptor("Tienda Azul")
				.payer(prefPayer)
				
				.build();

		return client.create(request,requestOptions);
	}

}
