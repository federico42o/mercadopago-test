package com.f42o.app.services;

import com.f42o.app.dto.NotificationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;



public interface INotificationService {
	
	public String getNotification(NotificationDTO dto) throws JsonProcessingException;

}
