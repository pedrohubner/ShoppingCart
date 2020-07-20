package com.app.exceptionhandler;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApiException extends RuntimeException {

    private final HttpStatus status;
    private final String suggestion;

    public ApiException(String message, HttpStatus status, String suggestion) {
        super(message);
        this.status = status;
        this.suggestion = suggestion;
    }
}
