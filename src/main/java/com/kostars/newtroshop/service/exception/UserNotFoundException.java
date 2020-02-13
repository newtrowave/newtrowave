package com.kostars.newtroshop.service.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException() {
        super("user-7", HttpStatus.BAD_REQUEST);
    }
}
