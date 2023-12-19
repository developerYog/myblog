package com.myblogrestapi.exception;

import com.myblogrestapi.payload.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.function.Predicate;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> resourceNotFound(ResourceNotFoundException ex, WebRequest request){
        ErrorDetail error = new ErrorDetail(new Date(),ex.getMessage(),request.getDescription(true));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
