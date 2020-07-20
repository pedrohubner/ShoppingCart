package com.app.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionBody> genericException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExceptionBody.builder()
                .message("Ocorreu um erro inesperado")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build());
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionBody> cartNotFound(ApiException apiException) {
        return ResponseEntity.status(apiException.getStatus())
                .body(ExceptionBody.builder()
                .message(apiException.getMessage())
                .status(apiException.getStatus())
                .suggestion(apiException.getSuggestion())
                .build());
    }
}
