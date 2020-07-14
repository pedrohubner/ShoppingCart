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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> genericException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiException.builder()
                .message("Ocorreu um erro inesperado")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .suggestion("Irineu")
                .build());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ShoppingCartException.class)
    public ResponseEntity<ApiException> cartNotFound(ShoppingCartException shoppingCart) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiException.builder()
                .message(shoppingCart.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .suggestion("Digite o id de um carrinho existente")
                .build());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ApiException> productNotFound(ProductException product) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiException.builder()
                .message(product.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .suggestion("Digite o id de um produto existente")
                .build());
    }
}
