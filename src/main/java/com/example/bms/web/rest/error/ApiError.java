package com.example.bms.web.rest.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiError {

    private final HttpStatus httpStatus;
    private final Integer httpStatusCode;
    private final String message;
    private final LocalDateTime timestamp;

    public ApiError(String message) {
        this.message = message != null ? message : "Something went wrong.";
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.httpStatusCode = httpStatus.value();
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus httpStatus, String message) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
        this.timestamp = LocalDateTime.now();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "httpStatus=" + httpStatus +
                ", httpStatusCode=" + httpStatusCode +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
