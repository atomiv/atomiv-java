package org.atomiv.template.lite.web.restapi.exceptions.working;

// resource not found
public class ExistenceException extends RuntimeException {
    public ExistenceException(String message) {

        super(message);
    }
}
