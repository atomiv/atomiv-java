package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.util.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

// candy
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    ErrorMessage exceptionHandler(ValidationException e) {
        return new ErrorMessage("400", e.getMessage());
    }
}
