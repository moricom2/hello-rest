package com.example.hellorest.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellorest.response.ApiResponse;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ApiResponse runtimeExceptionHandler(RuntimeException e) {

		if (e instanceof ApiException) {
			ApiException apiException = (ApiException) e;

			ApiResponse response = new ApiResponse();
			response.setStatus("Failed");

			ApiError error = new ApiError(apiException.getCode(), apiException.getMessage());

			response.setError(error);
			return response;
		} else {
			ApiResponse response = new ApiResponse();
			response.setStatus("Failed");

			ApiError error = Errors.INTERNAL_SEVER_ERROR;
			String errorMessage = error.getError();
			errorMessage += e.getMessage();
			error.setError(errorMessage);
			response.setError(error);

			return response;
		}

	}

}
