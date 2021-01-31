package org.atomiv.template.lite.web.restapi.exceptions;

import org.atomiv.template.lite.web.restapi.exceptions.ApplicationException;

public class AuthorizationException extends ApplicationException {
    public AuthorizationException(String message) {
        super(message);
    }
}
