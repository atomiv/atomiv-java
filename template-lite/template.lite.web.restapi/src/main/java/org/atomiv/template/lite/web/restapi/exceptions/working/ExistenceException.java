package org.atomiv.template.lite.web.restapi.exceptions.working;

// resource not found
public class ExistenceException extends ApplicationException {
    public ExistenceException(String message) {

        super(message);
    }
}
