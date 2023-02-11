package com.f42o.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.f42o.app.dto.PreferenceDTO;
import com.f42o.app.services.PreferenceService;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

@RestController
@RequestMapping("/test/v1")
public class RestControllerPayment {

	@Autowired
	PreferenceService preferenceService;
	
	@PostMapping("/create")
	public ResponseEntity<Preference> create(@RequestBody PreferenceDTO dto) throws MPException, MPApiException{
		
		Preference preference = preferenceService.create(dto);
		return ResponseEntity.ok().body(preference);
		
		
	}
	
	@PostMapping("/notification_url")
	public ResponseEntity<?> notification(){
		
		return ResponseEntity.status(200).build();
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