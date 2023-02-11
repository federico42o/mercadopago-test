package com.f42o.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.f42o.app.dto.PreferenceDTO;
import com.f42o.app.dto.PreferenceItems;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferencePaymentMethodsRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

@Service
public class PreferenceService {

	@Value("${mercadolibre.config.accessToken}")
	private String AccessToken;

	public Preference create(PreferenceDTO dto) throws MPException, MPApiException {

		MercadoPagoConfig.setAccessToken(AccessToken);
		PreferenceClient client = new PreferenceClient();

		List<PreferenceItemRequest> items = new ArrayList<>();

		for (PreferenceItems preferenceItem : dto.getItems()) {
			PreferenceItemRequest item = PreferenceItemRequest.builder()
					.title(preferenceItem
					.getTitle())
					.description(preferenceItem.getDescription())
					.quantity(preferenceItem.getQuantity())
					.unitPrice(preferenceItem.getUnitPrice())
					.build();
			items.add(item);
		}
		PreferenceBackUrlsRequest backUrls =
				   PreferenceBackUrlsRequest.builder()
				       .success("http://localhost:8080")
				       .pending("http://localhost:8080")
				       .failure("http://localhost:8080")
				       .build();
//		
//		PreferencePaymentMethodsRequest preferencePaymentMethodsRequest = PreferencePaymentMethodsRequest
//	                .builder().installments(null)

		PreferenceRequest request = PreferenceRequest.builder()
				.items(items)
				.backUrls(backUrls)
				.build();
		
		
		
		return client.create(request);

	}

}
