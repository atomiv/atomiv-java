package org.atomiv.template.lite.web.restapi.web;


import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorDetails {
    // private final ...
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    // private LocalDateTime timestamp;
//    private Throwable throwable;
    private Date timestamp; // private ZonedDateTime timestamp;
    private int status;
    private HttpStatus error; // private String error;
    private String exception;
    private String message;
//    private String customMessage;
    private String path; // details // same as "path"

    public ErrorDetails(//Throwable throwable,
                        Date timestamp,
                        int status,
                        HttpStatus error,
                        String exception,
                        String message,
//                        String customMessage,
                        String path) {
        super();
//        this.throwable = throwable;
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.exception = exception;
        this.message = message;
//        this.customMessage = customMessage;
        this.path = path;
    }

}
