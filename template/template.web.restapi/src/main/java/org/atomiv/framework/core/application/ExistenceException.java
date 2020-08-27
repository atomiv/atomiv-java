package org.atomiv.framework.core.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExistenceException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public ExistenceException(String message) {
		super(message);

	}

}