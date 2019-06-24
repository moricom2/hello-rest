package com.example.hellorest.exceptions;

public interface Errors {

	public static final ApiError MISSING_PARAMETER = new ApiError(1001, "Missing Require Parameter : ");

	ApiError INVALID_PARAMETER = new ApiError(1002, "Invalid Parameter : ");

	ApiError INTERNAL_SEVER_ERROR = new ApiError(9999, "Internal Server Error : ");

}
