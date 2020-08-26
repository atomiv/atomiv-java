package org.atomiv.template.web.restapi.exception;

import java.util.Date;

import org.atomiv.framework.core.application.ExistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ExistenceException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ExistenceException exception, WebRequest request ) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationErrorHandler(MethodArgumentNotValidException exception) {
	ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Error",
			exception.getBindingResult().getFieldError().getDefaultMessage());
	return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	
	}

}