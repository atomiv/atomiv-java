package org.atomiv.template.lite.web.restapi.exceptions;

import org.atomiv.template.lite.web.restapi.exceptions.ApplicationException;

// resource not found
public class ExistenceException extends ApplicationException {
    public ExistenceException(String message) {

        super(message);
    }
}
