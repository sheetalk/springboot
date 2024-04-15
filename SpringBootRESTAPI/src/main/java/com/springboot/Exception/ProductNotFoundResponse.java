package com.springboot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductNotFoundResponse {
		
		@ResponseBody
		@ExceptionHandler(ProductNotFoundExeption.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
		String productNotFoundResponse(ProductNotFoundExeption exception) {
			return exception.getMessage();
		}
}
