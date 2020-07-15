package com.app.product.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductException extends RuntimeException {

    public ProductException(String msg) {
        super(msg);
    }
}
