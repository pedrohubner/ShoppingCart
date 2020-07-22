package com.app.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionBody> genericExceptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExceptionBody.builder()
                        .message("Ocorreu um erro inesperado")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .suggestion(e.getMessage() == null ? "" : e.getMessage())
                        .build());
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionBody> apiExceptionHandler(ApiException apiException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ExceptionBody.builder()
                        .message(apiException.getMessage())
                        .status(apiException.getStatus())
                        .suggestion(apiException.getSuggestion())
                        .build());
    }
}