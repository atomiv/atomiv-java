package org.atomiv.template.lite.web.restapi.exceptions.remove;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Resource not found exception
 */
// extends Exception
// extends RuntimeException
public class ResourceNotFoundException extends RuntimeException {

    // would be called in the CustomerServiceImpl
    // in GlobalExceptionHandler can do : exception.getCode();
    private String code;
    /**
     * Instantiate a new Resource not found exception
     *
     * @param message the message
     */
    public ResourceNotFoundException(/*String code,*/ String message) {

        super(message);
//        this.setCode(code);
    }


    //    public ResourceNotFoundException(String exception) {
//
//        super(exception);
//    }

}


