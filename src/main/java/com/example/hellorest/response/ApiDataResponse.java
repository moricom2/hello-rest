package com.example.hellorest.response;

import com.example.hellorest.exceptions.ApiError;

public class ApiDataResponse extends ApiResponse {

	private Object data;

	public ApiDataResponse() {
		super();
	}

	public ApiDataResponse(String status, Object data, ApiError error) {
		super(status, error);
		this.data = data;
	}

	public ApiDataResponse(String status, Object data, String error) {
		super(status, error);
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
