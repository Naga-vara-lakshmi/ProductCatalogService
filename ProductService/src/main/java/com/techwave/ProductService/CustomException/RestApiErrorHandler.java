package com.techwave.ProductService.CustomException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestApiErrorHandler {
	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApiError resourceNotFoundHandler(ResourceNotFoundException exception) {
		return new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}

}
