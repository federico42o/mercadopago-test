package com.f42o.app.services;

import com.mercadopago.client.MercadoPagoClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.resources.paymentmethod.PaymentMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.f42o.app.dto.NotificationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadopago.MercadoPagoConfig;

@Service
public class NotificationServiceImpl implements INotificationService{
	private static final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);
	
	@Value("${ACCESS_TOKEN}")
	private String AccessToken;
	@Value("${INTEGRATOR_ID}")
	private String integratorId;
	
	@Override
	public String getNotification(NotificationDTO dto) throws JsonProcessingException {
		
		MercadoPagoConfig.setAccessToken(AccessToken);
		MercadoPagoConfig.setIntegratorId(integratorId);
		 ObjectMapper mapper = new ObjectMapper();
         String json = mapper.writeValueAsString(dto);
         log.info("Notificacion:");
         log.info(json);
		PaymentCreateRequest payment = PaymentCreateRequest.builder().paymentMethodId(dto.getData().getId()).build();

		return json;
		//handle notification here, persist, etc
		
	}

}



