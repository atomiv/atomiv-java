package org.atomiv.template.lite.web.restapi.web;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.exceptions.working.ApplicationException;
import org.atomiv.template.lite.web.restapi.exceptions.working.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.working.TaskNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@ControllerAdvice
@Data
public class GlobalExceptionHandler {

    // handle specific exception
    @ExceptionHandler(ResourceNotFoundException.class)
    // public final
    // public ResponseEntity<Object> -- if using throwable
    // (Exception e)
    public ResponseEntity<ErrorDetails> resourceNotFoundHandling
    (ResourceNotFoundException exception, WebRequest request) {
        // return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        ErrorDetails errorDetails =
                new ErrorDetails(new Date(), // ZonedDateTime.now(ZoneId.of("Z")
//                        exception,
                        HttpStatus.NOT_FOUND.value(),
                        httpStatus,
                        exception.getMessage(),
                        "this is a new message",
                        exception.getClass().getSimpleName(),// getPackageName() = org.atomiv.template.lite.web.restapi.exceptions.working, // getCanonicalName // exception.toString(),
                        request.getDescription(false));
        // (errorDetails, new HttpHeaders(), httpStatus);
        return new ResponseEntity<ErrorDetails>(errorDetails, httpStatus);
    }


    @ExceptionHandler(TaskNotFoundException.class) //@ExceptionHandler(value = { Exception.class })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private Message handleMessage(TaskNotFoundException e) {
        Message message = new Message();
        message.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
        message.setError("Not Found");
        message.setStatus(404);
        message.setException("com.TaskNotFoundException");
        message.setMessage("Unknown Customer");
        return message;
    }

    // TODO ??? same as above, is it better
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public final ResponseEntity<ErrorDetails> ResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//        ErrorDetails error = new ErrorDetails(new Date(), "Not found", ex.getMessage());
//        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
//    }



    // ??
    // handle specific exception
//    @ExceptionHandler(APIException.class)
//    public ResponseEntity<?> handleAPIException
//    (APIException exception, WebRequest request) {
//        ErrorDetails errorDetails =
//                new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }

    // ApplicationException YESSS
//    @ExceptionHandler(ApplicationException.class)
//    public ResponseEntity<?> resourceNotFoundHandling
//            (ApplicationException exception, WebRequest request) {
//        ErrorDetails errorDetails =
//                new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }


    // TODO. handle global exception
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
//        ErrorDetails errorDetails =
//                new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
