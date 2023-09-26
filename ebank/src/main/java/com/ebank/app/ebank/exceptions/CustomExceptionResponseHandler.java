package com.ebank.app.ebank.exceptions;

import com.ebank.app.ebank.payloads.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
@RestController
public class CustomExceptionResponseHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(Exception.class) // this will handle all types of exception
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        ex.printStackTrace();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), "Validation failed", ex.getLocalizedMessage());
        ex.printStackTrace();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(
            CustomNotFoundException.class) // this will handle only UserNotFoundException(user defined)
    public final ResponseEntity<Object> handleUserNotFoundException(
            Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        ex.printStackTrace();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(
            CustomBadRequestException.class) // this will handle only UserNotFoundException(user defined)
    public final ResponseEntity<Object> handleCustomBadRequestException(
            Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        ex.printStackTrace();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(
            UnauthorizedException.class) // this will handle only UserNotFoundException(user defined)
    public final ResponseEntity<Object> handleUserUnauthorizedException(
            Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        ex.printStackTrace();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
    }

    @Override // overriding to return custom response when validations fail
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        Map<String, String> res = new HashMap<>();
        ex.getBindingResult()
                .getAllErrors()
                .forEach(
                        error -> {
                            String fieldName = ((FieldError) error).getField();
                            String message = error.getDefaultMessage();
                            res.put(fieldName, message);
                        });
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(
                        new Date(), "Validation Failed: " + res, request.getDescription(false));
        ex.printStackTrace();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(CustomNotSavedException.class)
//    protected ResponseEntity<Object> handleDataSavedFailed(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//        ExceptionResponse exceptionResponse =
//                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
//        ex.printStackTrace();
//        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }
}
