package com.f42o.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f42o.app.dto.NotificationDTO;
import com.f42o.app.services.NotificationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	final
	NotificationServiceImpl notificationService;

	public NotificationController(NotificationServiceImpl notificationService) {
		this.notificationService = notificationService;
	}

	@CrossOrigin(origins = "*")
	@PostMapping()
	public ResponseEntity<?> getNotification(@RequestBody NotificationDTO dto) throws JsonProcessingException {
		
		notificationService.getNotification(dto);
		
		return ResponseEntity.status(200).build();
		
	}
	
}
