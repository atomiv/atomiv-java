package org.atomiv.template.lite.web.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Resource not found exception
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    /**
     * Instantiate a new Resource not found exception
     *
     * @param message the message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
