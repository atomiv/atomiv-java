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
    private String message;
    private String customMessage;
    private String exceptionClass; // exception
    private String path; // details // same as "path"

    public ErrorDetails(Date timestamp,
//                        Throwable throwable,
                        int status,
                        HttpStatus error,
                        String message, String customMessage, String exceptionClass, String path) {
        super();
        this.timestamp = timestamp;
        this.status = status;
//        this.throwable = throwable;
        this.error = error;
        this.message = message;
        this.customMessage = customMessage;
        this.exceptionClass = exceptionClass;
        this.path = path;
    }

}
