package com.kostars.newtroshop.service.exception;

import org.springframework.http.HttpStatus;

public class UserFoundException extends BusinessException {
    public UserFoundException() {
        super("user-6", HttpStatus.BAD_REQUEST);
    }
}
