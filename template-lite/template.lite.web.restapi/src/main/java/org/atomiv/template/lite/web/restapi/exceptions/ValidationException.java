package org.atomiv.template.lite.web.restapi.exceptions;

import org.atomiv.template.lite.web.restapi.exceptions.ApplicationException;

public class ValidationException extends ApplicationException {
    public ValidationException(String message) {
        super(message);
    }
}
