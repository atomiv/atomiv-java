package org.atomiv.template.lite.web.restapi.web;


import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorDetails {
    // private final ...
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    // private LocalDateTime timestamp;
    private Date timestamp; // private ZonedDateTime timestamp;
    private int status;
//    private Throwable throwable;
    private HttpStatus error; // private String error;
    private String exception;
    private String message;
    private String path; // details // same as "path"

    public ErrorDetails(Date timestamp,
//                        Throwable throwable,
                        int status,
                        HttpStatus error,
                        String exception,
                        String message,
                        String path) {
        super();
        this.timestamp = timestamp;
        this.status = status;
//        this.throwable = throwable;
        this.error = error;
        this.exception = exception;
        this.message = message;
        this.path = path;
    }

}
