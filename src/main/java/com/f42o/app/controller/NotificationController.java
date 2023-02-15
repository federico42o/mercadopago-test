package com.f42o.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f42o.app.dto.NotificationDTO;
import com.f42o.app.services.NotificationServiceImpl;
import com.f42o.app.wrapper.ResponseWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.net.Headers;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Value("${INTEGRATOR_ID}")
	private String integratorId;
	NotificationServiceImpl notificationService;

	public NotificationController(NotificationServiceImpl notificationService) {
		this.notificationService = notificationService;
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<ResponseWrapper<String>> getNotification(@RequestBody NotificationDTO dto)
			throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.add(Headers.INTEGRATOR_ID, "dev_24c65fb163bf11ea96500242ac130004");
		notificationService.getNotification(dto);
		ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
				"Notificación recibida con éxito.", null);
		return response.createResponse(headers, HttpStatus.OK);

	}

}
