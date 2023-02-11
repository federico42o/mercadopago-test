package com.f42o.app.dto;

import java.io.Serializable;
import java.util.List;

public class PreferenceDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private String accessToken;
	private List<PreferenceItems> items;
	
	
	
	
	public PreferenceDTO() {
		super();
	}
	
	
	public PreferenceDTO(String accessToken, List<PreferenceItems> items) {
		this.accessToken = accessToken;
		this.items = items;
	}


	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public List<PreferenceItems> getItems() {
		return items;
	}
	public void setItems(List<PreferenceItems> items) {
		this.items = items;
	}
	
	
	
	
	
}
