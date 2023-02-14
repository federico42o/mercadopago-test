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
import com.mercadopago.resources.preference.Preference;

import jakarta.servlet.http.HttpServletRequest;

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

//http://localhost:8080/?
//	collection_id=1311617794&
//	collection_status=approved&
//	payment_id=1311617794&
//	status=approved&
//	external_reference=null&
//	payment_type=credit_card&
//	merchant_order_id=7690020630&
//	preference_id=241813511-1a7ba6a2-8f00-4b6c-b33e-c9cddc039944&
//	site_id=MLA&processing_mode=aggregator&
//	merchant_account_id=null