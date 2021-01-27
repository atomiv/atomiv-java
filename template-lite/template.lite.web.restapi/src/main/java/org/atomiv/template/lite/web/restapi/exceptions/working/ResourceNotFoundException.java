package org.atomiv.template.lite.web.restapi.exceptions.working;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Resource not found exception
 */
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Instantiate a new Resource not found exception
     *
     * @param message the message
     */
    public ResourceNotFoundException(String message) {

        super(message);
    }


//    public ResourceNotFoundException(String exception) {
//
//        super(exception);
//    }

}



/*
public class HandledException extends Exception {
    private String code;

    public HandledException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public HandledException(String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

----- in GlobalExceptionHandler can do : exception.getCode();
 */
