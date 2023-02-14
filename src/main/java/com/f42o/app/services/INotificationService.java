package com.f42o.app.services;

import com.f42o.app.dto.NotificationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;



public interface INotificationService {
	
	public void getNotification(NotificationDTO dto) throws JsonProcessingException;

}
