package com.image.edit.exception;

public class NoEditedImageException extends RuntimeException {
    private String message;

    public NoEditedImageException()
    {}

    public NoEditedImageException(String message)
    {
        super(message);
        this.message=message;
    }
}
