package com.image.edit.exception;

import org.springframework.http.HttpStatus;

public class ImageException {
    private final String message;

    private final HttpStatus httpStatus;

    public String getMessage() {
        return message;
    }

    public ImageException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
