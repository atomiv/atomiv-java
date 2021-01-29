package org.atomiv.template.lite.web.restapi.web;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.exceptions.remove.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.working.ApplicationException;
import org.atomiv.template.lite.web.restapi.exceptions.working.ExistenceException;
import org.atomiv.template.lite.web.restapi.exceptions.working.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@Data
public class GlobalExceptionHandler {


    // handle specific exception
    // 404 NOT FOUND
    @ExceptionHandler(ExistenceException.class)
    // public final
    // public ResponseEntity<Object> -- if using throwable
    // (Exception e)
//    ResponseEntity<?>
    public ResponseEntity<ErrorDetails> handleResourceNotFound
    (ExistenceException exception, WebRequest request) {
        // return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        ErrorDetails errorDetails =
                new ErrorDetails(
                        new Date(), // ZonedDateTime.now(ZoneId.of("Z")
//                        exception,
                        httpStatus.value(),
                        httpStatus,
                        exception.getClass().getSimpleName(),// getPackageName() = org.atomiv.template.lite.web.restapi.exceptions.working, // getCanonicalName // exception.toString(),
                        exception.getMessage(),
                        "this is a new message",
                        request.getDescription(false));
        // (errorDetails, new HttpHeaders(), httpStatus);
        return new ResponseEntity<ErrorDetails>(errorDetails, httpStatus);
    }



    // handle specific exception
    // 422 UNPROCESSABLE ENTITY
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException exception, WebRequest request){
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

        ErrorDetails errorDetails =
                new ErrorDetails(
                        new Date(),
                        httpStatus.value(),
                        httpStatus,
                        exception.getMessage(),
                        "this is a new message2",
                        exception.getClass().getSimpleName(),
                        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, httpStatus);
    }



    // TODO. handle global exception
    // 500 INTERNAL SERVER
    // ApplicationException
    // @ExceptionHandler(Exception.class)
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<?> handleApplicationException(ApplicationException exception, WebRequest request){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorDetails errorDetails =
                new ErrorDetails(
                        new Date(),
                        httpStatus.value(),
                        httpStatus,
                        exception.getMessage(),
                        "this is a new message00",
                        exception.getClass().getSimpleName(),
                        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, httpStatus);
    }



//    @ExceptionHandler(TaskNotFoundException.class) //@ExceptionHandler(value = { Exception.class })
//    @ResponseBody
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    private Message handleMessage(TaskNotFoundException e) {
//        Message message = new Message();
//        message.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
//        message.setError("Not Found");
//        message.setStatus(404);
//        message.setException("com.TaskNotFoundException");
//        message.setMessage("Unknown Customer");
//        return message;
//    }


}
