package com.kostars.newtroshop.service.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends BusinessException {
    public ProductNotFoundException() {
        super("product-7", HttpStatus.BAD_REQUEST);
    }
}
