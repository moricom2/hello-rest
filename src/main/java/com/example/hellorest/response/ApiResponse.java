package com.example.hellorest.response;

import com.example.hellorest.exceptions.ApiError;

public class ApiResponse {

	private String status;
	// private String error;
	private ApiError error;

	public ApiResponse() {
	}

	public ApiResponse(String status, ApiError error) {
		this.status = status;
		this.error = error;
	}

	public ApiResponse(String status, String error) {
		this.status = status;
		this.error = new ApiError(0, "");
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ApiError getError() {
		return error;
	}

	public void setError(ApiError error) {
		this.error = error;
	}

}
