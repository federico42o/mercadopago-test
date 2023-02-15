package com.f42o.app.wrapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseWrapper<T> {

    public int status;
    public String message;
    public T body;

    public ResponseEntity<ResponseWrapper<T>> createResponse(HttpStatus status){
        return new ResponseEntity<>(this, status);
    }

	public ResponseWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseWrapper(int status, String message, T body) {
		this.status = status;
		this.message = message;
		this.body = body;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
    

}