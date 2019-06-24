package com.example.hellorest.exceptions;

public class ApiError {

	private int code;
	private String error;

	public ApiError(int code, String error) {
		this.code = code;
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
