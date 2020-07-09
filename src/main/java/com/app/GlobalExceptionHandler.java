package com.app;

import com.app.product.exceptionhandler.ProductException;
import com.app.shoppingcart.exceptionhandler.ShoppingCartException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ShoppingCartException.class)
    public ResponseEntity<String> cartNotFound(ShoppingCartException e) {
        return ResponseEntity.ok(e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<String> productNotFound(ProductException e) {
        return ResponseEntity.ok(e.getMessage());
    }
}
