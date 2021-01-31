package org.atomiv.template.lite.web.restapi.web;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.exceptions.ExistenceException;
import org.atomiv.template.lite.web.restapi.exceptions.ValidationException;
import org.atomiv.template.lite.web.restapi.exceptions.remove.Message;
import org.atomiv.template.lite.web.restapi.exceptions.remove.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@ControllerAdvice
@Data
// TODO JC added extends ResponseEntityExceptionHandler
public class GlobalExceptionHandler {

    // handle specific exception
     @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ExistenceException.class)
    // public final
    // public ResponseEntity<Object> -- if using throwable
    public ResponseEntity<ErrorDetails> handleResourceNotFound
    (ExistenceException exception, WebRequest request) {
        // return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return getResponseEntity(exception, request, httpStatus);
    }



    // handle specific exception
    @ExceptionHandler(ValidationException.class)
//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) // status = 400
//    @ResponseBody
    public ResponseEntity<ErrorDetails> handleValidationException(ValidationException exception, WebRequest request){
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        return getResponseEntity(exception, request, httpStatus);
    }


    // TODO AuthorizationException
    // TODO justification for ApplicationException



    private ResponseEntity<ErrorDetails> getResponseEntity(Exception exception, WebRequest request, HttpStatus httpStatus) {
        var errorDetails = new ErrorDetails(
                new Date(), // ZonedDateTime.now(ZoneId.of("Z")
//                        exception,
                httpStatus.value(),
                httpStatus,
                exception.getClass().getSimpleName(),// getPackageName() = org.atomiv.template.lite.web.restapi.exceptions.working, // getCanonicalName // exception.toString(),
                exception.getMessage(),
                // (errorDetails, new HttpHeaders(), httpStatus);
                request.getDescription(false));

        return new ResponseEntity(errorDetails, httpStatus);
    }


// // TODO return ResponseEntity or your custom Message - VC
    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private Message handleMessage(TaskNotFoundException e) {
        Message message = new Message();
        message.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
        message.setError("Not Found----");
        message.setStatus(404);
        message.setException("com.TaskNotFoundException");
        message.setMessage("Unknown Customer");
        return message;
    }


    // MethodArgumentNotValidException is a subclass of Exception
    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDetails> handleException(Exception exception, WebRequest request){
        HttpStatus httpStatus = HttpStatus.BAD_GATEWAY;
//        exception.setMessage("");
        return getResponseEntity(exception, request, httpStatus);
    }

}
