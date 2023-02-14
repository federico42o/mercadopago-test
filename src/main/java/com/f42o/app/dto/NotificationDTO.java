package com.f42o.app.dto;

public class NotificationDTO {
	
	private String id;
	private Boolean liveMode;
	private String type;
	private String dateCreated;
	private String userId;
	private String apiVersion;
	private String action;
	private NotificationDataDTO data;
	public NotificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotificationDTO(String id, Boolean liveMode, String type, String dateCreated, String userId,
			String apiVersion, String action, NotificationDataDTO data) {
		this.id = id;
		this.liveMode = liveMode;
		this.type = type;
		this.dateCreated = dateCreated;
		this.userId = userId;
		this.apiVersion = apiVersion;
		this.action = action;
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getLiveMode() {
		return liveMode;
	}
	public void setLiveMode(Boolean liveMode) {
		this.liveMode = liveMode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public NotificationDataDTO getData() {
		return data;
	}
	public void setData(NotificationDataDTO data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "NotificationDTO [id=" + id + ", liveMode=" + liveMode + ", type=" + type + ", dateCreated="
				+ dateCreated + ", userId=" + userId + ", apiVersion=" + apiVersion + ", action=" + action + ", data="
				+ data + "]";
	}
	
	
	
}
