package com.f42o.app.dto;

public class BackUrlsDTO {

	private String success;

	private String pending;

	private String failure;

	public BackUrlsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BackUrlsDTO(String success, String pending, String failure) {
		this.success = success;
		this.pending = pending;
		this.failure = failure;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getPending() {
		return pending;
	}

	public void setPending(String pending) {
		this.pending = pending;
	}

	public String getFailure() {
		return failure;
	}

	public void setFailure(String failure) {
		this.failure = failure;
	}

}
