package com.example.bms.web.rest.error;

import com.example.bms.service.BMSException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BMSRestAdvice {

    @ExceptionHandler(BMSException.class)
    public ResponseEntity<ApiError> bmsExceptionHandler(BMSException exception) {
        ApiError apiError = new ApiError(exception.getMessage());
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> generalExceptionHandler(Exception exception) {
        ApiError apiError = new ApiError(exception.getMessage());
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }
}
