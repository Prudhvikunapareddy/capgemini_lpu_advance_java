package com.cagemini.category_product.category_product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationException {
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<String> handleException(CategoryNotFoundException ex) {
	return 	new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND); 
	}
}
