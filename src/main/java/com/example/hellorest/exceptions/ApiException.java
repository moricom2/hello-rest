package com.example.hellorest.exceptions;

public class ApiException extends RuntimeException {

	private ApiError apiError;
	private String parameter;

	public ApiException(ApiError apiError, String parameter) {
		this.apiError = apiError;
		this.parameter = parameter;
	}

	public int getCode() {
		return apiError.getCode();
	}

	public String getMessage() {
		return apiError.getError() + parameter;
	}

}
