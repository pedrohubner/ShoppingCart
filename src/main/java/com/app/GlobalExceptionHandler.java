package com.app;

import com.app.product.exceptionhandler.ProductException;
import com.app.product.models.Product;
import com.app.shoppingcart.exceptionhandler.ShoppingCartException;
import com.app.shoppingcart.models.ShoppingCart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ShoppingCartException.class)
    public ResponseEntity<ShoppingCart> cartNotFound(ShoppingCart shoppingCart) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(shoppingCart);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<Product> productNotFound(Product product) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(product);
    }
}
