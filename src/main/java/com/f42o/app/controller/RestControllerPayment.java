package com.f42o.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f42o.app.dto.PreferenceDTO;
import com.f42o.app.services.PreferenceServiceImpl;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

@RestController
@RequestMapping("/test/v1")
public class RestControllerPayment {

	private static final Logger log = LoggerFactory.getLogger(RestControllerPayment.class);

	@Autowired
	PreferenceServiceImpl preferenceService;

	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody PreferenceDTO dto) throws MPException, MPApiException {

		return ResponseEntity.status(201).body(preferenceService.create(dto));

	}

}
