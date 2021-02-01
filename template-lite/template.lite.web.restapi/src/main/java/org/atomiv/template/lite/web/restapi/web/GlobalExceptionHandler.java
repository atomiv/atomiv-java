package org.atomiv.template.lite.web.restapi.web;

import lombok.Data;
import org.apache.tomcat.util.http.ResponseUtil;
import org.atomiv.template.lite.web.restapi.exceptions.ExistenceException;
import org.atomiv.template.lite.web.restapi.exceptions.ValidationException;
import org.atomiv.template.lite.web.restapi.exceptions.remove.Message;
import org.atomiv.template.lite.web.restapi.exceptions.remove.TaskNotFoundException;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.Validator;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

@RestControllerAdvice
//@ControllerAdvice
@Data
// TODO JC added extends ResponseEntityExceptionHandler
public class GlobalExceptionHandler {

    // handle specific exception
//    @ResponseStatus(HttpStatus.NOT_FOUND)
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
    @ResponseBody
    public ResponseEntity<ErrorDetails> handleValidationException(ValidationException exception, WebRequest request){
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        return getResponseEntity(exception, request, httpStatus);
    }


    // TODO AuthorizationException
    // TODO justification for ApplicationException


    public static <T> String getValidationMessage(ConstraintViolation<T> violation) {
        String className = violation.getRootBeanClass().getSimpleName();
        String property = violation.getPropertyPath().toString();
        //Object invalidValue = violation.getInvalidValue();
        String message = violation.getMessage();
        // getMessageTemplate()
        return String.format("%s.%s %s", className, property, message);
    }

//    public String getMessageTemplate() {
//        return constraintViolation.getMessageTemplate();
//    }


//    public static List<ValidationError> constraintViolationToValidationErrors(final ConstraintViolationException violation) {
//        return violation.getConstraintViolations().stream().map(violation1 -> new ValidationError(
//                violation1.getMessage(),
//                violation1.getMessageTemplate(),
//                getViolationPath(violation1),
//                getViolationInvalidValue(violation1.getInvalidValue())
//        )).collect(Collectors.toList());
//    }




    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }



    private ResponseEntity<ErrorDetails> getResponseEntity(Exception exception, WebRequest request, HttpStatus httpStatus) {
//        if (exception instanceof ConstraintViolationException) {
//            ConstraintViolationException exs = (ConstraintViolationException) exception;
//            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
//            for (ConstraintViolation<?> item : violations) {
//                String message = ((PathImpl) item.getPropertyPath()).getLeafNode().getName() + item.getMessage();
//                return ResponseUtil.fail(402, message);
//            }
//        }
//        return ResponseUtil.badArgumentValue();
//        }


//    Validator validator = getValidator();
//      validator.validate(testBean).stream().forEach(ValidatedValueExample::printError);

        var errorDetails = new ErrorDetails(
//                exception,
                new Date(), // ZonedDateTime.now(ZoneId.of("Z")
                httpStatus.value(),
                httpStatus,
                exception.getClass().getSimpleName(),// getPackageName() = org.atomiv.template.lite.web.restapi.exceptions.working, // getCanonicalName // exception.toString(),
                exception.getMessage(), // show the interpolated message
//                exception.getMessage(), // TODO: customMessage2 /n
//                exception.setMessage(err),
                request.getDescription(false));

        // (errorDetails, new HttpHeaders(), httpStatus);
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
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDetails> handleException(Exception exception, WebRequest request){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        exception.setMessage("");
        return getResponseEntity(exception, request, httpStatus);
    }

}
